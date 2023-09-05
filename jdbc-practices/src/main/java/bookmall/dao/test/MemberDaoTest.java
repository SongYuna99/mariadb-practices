package bookmall.dao.test;

import java.util.List;
import java.util.Scanner;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {
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
		new MemberDao().deleteMember(no);
	}

	private static void doInsert() {
		System.out.print("name >> ");
		String name = scanner.nextLine();
		System.out.print("tel >> ");
		String tel = scanner.nextLine();
		System.out.print("email >> ");
		String email = scanner.nextLine();
		System.out.print("password >> ");
		String password = scanner.nextLine();

		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setTel(tel);
		vo.setEmail(email);
		vo.setPassword(password);
		new MemberDao().insertMember(vo);
	}

	private static void doList() {
		List<MemberVo> list = new MemberDao().findAllMember();

		for (MemberVo vo : list) {
			System.out.print("번호 : " + vo.getNo());
			System.out.print(", 이름 : " + vo.getName());
			System.out.print(", 전화번호 : " + vo.getTel());
			System.out.print(", 이메일 : " + vo.getEmail());
			System.out.println(", 비밀번호 : " + vo.getPassword());
		}
	}
}
