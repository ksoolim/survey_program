package survey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoDao {
	JdbcTemplate jdbctemplate = JdbcTemplate.getInstance();

	public InfoDao() {
	}

	public boolean createinfo() {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "create table \"INFO\"(\"NUMBER\" number primary key, \"AGEGROUP\" number not null, \"SEX\" number not null)";
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

	public boolean insertinfo(InfoVo vo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into \"INFO\" values (?, ?, ?)";
		try {
			conn = jdbctemplate.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getnumber());
			pstmt.setInt(2, vo.getage());
			pstmt.setInt(3, vo.getsex());

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

	public int countinfoage1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcount = 0;

		String sql = "select count(*) from \"INFO\" where \"AGEGROUP\"=1";
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

	public int countinfoage2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcount = 0;

		String sql = "select count(*) from \"INFO\" where \"AGEGROUP\"=2";
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

	public int countinfoage3() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcount = 0;

		String sql = "select count(*) from \"INFO\" where \"AGEGROUP\"=3";
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

	public int countinfosex1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcount = 0;

		String sql = "select count(*) from \"INFO\" where \"SEX\"=1";
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

	public int countinfosex2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcount = 0;

		String sql = "select count(*) from \"INFO\" where \"SEX\"=2";
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

}