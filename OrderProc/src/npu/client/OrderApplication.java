package npu.client;
import npu.config.BeanConfig;
import npu.domain.*;
import npu.services.AccountingService;
import npu.services.OrderProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class OrderApplication {
	public static void main1() {
		//using xml files
		ApplicationContext container1;
		OrderProcessor orderProcessor;
		container1 = new ClassPathXmlApplicationContext(
				new String[] {
						"StateTax.xml",
						"Inventory.xml",
						"Order.xml",
						"orderProcessing.xml"
						});
		
		Order order = (Order) container1.getBean("Order1");
		orderProcessor = (OrderProcessor) container1.getBean("orderProcess");
		System.out.println();
		orderProcessor.newOrder(order);
		
		System.out.println("\t\t\t\t\t\t\t Order Details");
		System.out.println("\t\t\t\t\t\t\t================");
		order.toString();
		
		/*container1 = new AnnotationConfigApplicationContext(BeanConfig.class);
		Order order2 = container1.getBean("Order2",Order.class);
		System.out.println(order2.getSubTotal());*/
		
		((ConfigurableApplicationContext)container1).close();
	}
	public static void main2() {
		ApplicationContext container1;
		OrderProcessor orderProcessor;
		
		container1 = new AnnotationConfigApplicationContext(BeanConfig.class);
		Order order2 = container1.getBean("Order2",Order.class);
		order2.toString();
		
		((ConfigurableApplicationContext)container1).close();
	}
	public static void main(String args[]) {
		System.out.println("===================================Using Xml files========================================================");
		main1();
		System.out.println("===================================Using @configuration========================================================");
		//main2();
	}
}
