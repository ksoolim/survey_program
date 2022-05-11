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

			pstmt.executeUpdate(); // ���� ����!
			System.out.println("���̺� �����Ϸ�!");
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

			int result = pstmt.executeUpdate(); // ���� ����!
			System.out.println(result + "���� ���ԵǾ����ϴ�");
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

	public boolean counttotal(PurposeVo vo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "select count(\"PP_CODE\") from \"PURPOSE\"";
		try {
			conn = jdbctemplate.getConnection();
			pstmt = conn.prepareStatement(sql);

			int result = pstmt.executeUpdate(); // ���� ����!
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

	public boolean rankplace(PurposeVo vo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "select \"PLACE_CODE\", count(\"PLACE_CODE\") from \"PURPOSE\" group by \"PLACE_CODE\" order by count(\"PLACE_CODE\") asc";
		try {
			conn = jdbctemplate.getConnection();
			pstmt = conn.prepareStatement(sql);

			int result = pstmt.executeUpdate(); // ���� ����!
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

	public boolean rankpurpose(PurposeVo vo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "select \"PURPOSE\", count(\"PURPOSE\") from \"PURPOSE\" group by \"PURPOSE\" order by count(\"PURPOSE\") asc";
		try {
			conn = jdbctemplate.getConnection();
			pstmt = conn.prepareStatement(sql);

			int result = pstmt.executeUpdate(); // ���� ����!
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

			int result = pstmt.executeUpdate(); // ���� ����!
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
