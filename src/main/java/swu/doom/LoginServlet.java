package swu.doom;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet  extends HttpServlet {

    private static final long serialVersionUID = 1198763434511986380L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String code = request.getParameter("code");
        
        HttpSession session = request.getSession(true);
        String validateCode = (String) session.getAttribute(AuthFilter.LOGIN_VALIDATE_CODE);
        if (validateCode == null || !validateCode.equalsIgnoreCase(code)) {
        	response.sendRedirect("/VoteSystem/login.html");
        	return;
        }
        
        if (user != null && pass != null) {
            if (user.equals("admin") && pass.equals("qweasdzxc")) {            	
        		session.setAttribute(AuthFilter.LOGIN_STATUS, Boolean.TRUE);            	
                response.sendRedirect("/VoteSystem/homepage");
            } else {
                response.sendRedirect("/VoteSystem/login.html");
            }
        }
    }
}
