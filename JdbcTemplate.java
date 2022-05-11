package survey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTemplate {
	private static JdbcTemplate instance; // private�� �����ڽ��� ����
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "survey";
	private String password = "1234";

	// ����Ʈ ������
	private JdbcTemplate() {
		try {
			Class.forName("oracle.jdbc.OracleDriver"); 
			//System.out.println("����̹� �ε� ����!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// �޼ҵ� ����� - ��ü �ϳ��� �����ϱ�
	public static JdbcTemplate getInstance() {
		// synchronized(JdbcTemplate.class) { ��Ƽ������ ���� �� �����ؾ��ؿ�~
		if (instance == null) {
			instance = new JdbcTemplate();
		}
		// }
		return instance;
		// getInstance �޼ҵ带 ���� new JdbcTemplate�� �ʿ���� ��ü��������!
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	} // ����Ŭ �����ͺ��̽� ���� ����!

}
