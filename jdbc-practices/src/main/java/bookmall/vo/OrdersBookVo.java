package bookmall.vo;

public class OrdersBookVo {
	private int ordersNo;
	private int bookNo;
	private String title;
	private int price;
	private int count;

	@Override
	public String toString() {
		return "OrdersBookVo [ordersNo=" + ordersNo + ", bookNo=" + bookNo + ", title=" + title + ", price=" + price
				+ ", count=" + count + "]";
	}

	public int getOrdersNo() {
		return ordersNo;
	}

	public void setOrdersNo(int ordersNo) {
		this.ordersNo = ordersNo;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
