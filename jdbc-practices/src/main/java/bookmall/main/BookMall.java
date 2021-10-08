package bookmall.main;

import bookmall.dao.test.BookDaoTest;
import bookmall.dao.test.CartDaoTest;
import bookmall.dao.test.CategoryDaoTest;
import bookmall.dao.test.MemberDaoTest;
import bookmall.dao.test.OrderBookDaoTest;
import bookmall.dao.test.OrderDaoTest;

public class BookMall {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		System.out.println("--------- 회원 리스트 --------");
		new MemberDaoTest().main(args);
		
		System.out.println("\n--------- 카테고리 리스트 --------");
		new CategoryDaoTest().main(args);
		
		System.out.println("\n--------- 상품 리스트 --------");
		new BookDaoTest().main(args);
		
		System.out.println("\n--------- 카트 리스트 --------");
		new CartDaoTest().main(args);
		
		System.out.println("\n--------- 주문 리스트 --------");
		new OrderDaoTest().main(args);
		
		System.out.println("\n--------- 주문상품 리스트 --------");
		new OrderBookDaoTest().main(args);
	}
}
