package swu.doom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import swu.doom.character.Character;

public class DBUtils {
	//链接云服务器上的数据库
	private static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String DB_URL    = "jdbc:mysql://120.25.126.104:3306/javaweb";
	private static String DB_USER   = "root";
	private static String DB_PASS   = "123!@#QWE";
	
	public static void insert(String sql) throws SQLException {
		excute(sql);
	}
	
	public static void delete(String sql) throws SQLException {
		excute(sql);
	}
	
	public static void vote(String sql) throws SQLException {
		excute(sql);
	}
		
	private static void excute(String sql) throws SQLException {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
			try (Statement statement = connection.createStatement()) {
				statement.execute(sql);
			}
		}
	}
	
	public static List<Character> getCharacters(String sql) throws SQLException {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		List<Character> characters = new ArrayList<Character>();
		
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
			try (Statement statement = connection.createStatement()) {
				ResultSet rs = statement.executeQuery(sql);				
				while (rs.next()) {
					Character character = new Character();
					character.setId(rs.getInt("id"));
					character.setName(rs.getString("name"));
					character.setWorks(rs.getString("works"));
					character.setSex(rs.getString("sex"));
					character.setAge(rs.getInt("age"));
					character.setAbility(rs.getString("ability"));
					character.setPics(rs.getString("pics"));
					character.setVotes(rs.getInt("votes"));
					characters.add(character);
				}
			}
		}
		
		return characters;
	}

}
