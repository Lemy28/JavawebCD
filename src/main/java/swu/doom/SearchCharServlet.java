package swu.doom;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

public class SearchCharServlet extends HttpServlet {

    private static final long serialVersionUID = 1198763442711986380L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String key = request.getParameter("name");

        String sql = null;
        if (key != null && !key.isEmpty()) {
            sql = "SELECT * FROM `characters` WHERE" +
                " `name` LIKE '%" + key + "%'" +
                " OR `ability` LIKE '%" + key + "%'" +
                " OR `works` = '" + key + "'";
        } else {
            sql = "SELECT * FROM `characters` ORDER BY `id` DESC LIMIT 20";
        }

        try {
            List<Character> characters = DBUtils.getCharacters(sql);
            try (Writer writer = response.getWriter()) {
                StringBuilder sb = new StringBuilder();
                sb.append(PageUtils.getHeader());
                
                sb.append("<center><form action='./homepage' method='GET'>");
                sb.append("<input type='text' name='name'/>&nbsp;&nbsp;&nbsp;");
                sb.append("<input type='submit' value='查询'/>");
                sb.append("</form></center>");

                sb.append(toHtmlTable(characters));
                sb.append(PageUtils.getEnd());
                writer.write(sb.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private String toHtmlTable(List<Character> characters) {
        StringBuilder sb = new StringBuilder();
        sb.append("<center><br><table style='width:70%' border='0' cellpadding='10'>");

        sb.append("<tr style='background-color:#2f6f4f;color:#ffffff'>" +
            "<th>编号</th><th>名字</th><th>作品</th><th>性别</th><th>年龄</th><th>能力</th>" +
            "</tr>");
        for (int i=0; i<characters.size(); i++) {
        	Character character = characters.get(i);
            if (i % 2 == 0) {
                sb.append("<tr style='background-color:#cdcdcd'>");
            } else {
                sb.append("<tr style='background-color:#efefef'>");
            }
            sb.append("<td>").append(character.getId()).append("</td>");
			sb.append("<td><b>").append(character.getName()).append("</b></td>");
			sb.append("<td>").append(character.getWorks()).append("</td>");
			sb.append("<td>").append(character.getSex()).append("</td>");
			sb.append("<td>").append(character.getAge()).append("</td>");
			sb.append("<td>").append(character.getAbility()).append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table></center>");
        return sb.toString();
    }
}
