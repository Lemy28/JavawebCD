package swu.doom.user;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swu.doom.character.Character;
import swu.doom.filter.AuthFilter;
import swu.doom.utils.DBUtils;
import swu.doom.utils.PageUtils;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

public class LoginServlet  extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String code = request.getParameter("code");
        
        
        
        
        HttpSession session = request.getSession(true);
        String validateCode = (String) session.getAttribute(AuthFilter.LOGIN_VALIDATE_CODE);
        if (validateCode == null || !validateCode.equalsIgnoreCase(code)) {//检查验证码
        	response.sendRedirect("/VoteSystem/login.html");
        	return;
        }
        
        
        //根据用户名在数据库中查找
        String sql = null;
        if (name != null && !name.isEmpty()) {
            sql = "SELECT * FROM `users` WHERE" +
                " `name`='" + name + "'";
        }
        try {
            User user = DBUtils.getUser(sql);
            //检查密码
            if (user.getName() != null && user.getPassword() != null) {
                if (pass.equals(user.getPassword())) { 
                	
            		session.setAttribute(AuthFilter.LOGIN_STATUS, Boolean.TRUE);            	
                    response.sendRedirect("/VoteSystem/voteproject.html");
                } else {
                    response.sendRedirect("/VoteSystem/login.html");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    

       
        
    }
}
