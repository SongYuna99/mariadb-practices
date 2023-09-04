package bookmall.dao.test;

import bookshop.dao.BookDao;

public class MemberDaoTest {
	public static void main(String[] args) {
		insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		// TODO Auto-generated method stub
		
	}

	private static void insertTest() {
		BookDao dao = new BookDao();

		dao.insert(bookVo);
	}
}
