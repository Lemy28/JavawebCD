package swu.doom.user;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import swu.doom.utils.DBUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class SignUpServlet  extends HttpServlet {

	private static final String INSERT_TEMPLATE = 
			"INSERT INTO users (`name`, `password`) " +
			"VALUES ('%s', '%s')";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String name    = request.getParameter("name");	
		String password   = request.getParameter("password");

		String sql = String.format(INSERT_TEMPLATE, name, password);
		System.out.println(sql);
		
		try {
			DBUtils.insert(sql);			
			response.sendRedirect("./login.html");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}