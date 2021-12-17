package swu.doom.character;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swu.doom.DBUtils;
import swu.doom.PageUtils;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

public class ListCharServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sql = "SELECT * FROM characters ORDER BY id DESC";
		try {
			List<Character> characters = DBUtils.getCharacters(sql);			
			try (Writer writer = response.getWriter()) {
				StringBuilder sb = new StringBuilder();
				sb.append(PageUtils.getBackendHeader());
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
				"<th>编号</th><th>名字</th><th>作品</th><th>性别</th><th>年龄</th><th>能力</th><th>头像</th>" +
				"<th></th><th></th></tr>");
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
			sb.append("<td><img width='100px' src='/VoteSystem/imgs/").append(character.getPics().replaceAll(",", "")).append("'></img></td>");
			sb.append("<td>").append(
					String.format("<a href='./deleteChar?id=%s'>删除</a>", character.getId())
			).append("</td>");			
			sb.append("</tr>");
		}		
		sb.append("</table></center>");
		return sb.toString();
	}
	
}
