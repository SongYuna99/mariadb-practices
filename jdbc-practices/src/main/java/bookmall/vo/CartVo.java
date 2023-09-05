package bookmall.vo;

public class CartVo {
	private int no;
	private int count;
	private int bookNo;
	private int memberNo;

	private String title;
	private int price;

	@Override
	public String toString() {
		return "CartVo [no=" + no + ", count=" + count + ", bookNo=" + bookNo + ", memberNo=" + memberNo + ", title="
				+ title + ", price=" + price + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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

}
