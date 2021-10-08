package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrderBookVo;

public class OrderBookDao {
	public boolean insert(OrderBookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();

			// 3. SQL문 준비
			String sql = "insert into order_book values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(binding)
			pstmt.setLong(1, vo.getOrderNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setLong(3, vo.getAmount());
			

			// 5. SQL 실행(하기전에 워크벤치에서 연습)
			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			// clean up
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}
	
	public List<OrderBookVo> findAll() {
		List<OrderBookVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			// 3. SQL문 준비
			String sql = 
					"select * from order_book";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(binding)


			// 5. SQL 실행(하기전에 워크벤치에서 연습)
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Long orderNo = rs.getLong(1);
				Long bookNo = rs.getLong(2);
				Long amount = rs.getLong(3);
				
				OrderBookVo vo = new OrderBookVo();
				vo.setOrderNo(orderNo);
				vo.setBookNo(bookNo);
				vo.setAmount(amount);
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			// clean up
			try {
				if(rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		return conn;
	}
}
