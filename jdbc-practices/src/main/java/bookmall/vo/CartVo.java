package bookmall.vo;

public class CartVo {
	private Long memberNo;
	private Long bookNo;
	private Long amount;

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "CartVo [memberNo=" + memberNo + ", bookNo=" + bookNo + ", amount=" + amount + "]";
	}
}