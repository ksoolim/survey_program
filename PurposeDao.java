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
			// System.out.println("완료");
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

	public int countpurpose1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcount = 0;

		String sql = "select count(*) from \"PURPOSE\" where \"PURPOSE\"=1";
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

	public int countpurpose2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcount = 0;

		String sql = "select count(*) from \"PURPOSE\" where \"PURPOSE\"=2";
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

	public int countpurpose3() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcount = 0;

		String sql = "select count(*) from \"PURPOSE\" where \"PURPOSE\"=3";
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

	public int countpurpose4() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcount = 0;

		String sql = "select count(*) from \"PURPOSE\" where \"PURPOSE\"=4";
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

	public void rankpurpose() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rank = 1;
		int vote = 0;
		int purpose = 0;

		String purpose1 = "1번: 맛집탐방";
		String purpose2 = "2번: 카페투어";
		String purpose3 = "3번: 사진촬영";
		String purpose4 = "4번: 이유없음";

		String sql = "select PURPOSE, COUNT(PURPOSE) FROM \"PURPOSE\" GROUP BY \"PURPOSE\" ORDER BY COUNT(\"PURPOSE\") DESC";
		try {
			conn = jdbctemplate.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				purpose = rs.getInt(1);
				vote = rs.getInt(2);
				System.out.print(rank + "위  -> ");
				if (purpose == 1) {
					System.out.println(purpose1 + "( " + vote + "표 )");
				} else if (purpose == 2) {
					System.out.println(purpose2 + "( " + vote + "표 )");
				} else if (purpose == 3) {
					System.out.println(purpose3 + "( " + vote + "표 )");
				} else {
					System.out.println(purpose4 + "( " + vote + "표 )");
				} rank++;
			}
			

		} catch (

		SQLException e) {
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
	}
}
