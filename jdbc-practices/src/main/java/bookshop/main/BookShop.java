package bookshop.main;

import java.util.List;
import java.util.Scanner;

public class BookShop {

	public static void main(String[] args) {
		displayBookInfo();

		Scanner scanner = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요:");
		int no = scanner.nextInt();
		scanner.close();

		BookVo vo = new BookVo();
		vo.setNo(no);
		vo.setRent("Y");
		
		new BookDao().updateRent(vo);
		displayBookInfo();
	}

	public static void displayBookInfo() {
		System.out.println("***** 도서 정보 출력 ******");
		
		List<BookVo> list = new BookDao().findAll();
		for (BookVo book : list) {
			System.out.println();
		}
	}
}