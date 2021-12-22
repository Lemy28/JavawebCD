package swu.doom.admin;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swu.doom.filter.AuthFilter;

import java.io.IOException;

public class AdminLoginServlet  extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        HttpSession session = request.getSession(true);
        
        if (user != null && pass != null) {
        	
        	
            if (user.equals("huazi") && pass.equals("qweasdzxc")) {   

        		session.setAttribute(AuthFilter.LOGIN_STATUS, Boolean.TRUE);            	
                response.sendRedirect("/VoteSystem/homepage");
            } else {
                response.sendRedirect("/VoteSystem/adminlogin.html");
            }
        }
    }
}
