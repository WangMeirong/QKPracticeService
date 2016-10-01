package practice;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qk.practice.model.Practice;
import com.qk.practice.service.IPracticeService;


@RunWith(SpringJUnit4ClassRunner.class)		//琛ㄧず缁ф壙浜哠pringJUnit4ClassRunner绫�
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class PracticeServiceTest {
	private static Logger logger = Logger.getLogger(PracticeServiceTest.class);
	@Resource
	private IPracticeService practiceService = null;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

	@Test
	public void test1() {
		Practice p = practiceService.getPracticeById("f396c64c-865b-11e6-89fa-e03f4931fd4d");
//		p.setCode("practice_test4");
//		practiceService.updatePracticeById(p);
		System.err.println(p.toString());
//		System.err.println("delete====="+practiceService.deletePracticeById("f396c64c-865b-11e6-89fa-e03f4931fd4d"));
//		p.setDescription("tttttttest");;
//		System.err.println("insert====="+practiceService.insertPractice(p));
		List<Practice> ps = practiceService.getPractices(p);
//		logger.info("ps========"+JSON.toJSONString(ps));
		System.err.println(ps.get(0).toString());
	}
}
