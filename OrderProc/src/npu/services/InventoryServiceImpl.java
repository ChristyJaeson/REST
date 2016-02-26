package npu.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import npu.domain.Customer;
import npu.domain.Order;
import npu.domain.OrderItem;
import npu.domain.Product;
@Qualifier(value="InventoryDetails")
@Service("InventoryDetails")
public class InventoryServiceImpl implements InventoryService {

	HashMap<String,Integer> Inventory;
	public static void main(String []s){
		ApplicationContext container1 = new ClassPathXmlApplicationContext("Inventory.xml");
		InventoryServiceImpl s1= (InventoryServiceImpl) container1.getBean("InventoryDetails");
		System.out.println(s1.getInventory().get("CHOC"));
		
	}
	@PostConstruct
	public void init() {
		System.out.println("@Annotaion :PostConstruct");
		System.out.println("Initial Inventory:\n============================");
		this.printCurrentInventory();
	}
	@PreDestroy
	public void cleanUp() {
		System.out.println("@Annotaion :PreDesrtroy");
		System.out.println("Current Inventory:\n============================");
		this.printCurrentInventory();
		
	}
	
	public InventoryServiceImpl(HashMap<String,Integer> Inventory) {
		super();
		this.Inventory=Inventory;
	}

	@Override
	public void adjustInventory(Order order) {
		int size=order.getOrderItems().size();
		for(int index=0;index<size;index++){
			String key=order.getOrderItems().get(index).getProduct().getProductID();
			int quantity=order.getOrderItems().get(index).getQuantity();
			this.Inventory.put(key,  this.Inventory.get(key)-quantity);
		}
		
	}

	public void printCurrentInventory() {
		Iterator iterate = this.Inventory.entrySet().iterator();
		 System.out.println("ProductCode" + "\t" + "Quantity");
	    while (iterate.hasNext()) {
	    	HashMap.Entry<String,Double> pair = (HashMap.Entry<String,Double>)iterate.next();
	        System.out.println(pair.getKey() + "\t\t" + pair.getValue());
	        //iterate.remove(); // avoids a ConcurrentModificationException
	    }
	}
	public HashMap<String, Integer> getInventory() {
		return Inventory;
	}
	public void setInventory(HashMap<String, Integer> inventory) {
		Inventory = inventory;
	}
	
	

}
