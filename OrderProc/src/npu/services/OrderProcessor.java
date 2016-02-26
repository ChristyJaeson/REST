package npu.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import npu.domain.*;

public class OrderProcessor {
	
	private TaxService acctService;
	private InventoryService invtService;
	private static Logger logger = Logger.getLogger(OrderProcessor.class);
	
	
	
	public OrderProcessor() {}
	//test
	public static void main(String[] args) {
		ApplicationContext container1 = new ClassPathXmlApplicationContext(new String[] {"StateTax.xml","Inventory.xml","Order.xml","orderProcessing.xml"});
		Order order = (Order) container1.getBean("Order1");
		OrderProcessor orderProcessor = (OrderProcessor) container1.getBean("orderProcess");
		orderProcessor.newOrder(order);
	}
	public void newOrder(Order order) {	
		double tax=this.acctService.computeTax(order);
		order.setTax(tax);
		this.invtService.adjustInventory(order);
	}
	public void setAcctService(TaxService acctService) {
		this.acctService = acctService;
	}
	public TaxService getAcctService() {
		return acctService;
	}
	public InventoryService getInvtService() {
		return invtService;
	}
	public void setInvtService(InventoryService invtService) {
		this.invtService = invtService;
	}
}