package hr;

public class EmployeeVo {
	private Long no;
	private String birthDate;
	private String firstName;
	private String lastName;
	private String gender;
	private String hireDate;
	private int salary;
	final Long getNo() {
		return no;
	}
	final void setNo(Long no) {
		this.no = no;
	}
	final String getBirthDate() {
		return birthDate;
	}
	final void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	final String getFirstName() {
		return firstName;
	}
	final void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	final String getLastName() {
		return lastName;
	}
	final void setLastName(String lastName) {
		this.lastName = lastName;
	}
	final String getGender() {
		return gender;
	}
	final void setGender(String gender) {
		this.gender = gender;
	}
	final String getHireDate() {
		return hireDate;
	}
	final void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	final int getSalary() {
		return salary;
	}
	final void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeVo [no=" + no + ", birthDate=" + birthDate + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", hireDate=" + hireDate + ", salary=" + salary + "]";
	}
	
	
}
