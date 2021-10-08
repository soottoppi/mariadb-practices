package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
//		updateTest();
//		System.out.println("---------------------------");
//		findAllTest();
	}
	
	private static void insertTest() {
		BookVo vo = null;
		BookDao dao = new BookDao();
		
		vo = new BookVo();
		vo.setTitle("클라이밍의 정석");
		vo.setPrice(15000L);
		vo.setCategoryNo(6L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("대겸이의 하루");
		vo.setPrice(8000L);
		vo.setCategoryNo(2L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("자바의 정석");
		vo.setPrice(33000L);
		vo.setCategoryNo(3L);
		dao.insert(vo);
		
	}
	
	private static void findAllTest() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void updateTest() {
		BookDao dao = new BookDao();
		dao.update(1L, 12000L);
	}
}
