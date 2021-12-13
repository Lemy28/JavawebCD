package swu.doom.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter extends HttpFilter {
	
	public final static String LOGIN_STATUS = "LOGIN_STATUS";	
	public final static String LOGIN_VALIDATE_CODE = "LOGIN_VALIDATE_CODE";	

	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws java.io.IOException, ServletException {

		HttpSession session = request.getSession(true);//创建会话
		Boolean status = (Boolean) session.getAttribute(LOGIN_STATUS);//检查登录状态

		if (status == null || status.equals(Boolean.FALSE)) {
			response.sendRedirect("/VoteSystem/login.html");//重定向
		} else {
			chain.doFilter(request, response);
		}
	}

}
