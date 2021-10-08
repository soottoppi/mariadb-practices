package bookmall.dao.test;

import java.util.List;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
//		updateTest();
//		System.out.println("---------------------------");
//		findAllTest();
	}

	private static void insertTest() {
		MemberVo vo = null;
		MemberDao dao = new MemberDao();

		vo = new MemberVo();
		vo.setName("김수형");
		vo.setPhoneNumber("010-1111-1111");
		vo.setEmail("soo@mail.com");
		vo.setPassword(1111L);
		dao.insert(vo);
		
		vo = new MemberVo();
		vo.setName("김고양");
		vo.setPhoneNumber("010-2222-2222");
		vo.setEmail("cat@mail.com");
		vo.setPassword(3333L);
		dao.insert(vo);



	}

	private static void findAllTest() {
		List<MemberVo> list = new MemberDao().findAll();
		for (MemberVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void updateTest() {
		MemberDao dao = new MemberDao();
		dao.update("김수형", 2222L);
	}
}
