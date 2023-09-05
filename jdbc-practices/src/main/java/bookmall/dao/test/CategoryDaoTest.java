package bookmall.dao.test;

import java.util.List;
import java.util.Scanner;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest {
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
		new CategoryDao().deleteCategory(no);
	}

	private static void doInsert() {
		System.out.print("name >> ");
		String name = scanner.nextLine();

		CategoryVo vo = new CategoryVo();
		vo.setName(name);
		new CategoryDao().insertCategory(name);
	}

	private static void doList() {
		List<CategoryVo> list = new CategoryDao().findAllCategory();

		for (CategoryVo vo : list) {
			System.out.print("번호 : " + vo.getNo());
			System.out.println(", 카테고리 : " + vo.getName());
		}
	}
}
