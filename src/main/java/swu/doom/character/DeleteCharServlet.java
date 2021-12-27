package swu.doom.character;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swu.doom.utils.DBUtils;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteCharServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String sql = "DELETE FROM characters WHERE id=" + id;
		
		try {
			DBUtils.delete(sql);
			response.sendRedirect("./backend");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
