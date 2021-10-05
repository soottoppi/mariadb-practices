package test;

public class DeptVo {
	private Long no;
	private String name;
	final Long getNo() {
		return no;
	}
	final void setNo(Long no) {
		this.no = no;
	}
	final String getName() {
		return name;
	}
	final void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "DeptVo [no=" + no + ", name=" + name + "]";
	}
	
	
}
