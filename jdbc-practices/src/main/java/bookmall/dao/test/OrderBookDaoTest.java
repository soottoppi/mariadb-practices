package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.OrderBookDao;
import bookmall.vo.OrderBookVo;

public class OrderBookDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
//		updateTest();
//		System.out.println("---------------------------");
//		findAllTest();
	}
	
	private static void insertTest() {
		OrderBookVo vo = null;
		OrderBookDao dao = new OrderBookDao();
		
		vo = new OrderBookVo();
		vo.setOrderNo(1L);
		vo.setBookNo(1L);
		vo.setAmount(10L);
		dao.insert(vo);
		
		vo = new OrderBookVo();
		vo.setOrderNo(1L);
		vo.setBookNo(2L);
		vo.setAmount(30L);
		dao.insert(vo);
		
		
	}
	
	private static void findAllTest() {
		List<OrderBookVo> list = new OrderBookDao().findAll();
		for(OrderBookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void updateTest() {
		BookDao dao = new BookDao();
		dao.update(1L, 12000L);
	}
}
