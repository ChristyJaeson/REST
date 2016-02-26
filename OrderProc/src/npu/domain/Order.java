package npu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import npu.services.InventoryServiceImpl;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Order {
	private String code="-----";
	@Autowired
	@Qualifier(value="CustomerDefault")
	private Customer customer;
	private ArrayList<OrderItem> orderItems= new ArrayList<OrderItem>();
	@Autowired(required=false)
	private Double subTotal,total,tax;
	
	private static Logger logger = Logger.getLogger(Order.class);
		
	public Order(String code, Customer customer, ArrayList<OrderItem> orderItems) {
		super();
		this.setCode(code);
		this.setCustomer(customer);
		this.setOrderItems(orderItems);
	}
	public Order() {
		super();
	}
	public int find(Product p) {
		int size=orderItems.size();
		String toFind=p.getProductID();
	    for(int i=0;i<size;i++){
	    	if(toFind==orderItems.get(i).getProduct().getProductID())
	    		return i;
	    }
	    return -1;
	}
	
	public void Calculate(){
		double sum=0.0;
		int index=0,size=orderItems.size();
		for(; index<size; index++){
			int q=orderItems.get(index).getQuantity();
			double p=orderItems.get(index).getProduct().getPrice();
			sum += q*p;
		}
		this.subTotal=sum;
	}
	
	public void addItem(OrderItem orderItem){
		Product key=orderItem.getProduct();
		int index=find(key);
		if(!( index == -1)){
			this.orderItems.get(index).incrementQuantity(1);
		}else{
			this.orderItems.add(orderItem);
		}
		Calculate();
	}
	
	public void removeProduct(Product key){
		int index=find(key);
		if(!( index == -1)){
			this.orderItems.remove(index);
		}else{
			System.out.println("No Item found");
		}
		Calculate();
	}

	
	public static void main(String []s){
		ApplicationContext container1 = new ClassPathXmlApplicationContext(new String[] {"StateTax.xml","Inventory.xml","Order.xml","orderProcessing.xml"});
		Order o=(Order) container1.getBean("Order1");
		System.out.println("Creating Order...");
		/*o.setCode("SAMPLE");
		Customer c=new Customer(12,"Christy Jaeson","CA");
		Product p1=new Product("F-MLK","Milk",4.89);
		Product p2=new Product("F-CAFE","Coffee",2.49);
		Product p3=new Product("F-TEA","TEA",3.89);
		OrderItem item1= new OrderItem(p1,1);
		OrderItem item2= new OrderItem(p2,1);
		OrderItem item32= new OrderItem(p3,1);
		o.setCustomer(c);
		o.addItem(item1);
		o.addItem(item1);
		o.addItem(item1);
		o.addItem(item2);
		o.addItem(item32);
		o.removeProduct(p1);
		o.removeProduct(p3);*/
		o.toString();
		
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

	@Required
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(ArrayList<OrderItem> orderItems) {
		int index=0;
		for(; index<orderItems.size(); index++){
			this.addItem(orderItems.get(index));
		}
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
		updateTotal();
	}
	
	public void updateTotal(){
		this.setTotal((double)Math.round((this.subTotal+this.subTotal*this.tax/100)*100)/100);
	}

	@Override
	public String toString() {
		Calculate();
		logger.info("CODE : "+this.code);
		logger.info("Customer Details:");
		logger.info(customer.toString());
		logger.info("");
		logger.info("ProductId\tProductName\tPrice\tQuantity");
		int size=orderItems.size();
	    for(int i=0;i<size;i++){
	    	logger.info(orderItems.get(i).toString());
		}
	    logger.info("===================");
	    logger.info("Subtotal : " +this.subTotal);
	    logger.info("TAX : " +this.tax);
	    logger.info("Total : " +this.total);
		return "";
	}
	
	

}
