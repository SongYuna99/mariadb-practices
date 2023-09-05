package bookmall.dao.test;

import java.util.List;
import java.util.Scanner;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.MemberDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.MemberVo;

public class CartDaoTest {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.print("(l)ist (i)nsert (d)elete (q)uit >> ");
			String command = scanner.nextLine();

			if ("l".equals(command.toLowerCase())) {
				doList();
			} else if ("i".equals(command.toLowerCase())) {
				doInsert();
			} else if ("d".equals(command.toLowerCase())) {
				doDelete();
			} else if ("q".equals(command.toLowerCase())) {
				break;
			}
		}

		scanner.close();
	}

	private static void doDelete() {
		doList();
		System.out.print("cart_no >> ");
		int no = scanner.nextInt();
		new CartDao().deleteCart(no);
	}

//	private static void showListByMemberNo(int memberNo) {
//		List<CartVo> list = new CartDao().findCartByMemberNo(memberNo);
//
//		for (CartVo vo : list) {
//			System.out.print("번호 : " + vo.getNo());
//			System.out.print(", 회원 번호 : " + vo.getMemberNo());
//			System.out.print(", 책 제목 : " + vo.getTitle());
//			System.out.print(", 가격 : " + vo.getPrice());
//			System.out.print(", 개수 : " + vo.getCount());
//			System.out.println(", 합 : " + vo.getPrice() * vo.getCount());
//		}
//	}

	private static void showMembers() {
		List<MemberVo> list = new MemberDao().findAllMember();

		for (MemberVo vo : list) {
			System.out.print("번호 : " + vo.getNo());
			System.out.print(", 이름 : " + vo.getName());
			System.out.print(", 전화번호 : " + vo.getTel());
			System.out.println(", 이메일 : " + vo.getEmail());
		}
	}

	private static void doInsert() {
		showMembers();
		System.out.print("member_no >> ");
		int memberNo = scanner.nextInt();

		showBooks();
		System.out.print("book_no >> ");
		int bookNo = scanner.nextInt();

		System.out.print("count >> ");
		int count = scanner.nextInt();

		CartVo vo = new CartVo();
		vo.setMemberNo(memberNo);
		vo.setBookNo(bookNo);
		vo.setCount(count);

		new CartDao().insertCart(vo);
	}

	private static void showBooks() {
		List<BookVo> list = new BookDao().findAllBook();

		for (BookVo vo : list) {
			System.out.print("번호 : " + vo.getNo());
			System.out.print(", 제목 : " + vo.getTitle());
			System.out.print(", 가격 : " + vo.getPrice());
			System.out.println(", 카테고리 : " + vo.getCategoryName());
		}
	}

	private static void doList() {
		List<CartVo> list = new CartDao().findAllCart();

		for (CartVo vo : list) {
			System.out.print("번호 : " + vo.getNo());
			System.out.print(", 회원 번호 : " + vo.getMemberNo());
			System.out.print(", 책 제목 : " + vo.getTitle());
			System.out.print(", 가격 : " + vo.getPrice());
			System.out.print(", 개수 : " + vo.getCount());
			System.out.println(", 합 : " + vo.getPrice() * vo.getCount());
		}
	}
}
