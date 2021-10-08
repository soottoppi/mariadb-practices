package bookmall.vo;

public class OrderBookVo {
	private Long orderNo;
	private Long bookNo;
	private Long amount;
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
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
		return "OrderBookVo [orderNo=" + orderNo + ", bookNo=" + bookNo + ", amount=" + amount + "]";
	}
	
	
}
