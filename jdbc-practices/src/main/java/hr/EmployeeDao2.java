package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao2 {

	public List<EmployeeVo> findByname(int min, int max) {
		List<EmployeeVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			System.out.println("connection 완료");
			// 3. SQL문 준비
			String sql = "select e.emp_no, " + "	e.first_name, " + " 	e.last_name, " + " 	s.salary "
					+ " from employees e, salaries s " + "where e.emp_no = s.emp_no " + " and s.to_date = '9999-01-01' "
					+ " and s.salary >= ? " + " and s.salary <= ? ";
			pstmt = conn.prepareStatement(sql);

			// 4. binding
			pstmt.setInt(1, min);
			pstmt.setInt(2, max);

			// 5. SQL 실행(하기전에 워크벤치에서 연습)

			rs = pstmt.executeQuery();
			while (rs.next()) {
				// rs.get할때는 1번부터 시작
				Long empNo = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				int salary = rs.getInt(4);

				EmployeeVo vo = new EmployeeVo();
				vo.setNo(empNo);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setSalary(salary);

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
