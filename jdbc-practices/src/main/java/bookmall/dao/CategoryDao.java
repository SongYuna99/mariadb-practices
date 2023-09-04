package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CategoryVo;

public class CategoryDao {
	// Insert
	public boolean insertCategory(String categoryName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			// Connection
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.186:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

			// SQL & Statement
			String sql = "insert into category(name) values(?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, categoryName);

			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("SQLException : " + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("SQLException : " + e);
			}
		}
		return result;
	}

	// update
	public boolean updateCategory(CategoryVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			// Connection
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.186:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

			// SQL & Statement
			String sql = "update category set name=? where no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getNo());

			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("SQLException : " + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("SQLException : " + e);
			}
		}
		return result;
	}

	// delete
	public boolean deleteCategory(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			// Connection
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.186:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

			// SQL & Statement
			String sql = "delete from category where no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("SQLException : " + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("SQLException : " + e);
			}
		}
		return result;
	}

	// Select All
	public List<CategoryVo> findAllCategory() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CategoryVo> result = new ArrayList<CategoryVo>();

		try {
			// Connection
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.186:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

			// SQL & Statement
			String sql = "select no, name from category";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);

				CategoryVo category = new CategoryVo();
				category.setNo(no);
				category.setName(name);

				result.add(category);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("SQLException : " + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("SQLException : " + e);
			}
		}
		return result;
	}

	// Select One
	public String findCategoryName(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;

		try {
			// Connection
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.186:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

			// SQL & Statement
			String sql = "select name from category where no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getString(1);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("SQLException : " + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("SQLException : " + e);
			}
		}
		return result;
	}
}
