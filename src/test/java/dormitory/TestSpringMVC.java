package dormitory;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.A;
import com.service.AService;
import com.service.TestSpringService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:application-*.xml")
public class TestSpringMVC {
	@Resource
	private TestSpringService testSpringService;
	@Resource
	private AService aService;
	/*@Test
	public void testSpring(){
		testSpringService.testSpring();
	}
	
	@Test 
	public void testHibernate(){
		A a = new A();
		a.setAaid("11");
		a.setName('a');
		testSpringService.saveA(a);
	}*/
	
	@Test
	public void testSpringMVC(){
		
	}
	@Test
	public void testBaseService(){
		A a = new A();
		a.setAaid("1");
		a.setName('a');
		aService.delete(a);
		aService.save(a);
		List<A> list = aService.query();
		List<A> bList = aService.loadByProperty("name", 'a');
		A a1 = aService.loadById(1);
	}
}
