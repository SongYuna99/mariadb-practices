package bookmall.dao.test;

import java.util.List;
import java.util.Scanner;

import bookmall.dao.BookDao;
import bookmall.dao.CategoryDao;
import bookmall.vo.BookVo;
import bookmall.vo.CategoryVo;

public class BookDaoTest {
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
		System.out.print("no >> ");
		int no = scanner.nextInt();
		new BookDao().deleteBook(no);
	}

	private static void doInsert() {
		showCategories();

		System.out.print("title >> ");
		String title = scanner.nextLine();
		System.out.print("price >> ");
		int price = scanner.nextInt();
		System.out.print("category_no >> ");
		int categoryNo = scanner.nextInt();

		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setCategoryNo(categoryNo);
		new BookDao().insertBook(vo);
	}

	private static void showCategories() {
		List<CategoryVo> list = new CategoryDao().findAllCategory();

		for (CategoryVo vo : list) {
			System.out.print("번호 : " + vo.getNo());
			System.out.println(", 카테고리 : " + vo.getName());
		}
	}

	private static void doList() {
		List<BookVo> list = new BookDao().findAllBook();

		for (BookVo vo : list) {
			System.out.print("번호 : " + vo.getNo());
			System.out.print(", 제목 : " + vo.getTitle());
			System.out.print(", 가격 : " + vo.getPrice());
			System.out.println(", 카테고리 : " + vo.getCategoryName());
		}
	}
}
