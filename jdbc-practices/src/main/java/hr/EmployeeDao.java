package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	public List<EmployeeVo> findByname(String name) {
		List<EmployeeVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 3. SQL문 준비
			String sql = "select emp_no, " + "		first_name, " + "		last_name, "
					+ "		date_format(hire_date, '%Y-%m-%d')" + "	from employees " + "where first_name like ?"
					+ "	or last_name like ?";
			pstmt = conn.prepareStatement(sql);

			// 4. binding
			pstmt.setString(1, "%" + name + "%");
			pstmt.setString(2, "%" + name + "%");

			// 5. SQL 실행(하기전에 워크벤치에서 연습)

			rs = pstmt.executeQuery();
			while (rs.next()) {
				// rs.get할때는 1번부터 시작
				Long empNo = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String hireDate = rs.getString(4);

				EmployeeVo vo = new EmployeeVo();
				vo.setNo(empNo);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setHireDate(hireDate);

				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			// clean up
			try {
				if (rs != null) {
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
			String url = "jdbc:mysql://127.0.0.1:3306/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		return conn;
	}
}
