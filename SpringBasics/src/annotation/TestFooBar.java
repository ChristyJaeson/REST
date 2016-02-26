package annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * @author Apurav
 *
 */
public class TestFooBar {

	public static void main(String[] args) throws InterruptedException {


		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"annotation/annotation.xml");
		Bar bar = applicationContext.getBean("bar", Bar.class);
		System.out.println("#########################################");
		bar.printFooName();
		applicationContext.registerShutdownHook();
		 
	}

}
