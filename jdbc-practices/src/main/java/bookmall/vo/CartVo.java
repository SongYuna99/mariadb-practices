package bookmall.vo;

public class CartVo {
	private int no;
	private int count;
	private int bookNo;
	private int memberNo;

	@Override
	public String toString() {
		return "CartVo [no=" + no + ", count=" + count + ", bookNo=" + bookNo + ", memberNo=" + memberNo + "]";
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

}
