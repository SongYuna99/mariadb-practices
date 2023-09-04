package bookmall.vo;

public class OrdersVo {
	private int no;
	private String orderName;
	private String orderEmail;
	private int totalPrice;
	private String addr;
	private int memberNo;

	@Override
	public String toString() {
		return "OrdersVo [no=" + no + ", orderName=" + orderName + ", orderEmail=" + orderEmail + ", totalPrice="
				+ totalPrice + ", addr=" + addr + ", memberNo=" + memberNo + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderEmail() {
		return orderEmail;
	}

	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

}
