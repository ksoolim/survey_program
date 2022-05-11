package survey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTemplate {
	private static JdbcTemplate instance; // private로 본인자신을 참조
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "survey";
	private String password = "1234";

	// 디폴트 생성자
	private JdbcTemplate() {
		try {
			Class.forName("oracle.jdbc.OracleDriver"); 
			//System.out.println("드라이버 로딩 성공!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 메소드 만들기 - 객체 하나만 생성하기
	public static JdbcTemplate getInstance() {
		// synchronized(JdbcTemplate.class) { 멀티스레딩 추후 더 공부해야해용~
		if (instance == null) {
			instance = new JdbcTemplate();
		}
		// }
		return instance;
		// getInstance 메소드를 사용시 new JdbcTemplate할 필요없이 객체생성가능!
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	} // 오라클 데이터베이스 접속 성공!

}
