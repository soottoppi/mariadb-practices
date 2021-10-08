package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
//		updateTest();
//		System.out.println("---------------------------");
//		findAllTest();
	}

	private static void insertTest() {
		CartVo vo = null;
		CartDao dao = new CartDao();

		vo = new CartVo();
		vo.setMemberNo(1L);
		vo.setBookNo(2L);
		vo.setAmount(30L);
		dao.insert(vo);

		vo = new CartVo();
		vo.setMemberNo(2L);
		vo.setBookNo(3L);
		vo.setAmount(10L);
		dao.insert(vo);
	}

	private static void findAllTest() {
		List<CartVo> list = new CartDao().findAll();
		for (CartVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void updateTest() {
		CartDao dao = new CartDao();
		dao.update(1L, 2L, 60L);
	}
}
