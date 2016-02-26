package npu.config;

import npu.domain.Customer;
import npu.domain.Order;
import npu.domain.OrderItem;
import npu.domain.Product;
import npu.services.OrderProcessor;
import npu.services.SalesTaxService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({"classpath:property.properties"})
@Scope("prototype")
public class BeanConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public Customer CustomerA(){
		Customer customer_A=new Customer();
		customer_A.setCustomerID(100);
		customer_A.setName("Joshua");
		customer_A.setState("UK");
		return customer_A;
	}
	public Product ProductA(){
		Product Product_A=new Product();
		Product_A.setProductID("X-Box");
		Product_A.setName("PLAY");
		Product_A.setPrice(100.99);
		return Product_A;
	}
	
	/*
	<bean id="Order1" class="npu.domain.Order">
	<property name="code" value="AX-SAMPLE"/>
	<property name="customer" ref="Customer1"/>
	<property name="orderItems">
		<list>
        	<ref bean="Item1" />
        	<ref bean="Item1" />
        	<ref bean="Item2" />
        	<ref bean="Item2" />
        	<ref bean="Item3" />            	                
    	</list>
	</property>
	</bean>
	*/
	@Bean
	public Order Order2(){
		Order order2=new Order();
		order2.setCode("BeanConf");
		order2.setCustomer(CustomerA());
		OrderItem o= new OrderItem();
		o.setProduct(ProductA());
		o.setQuantity(3);
		order2.addItem(o);
		return order2;		
	}
	
}
