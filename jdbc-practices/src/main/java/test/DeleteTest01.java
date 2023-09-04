package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest01 {

	public static void main(String[] args) {
		boolean result = deleteDepartmentByNo(9L);
		System.out.println(result ? "성공" : "실패");
	}

	private static boolean deleteDepartmentByNo(Long no) {
		boolean result = false;
		Connection conn = null;
		Statement stmt = null;

		try {
			// 1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.0.186:3307/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. Statement 객체 작성
			stmt = conn.createStatement();

			// 4. SQL 실행
			String sql = "delete from dept where no = " + no;

			int count = stmt.executeUpdate(sql);
			result = count == 1;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("SQLException : " + e);
		} finally {
			try {
				// 6. 자원 정리
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.out.println("SQLException : " + e);
			}
		}

		return result;
	}
}
