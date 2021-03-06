package swu.doom.validatecode;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swu.doom.filter.AuthFilter;

public class ValidateCodeServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	HttpSession session = request.getSession(true);
    	
    	ValidateCode coder = new ValidateCode();    	
    	session.setAttribute(AuthFilter.LOGIN_VALIDATE_CODE, coder.getCodeString());    	
    	response.setContentType("image/png");
    	try (OutputStream output = response.getOutputStream()) {
    		coder.outputCodeImage(output);
    	}
    }

}
