package npu.domain;
import java.beans.ConstructorProperties;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Customer1")
public class Customer {
	private int customerID;
	@Value("${default.name}")
	private String name;
	private String state;
	public Customer() {
	}
	@ConstructorProperties({"customerID","name","state"})
	public Customer(int customerID,String name,String state) {
		this.customerID=customerID;
		this.name=name;
		this.state=state;
	}
	@Required
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return (this.customerID+"\t"+this.name+","+this.state);
	}
	

}
