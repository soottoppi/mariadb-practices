package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
		updateTest();
		System.out.println("---------------------------");
		findAllTest();
	}
	
	private static void insertTest() {
		CategoryVo vo = null;
		CategoryDao dao = new CategoryDao();
		
		vo = new CategoryVo();
		vo.setName("소설");
		dao.insert(vo);
		
		vo = new CategoryVo();
		vo.setName("수필");
		dao.insert(vo);
		
		vo = new CategoryVo();
		vo.setName("컴퓨터/IT");
		dao.insert(vo);
		
		vo = new CategoryVo();
		vo.setName("인문");
		dao.insert(vo);
		
		vo = new CategoryVo();
		vo.setName("경제");
		dao.insert(vo);
		
		vo = new CategoryVo();
		vo.setName("예술");
		dao.insert(vo);
	}
	
	private static void findAllTest() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void updateTest() {
		CategoryDao dao = new CategoryDao();
		dao.update(6L, "문학");
	}
}
