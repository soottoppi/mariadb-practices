package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
//		updateTest();
//		System.out.println("---------------------------");
//		findAllTest();
	}
	
	private static void insertTest() {
		OrderVo vo = null;
		OrderDao dao = new OrderDao();
		
		vo = new OrderVo();
		vo.setOrderNumber(1L);
		vo.setPaymentPrice(330000L);
		vo.setShippingAddress("부산시 금정구");
		vo.setMemberNo(2L);
		dao.insert(vo);
		
	}
	
	private static void findAllTest() {
		List<OrderVo> list = new OrderDao().findAll();
		for(OrderVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void updateTest() {
		OrderDao dao = new OrderDao();
		dao.update(2L, 1L, "부산시 동래구");
	}
}
