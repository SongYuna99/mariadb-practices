package bookmall.main;

public class BookMall {
	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();

		memberDao.insert(membervo1);
		memberDao.insert(membervo2);

		System.out.println("## 회원 리스트");
		
		System.out.println("## 카테고리 리스트");
		
		System.out.println("## 상품 리스트");
		// 제목, 가격
		
		System.out.println("## 카트 리스트");
		// 도서 제목, 수량, 가격
		
		System.out.println("## 주문");
		// 주문 번호(order_no), 주문자(이름, 이메일), 결제금액, 배송지
	}
}
