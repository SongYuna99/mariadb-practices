package emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import emaillist.vo.EmaillistVo;

public class EmaillistDao {

	public List<EmaillistVo> findAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<EmaillistVo> result = new ArrayList<EmaillistVo>();

		try {
			conn = getConnection();

			// 3. Statement 객체 작성
			String sql = "select no, first_name, last_name, email from emaillist order by no desc";
			pstmt = conn.prepareStatement(sql);

			// 4. SQL 실행
			rs = pstmt.executeQuery();

			// 5. 결과 처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);

				EmaillistVo vo = new EmaillistVo();
				vo.setNo(no);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setEmail(email);

				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQLException : " + e);
		} finally {
			try {
				// 6. 자원 정리
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("SQLException : " + e);
			}
		}

		return result;
	}

	public void insert(EmaillistVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. Statement 객체 작성
			String sql = "insert into emaillist values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());

			// 4. SQL 실행
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQLException : " + e);
		} finally {
			try {
				// 6. 자원 정리
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
	}

	public void deleteByEmail(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. Statement 객체 작성
			String sql = "delete from emaillist where email=?;";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);

			// 4. SQL 실행
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQLException : " + e);
		} finally {
			try {
				// 6. 자원 정리
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
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.0.186:3307/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
