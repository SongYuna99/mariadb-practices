package bookmall.main;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrdersDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrdersBookVo;
import bookmall.vo.OrdersVo;

public class BookMallApp {
	private static MemberDao memberDao;
	private static CategoryDao categoryDao;
	private static BookDao bookDao;
	private static CartDao cartDao;
	private static OrdersDao ordersDao;

	public static void main(String[] args) {
		memberDao = new MemberDao();
		categoryDao = new CategoryDao();
		bookDao = new BookDao();
		cartDao = new CartDao();
		ordersDao = new OrdersDao();

		System.out.println("## 회원 리스트");
//		insertMember();
		showMemberList();

		// Category
		System.out.println("## 카테고리 리스트");
//		insertCategory();
		showCategoryList();

		// Book
		System.out.println("## 상품 리스트");
//		insertBook();
		showBookList();

		// Cart
		System.out.println("## 카트 리스트");
//		insertCart();
		showCartList();

		// Orders
		System.out.println("## 주문");
//		insertOrders();
		showOrdersList();
	}

	private static void insertOrders() {
//		OrdersVo order = new OrdersVo();
//
//		order.setMemberNo(7);
//		order.setOrderName("송영준");
//		order.setOrderEmail("yrw2009@naver.com");
//		order.setAddr("서울시 동작구 상도1동");
//		order.setTotalPrice(39000);
//
//		ordersDao.insertOrders(order);

		OrdersBookVo ordersbook1 = new OrdersBookVo();
		OrdersBookVo ordersbook2 = new OrdersBookVo();

		ordersbook1.setBookNo(5);
		ordersbook1.setOrdersNo(1);
		ordersbook1.setTitle("해리포터");
		ordersbook1.setCount(2);
		ordersbook1.setPrice(12000);

		ordersbook2.setBookNo(4);
		ordersbook2.setOrdersNo(1);
		ordersbook2.setTitle("Java 입문");
		ordersbook2.setCount(1);
		ordersbook2.setPrice(15000);

		ordersDao.insertOrdersBook(ordersbook1);
		ordersDao.insertOrdersBook(ordersbook2);

	}

	private static void insertCart() {
		CartVo cart1 = new CartVo();
		CartVo cart2 = new CartVo();

		cart1.setBookNo(4);
		cart1.setCount(5);
		cart1.setMemberNo(7);

		cart2.setBookNo(5);
		cart2.setCount(2);
		cart2.setMemberNo(7);

		cartDao.insertCart(cart1);
		cartDao.insertCart(cart2);

	}

	private static void insertBook() {
		BookVo book1 = new BookVo();
		BookVo book2 = new BookVo();
		BookVo book3 = new BookVo();

		book1.setTitle("Java 입문");
		book1.setPrice(15000);
		book1.setCategoryNo(5);

		book2.setTitle("해리포터");
		book2.setPrice(12000);
		book2.setCategoryNo(6);

		book3.setTitle("부자되기 프로젝트");
		book3.setPrice(21000);
		book3.setCategoryNo(7);

		bookDao.insertBook(book1);
		bookDao.insertBook(book2);
		bookDao.insertBook(book3);

	}

	private static void insertCategory() {
		CategoryVo category1 = new CategoryVo();
		CategoryVo category2 = new CategoryVo();
		CategoryVo category3 = new CategoryVo();

		categoryDao.insertCategory("IT");
		categoryDao.insertCategory("소설");
		categoryDao.insertCategory("경제");
	}

	private static void insertMember() {
		// Member
		MemberVo member1 = new MemberVo();
		MemberVo member2 = new MemberVo();

		member1.setName("송유나");
		member1.setEmail("songyuna99@gmail.com");
		member1.setTel("01022228888");
		member1.setPassword("qwerty1234");

		member1.setName("홍길동");
		member1.setEmail("gildong123@gmail.com");
		member1.setTel("01099995555");
		member1.setPassword("honghong987");

		memberDao.insertMember(member1);
		memberDao.insertMember(member2);
	}

	private static void showOrdersList() {
		int orderNo = 0;
		List<OrdersVo> list = ordersDao.findAllOrders();

		for (OrdersVo vo : list) {
			System.out.print("번호 : " + vo.getNo());
			System.out.print(", 주문자 이름 : " + vo.getOrderName());
			System.out.print(", 주문자 이메일 : " + vo.getOrderEmail());
			System.out.print(", 주소 : " + vo.getAddr());
			System.out.println(", 총 금액 : " + vo.getTotalPrice());
			orderNo = vo.getNo();
		}
		showOrdersBookList(orderNo);
	}

	private static void showOrdersBookList(int orderNo) {
		List<OrdersBookVo> list = new OrdersDao().findAllOrdersBook(orderNo);

		for (OrdersBookVo vo : list) {
			System.out.print("	-> 책 번호 : " + vo.getBookNo());
			System.out.print(", 제목 : " + vo.getTitle());
			System.out.print(", 가격 : " + vo.getPrice());
			System.out.println(", 개수 : " + vo.getCount());
		}
	}

	private static void showCartList() {
		List<CartVo> list = cartDao.findAllCart();

		for (CartVo vo : list) {
			System.out.print("번호 : " + vo.getNo());
			System.out.print(", 회원 번호 : " + vo.getMemberNo());
			System.out.print(", 책 제목 : " + vo.getTitle());
			System.out.print(", 가격 : " + vo.getPrice());
			System.out.print(", 개수 : " + vo.getCount());
			System.out.println(", 합 : " + vo.getPrice() * vo.getCount());
		}
	}

	private static void showBookList() {
		List<BookVo> list = bookDao.findAllBook();

		for (BookVo vo : list) {
			System.out.print("번호 : " + vo.getNo());
			System.out.print(", 제목 : " + vo.getTitle());
			System.out.print(", 가격 : " + vo.getPrice());
			System.out.println(", 카테고리 : " + vo.getCategoryName());
		}
	}

	private static void showCategoryList() {
		List<CategoryVo> list = categoryDao.findAllCategory();

		for (CategoryVo vo : list) {
			System.out.print("번호 : " + vo.getNo());
			System.out.println(", 카테고리 : " + vo.getName());
		}
	}

	private static void showMemberList() {
		List<MemberVo> list = memberDao.findAllMember();

		for (MemberVo vo : list) {
			System.out.print("번호 : " + vo.getNo());
			System.out.print(", 이름 : " + vo.getName());
			System.out.print(", 전화번호 : " + vo.getTel());
			System.out.print(", 이메일 : " + vo.getEmail());
			System.out.println(", 비밀번호 : " + vo.getPassword());
		}
	}
}
