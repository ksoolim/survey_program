package survey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlaceDao {
	JdbcTemplate jdbctemplate = JdbcTemplate.getInstance();

	public PlaceDao() {
	}

	public boolean createplace() {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "create table \"PLACE\"(\"P_CODE\" number primary key, \"PLACE\" varchar2(100) not null)";
		try {
			conn = jdbctemplate.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.executeUpdate();

			ret = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return ret;
	}

	public boolean insertplace(PlaceVo vo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into \"PLACE\" values (?, ?)";
		try {
			conn = jdbctemplate.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getpcode());
			pstmt.setString(2, vo.getplace());

			pstmt.executeUpdate();
			System.out.println("완료");
			ret = true;
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return ret;
	}

}
