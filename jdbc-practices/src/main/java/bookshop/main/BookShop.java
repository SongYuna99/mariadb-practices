package bookshop.main;

import java.util.List;
import java.util.Scanner;

import bookshop.dao.BookDao;
import bookshop.vo.BookVo;

public class BookShop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		displayBookInfo();

		while (true) {
			System.out.print("-->대여 하고 싶은 책의 번호를 입력하세요: ");
			int no = scanner.nextInt();

			if (no == -1) {
				scanner.close();
				break;
			}

			BookVo vo = new BookVo();
			vo.setNo(no);
			vo.setRent("Y");

			if (new BookDao().updateRent(vo)) {
				System.out.println("대여 완료.\n\n");
			} else {
				System.out.println("존재하지 않거나 이미 대여중인 책입니다.\n\n");
			}
			displayBookInfo();
		}
	}

	public static void displayBookInfo() {
		System.out.println("***** 도서 정보 출력 ******");

		List<BookVo> list = new BookDao().findAll();
		for (BookVo book : list) {
			System.out.println(book);
		}
	}
}
