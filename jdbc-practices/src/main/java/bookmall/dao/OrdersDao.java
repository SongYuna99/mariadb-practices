package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrdersVo;

public class OrdersDao {
	// Insert
	public boolean insertOrders(OrdersVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			// Connection
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.186:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

			// SQL & Statement
			String sql = "insert into orders(order_name, order_email, total_price, addr, member_no) "
					+ "values(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getOrderName());
			pstmt.setString(2, vo.getOrderEmail());
			pstmt.setInt(3, vo.getTotalPrice());
			pstmt.setString(4, vo.getAddr());
			pstmt.setInt(5, vo.getMemberNo());

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
	public boolean updateOrders(OrdersVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			// Connection
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.186:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

			// SQL & Statement
			String sql = "update orders set order_name=?, order_email=?, " + "total_price=?, addr=? where no=? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getOrderName());
			pstmt.setString(2, vo.getOrderEmail());
			pstmt.setInt(3, vo.getTotalPrice());
			pstmt.setString(4, vo.getAddr());
			pstmt.setInt(5, vo.getNo());

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
	public boolean deleteOrders(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			// Connection
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.186:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

			// SQL & Statement
			String sql = "delete from orders where no=?";
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
	public List<OrdersVo> findAllOrders() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrdersVo> result = new ArrayList<OrdersVo>();

		try {
			// Connection
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.186:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

			// SQL & Statement
			String sql = "select no, order_name, order_email, " + "" + "total_price, addr, member_no from orders";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String orderName = rs.getString(2);
				String orderEmail = rs.getString(3);
				int totalPrice = rs.getInt(4);
				String addr = rs.getString(5);
				int memberNo = rs.getInt(6);

				OrdersVo orders = new OrdersVo();
				orders.setNo(no);
				orders.setOrderName(orderName);
				orders.setOrderEmail(orderEmail);
				orders.setTotalPrice(totalPrice);
				orders.setAddr(addr);
				orders.setMemberNo(memberNo);

				result.add(orders);
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
