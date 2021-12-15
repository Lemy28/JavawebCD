package swu.doom.character;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import swu.doom.DBUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class AddCharServlet extends HttpServlet {

	private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 5;  
	private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; 
	private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; 
	private static final String UPLOAD_DIRECTORY = "imgs";

	private static final String INSERT_TEMPLATE = 
			"INSERT INTO characters (`name`, `works`, `age`, `sex`, `ability`, `pics`) " +
			"VALUES ('%s', '%s', %s, '%s', '%s', '%s')";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String name    = request.getParameter("name");	
		String works   = request.getParameter("works");
		String age    = request.getParameter("age");
		String sex     = request.getParameter("sex");
		String ability = request.getParameter("ability");



		// 检测是否为多媒体上传
		if (!ServletFileUpload.isMultipartContent(request)) {
			PrintWriter writer = response.getWriter();
			writer.println("Error: 表单必须包含 enctype=multipart/form-data");
			writer.flush();
			return;
		}

		// 配置上传参数
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
				factory.setSizeThreshold(MEMORY_THRESHOLD);
				// 设置临时存储目录
				factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

				ServletFileUpload upload = new ServletFileUpload(factory);
				// 设置最大文件上传值
				upload.setFileSizeMax(MAX_FILE_SIZE);
				// 设置最大请求值 (包含文件和表单数据)
				upload.setSizeMax(MAX_REQUEST_SIZE);
				// 中文处理
				upload.setHeaderEncoding("UTF-8");	
				// 构造临时路径来存储上传的文件
				// 这个路径相对当前应用的目录
				String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
				// 如果目录不存在则创建
				File uploadDir = new File(uploadPath);
				if (!uploadDir.exists()) {
					uploadDir.mkdir();
				}



		String pics = "";
		try {
			// 解析请求的内容提取文件数据
			List<FileItem> formItems = upload.parseRequest(request);
			
			if (formItems != null && formItems.size() > 0) {
				// 迭代表单数据
				for (FileItem item : formItems) {
					// 处理不在表单中的字段
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						String filePath = uploadPath + File.separator + fileName;
						File storeFile = new File(filePath);
						System.out.println(filePath);
						item.write(storeFile);
						pics += fileName + ",";
					} else {
					
						if (item.getFieldName().equals("name")) {
							name = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("works")) {
							works = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("age")) {
							age = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("sex")) {
							sex = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("ability")) {
							ability = item.getString("UTF-8");
						}
					}
				}
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		String sql = String.format(INSERT_TEMPLATE, name, works, age, sex, ability, pics);
		System.out.println(sql);
		
		try {
			DBUtils.insert(sql);			
			response.sendRedirect("./backend");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}



