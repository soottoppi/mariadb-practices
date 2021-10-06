package hr;

import java.util.List;
import java.util.Scanner;

public class HRMain02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("salary[min max] > ");
		int minSalary= scanner.nextInt();
		int maxSalary= scanner.nextInt();
		
		
		EmployeeDao2 dao = new EmployeeDao2();
		List<EmployeeVo> result = dao.findByname(minSalary, maxSalary);
		
		for(EmployeeVo vo : result) {
			System.out.println(vo.getNo() + ":" + vo.getFirstName() + ":" + vo.getLastName() + ":" + vo.getSalary());
		}
		scanner.close();
	}

}
