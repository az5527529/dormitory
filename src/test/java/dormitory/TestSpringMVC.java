package dormitory;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.A;
import com.service.TestSpringService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:application-*.xml")
public class TestSpringMVC {
	@Resource
	private TestSpringService testSpringService;
	
	@Test
	public void testSpring(){
		testSpringService.testSpring();
	}
	
	@Test 
	public void testHibernate(){
		A a = new A();
		a.setAaid("11");
		a.setName('a');
		testSpringService.saveA(a);
	}
	
	@Test
	public void testSpringMVC(){
		
	}
}
