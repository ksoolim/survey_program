package survey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			//System.out.println("완료");
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

	public int countplace1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcount = 0;

		String sql = "select count(*) from \"PURPOSE\" where \"PLACE_CODE\"=1";
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

	public int countplace2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcount = 0;

		String sql = "select count(*) from \"PURPOSE\" where \"PLACE_CODE\"=2";
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

	public int countplace3() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcount = 0;

		String sql = "select count(*) from \"PURPOSE\" where \"PLACE_CODE\"=3";
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

	public String etcplace() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String etcplace = "";
		
		String sql = "select \"PLACE\" from \"PLACE\" where \"P_CODE\" > 3";
		try {
			conn = jdbctemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
					
			rs = pstmt.executeQuery();
			if (rs.next()) {
					etcplace = rs.getString(1);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
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
		return etcplace;
	}

}
