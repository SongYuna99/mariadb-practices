package bookshop.vo;

public class BookVo {
	private int no;
	private String title;
	private String rent;
	private int authorNum;
	private String author;

	@Override
	public String toString() {
		return "책 번호 : " + no + ", 제목 : " + title + ", 작가 : " + author + ", 대여 유무 : "
				+ ((rent.equals("N")) ? "재고있음]" : "대여중]");
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public int getAuthorNum() {
		return authorNum;
	}

	public void setAuthorNum(int authorNum) {
		this.authorNum = authorNum;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
