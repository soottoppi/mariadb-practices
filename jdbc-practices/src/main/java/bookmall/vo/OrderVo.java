package bookmall.vo;

public class OrderVo {
	private Long no;
	private Long orderNumber;
	private Long paymentPrice;
	private String shippingAddress;
	private Long memberNo;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Long getPaymentPrice() {
		return paymentPrice;
	}
	public void setPaymentPrice(Long paymentPrice) {
		this.paymentPrice = paymentPrice;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", orderNo=" + orderNumber + ", paymentPrice=" + paymentPrice + ", shippingAddress="
				+ shippingAddress + ", memberNo=" + memberNo + "]";
	}
	
}
