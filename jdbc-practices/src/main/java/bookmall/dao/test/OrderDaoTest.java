package bookmall.dao.test;

import java.util.List;
import java.util.Scanner;

import bookmall.dao.BookDao;
import bookmall.dao.OrdersDao;
import bookmall.dao.MemberDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.OrdersVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrdersBookVo;

public class OrderDaoTest {
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
		System.out.print("orders_no >> ");
		int no = scanner.nextInt();
		new OrdersDao().deleteOrders(no);
	}

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

//		showCartsByMemberNo(memberNo);
//		System.out.print("cart_no >> ");
//		int cart_no = scanner.nextInt();

//		new OrdersDao().insertCart(vo);
	}

	private static void doList() {
		List<OrdersVo> list = new OrdersDao().findAllOrders();

		for (OrdersVo vo : list) {
			System.out.print("번호 : " + vo.getNo());
			System.out.print(", 주문자 이름 : " + vo.getOrderName());
			System.out.print(", 주문자 이메일 : " + vo.getOrderEmail());
			System.out.print(", 주소 : " + vo.getAddr());
			System.out.print(", 총 금액 : " + vo.getTotalPrice());
			System.out.println(", 주문 개수 : " + vo.getList().size());
			showListDetail(vo.getList());
		}
	}

	private static void showListDetail(List<OrdersBookVo> list) {
		for (OrdersBookVo vo : list) {
			System.out.print("	책 번호 : " + vo.getBookNo());
			System.out.print(", 제목 : " + vo.getTitle());
			System.out.print(", 가격 : " + vo.getPrice());
			System.out.println(", 개수 : " + vo.getCount());
		}
		System.out.println("---------");
	}
}
