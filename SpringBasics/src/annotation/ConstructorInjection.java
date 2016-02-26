package annotation;

import java.beans.ConstructorProperties;
import java.util.Date;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ConstructorInjection {
	String name;
	int id;
	double gpa;
	@Qualifier("default")
    Order order;
    
    public ConstructorInjection(){}
    
    @ConstructorProperties({"name","id","gpa","order"})
	public ConstructorInjection(String name, int id, double gpa, Order order) {
		super();
		this.name = name;
		this.id = id;
		this.gpa = gpa;
		this.order = order;
		System.out.println("In constructor");
	}
    
	public static void main(String a[]){
		ApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
		
		
		//orderProcessor= new OrderProcessor(); //Legandary Method
		//ConstructorInjection byName = (ConstructorInjection) container.getBean("ConstructorInjectionByName");// Spring Mathod
		//System.out.println(byName.getOrder().getCode());
		
		ConstructorInjection byType = (ConstructorInjection) container.getBean("ConstructorInjectionByType");// Spring Mathod
		System.out.println(byType.getOrder().getCode());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
    

}
