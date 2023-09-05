package emaillist.main;

import java.util.List;
import java.util.Scanner;

import emaillist.dao.EmaillistDao;
import emaillist.vo.EmaillistVo;

public class EmaillistApp {
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
		System.out.print("email >> ");
		String email = scanner.nextLine();
		new EmaillistDao().deleteByEmail(email);
	}

	private static void doInsert() {
		System.out.print("firstname >> ");
		String firstName = scanner.nextLine();
		System.out.print("lastname >> ");
		String lastName = scanner.nextLine();
		System.out.print("email >> ");
		String email = scanner.nextLine();

		EmaillistVo vo = new EmaillistVo();
		vo.setFirstName(firstName);
		vo.setLastName(lastName);
		vo.setEmail(email);
		new EmaillistDao().insert(vo);
	}

	private static void doList() {
		List<EmaillistVo> list = new EmaillistDao().findAll();

		for (EmaillistVo vo : list) {
			System.out.print("이름 : " + vo.getFirstName() + vo.getLastName());
			System.out.println(", 이메일 : " + vo.getEmail());
		}
	}

}
