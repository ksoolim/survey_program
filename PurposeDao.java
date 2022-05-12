package survey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurposeDao {
	JdbcTemplate jdbctemplate = JdbcTemplate.getInstance();

	public PurposeDao() {
	}

	public boolean createpurpose() {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "create table \"PURPOSE\"(\"PP_CODE\" number primary key, \"INFO_NUMBER\" number, \"PLACE_CODE\" number, \"PURPOSE\" number not null, constraint \"FK_INFO_NUMBER\" foreign key(\"INFO_NUMBER\") references \"INFO\"(\"NUMBER\") on delete cascade, constraint \"FK_PLACE_CODE\" foreign key(\"PLACE_CODE\") references \"PLACE\"(\"P_CODE\") on delete cascade)";

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

	public boolean insertpurpose(PurposeVo vo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into \"PURPOSE\" values (?, ?, ?, ?)";
		try {
			conn = jdbctemplate.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getppcode());
			pstmt.setInt(2, vo.getinfonumber());
			pstmt.setInt(3, vo.getplacecode());
			pstmt.setInt(4, vo.getpurpose());

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

	public int counttotal() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcount = 0;

		String sql = "select count(\"PP_CODE\") from \"PURPOSE\"";
		try {
			conn = jdbctemplate.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				resultcount = rs.getInt(1);
			}

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
		return resultcount;
	}

	public String rankplace() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = "";

		String sql = "select \"PLACE_CODE\" from \"PURPOSE\" group by \"PLACE_CODE\" order by count(\"PLACE_CODE\") desc";
		try {
			conn = jdbctemplate.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getString("PLACE_CODE");
			}
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
		return result;
	}

	public boolean rankpurpose(PurposeVo vo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "select \"PURPOSE\", count(\"PURPOSE\") from \"PURPOSE\" group by \"PURPOSE\" order by count(\"PURPOSE\") asc";
		try {
			conn = jdbctemplate.getConnection();
			pstmt = conn.prepareStatement(sql);

			int result = pstmt.executeUpdate();
			System.out.println(result);
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

	public boolean resultage1(PurposeVo vo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "select \"PLACE_CODE\" from \"PURPOSE\" group by \"PLACE_CODE\" having count(*) = (select max(\"top\") from (select ��PLACE_CODE��, count(*) as \"top\" from \"PURPOSE\" group by \"PLACE_CODE\") as result)";
		try {
			conn = jdbctemplate.getConnection();
			pstmt = conn.prepareStatement(sql);

			int result = pstmt.executeUpdate();
			System.out.println(result);
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
