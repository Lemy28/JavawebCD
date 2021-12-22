package swu.doom.character;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swu.doom.utils.DBUtils;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

public class AjaxListServlet  extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String all = request.getParameter("all");

        int offset = (Integer.valueOf(all).intValue()) * 8;

        String sql = "SELECT * FROM characters ORDER BY votes DESC LIMIT 20 OFFSET " + offset;

        System.out.println(sql);

        try {
            List<Character> characters = DBUtils.getCharacters(sql);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            try(Writer writer = response.getWriter()) {
                writer.write(this.toJson(characters));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String toJson(List<Character> characters) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"characters\": [");

        for(int i=0; i<characters.size(); i++) {
            Character character = characters.get(i);
            if (i > 0) sb.append(",");
            sb.append(String.format(
                "{\"id\": %s, \"name\": \"%s\",\"works\": \"%s\",\"age\": %s,\"sex\": \"%s\",\"ability\": \"%s\",\"votes\":%s,\"pics\":\"%s\"}",
                character.getId(), character.getName(), character.getWorks(), character.getAge(), character.getSex(), character.getAbility(),character.getVotes(),character.getPics().replaceAll(",", "")
            ));
        }
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }
}