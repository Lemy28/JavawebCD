package swu.doom.character;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swu.doom.DBUtils;

import java.io.IOException;
import java.sql.SQLException;

public class VoteCharServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String sql = "UPDATE characters SET votes=votes+1 WHERE id=" + id;
		
		try {
			DBUtils.vote(sql);
			System.out.println(sql);
			response.sendRedirect("./voteto.jsp");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}