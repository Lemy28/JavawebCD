package swu.doom.user;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet  extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String code = request.getParameter("code");
        
        HttpSession session = request.getSession(true);
        String validateCode = (String) session.getAttribute(AuthFilter.LOGIN_VALIDATE_CODE);
        if (validateCode == null || !validateCode.equalsIgnoreCase(code)) {//检查验证码
        	response.sendRedirect("/VoteSystem/login.html");
        	return;
        }
        
        if (user != null && pass != null) {
            if (user.equals("huazi") && pass.equals("qweasdzxc")) {            	
        		session.setAttribute(AuthFilter.LOGIN_STATUS, Boolean.TRUE);            	
                response.sendRedirect("/VoteSystem/homepage");
            } else {
                response.sendRedirect("/VoteSystem/login.html");
            }
        }
    }
}
