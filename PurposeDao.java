package survey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurposeDao {
	JdbcTemplate jdbctemplate = JdbcTemplate.getInstance();

	public PurposeDao() {
	}

	public boolean createpurpose(PurposeVo vo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "create table \"PURPOSE\"(\"PP_CODE\" number primary key, \"INFO_NUMBER\" number, \"PLACE_CODE\" number, \"PURPOSE\" number not null, constraint \"FK_INFO_NUMBER\" foreign key(\"INFO_NUMBER\") references \"INFO\"(\"NUMBER\") on delete cascade, constraint \"FK_PLACE_CODE\" foreign key(\"PLACE_CODE\") references \"PLACE\"(\"P_CODE\") on delete cascade";

		try {
			conn = jdbctemplate.getConnection();
			pstmt = conn.prepareStatement(sql);

			System.out.println(sql);

			pstmt.executeUpdate(); // 쿼리 전송!
			System.out.println("테이블 생성완료!");
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
	public boolean insertpurpose(PurposeVo vo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into \"PURPOSE\" values (?, ?, ?, ?)";
		try {
			conn = jdbctemplate.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getppcode());
			pstmt.setInt(2, vo.getinfonumber());
			pstmt.setInt(3, vo.getplacecode());
			pstmt.setInt(3, vo.getpurpose());
			System.out.println(sql);

			int result = pstmt.executeUpdate(); // 쿼리 전송!
			System.out.println(result + "행이 삽입되었습니다");
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

}
