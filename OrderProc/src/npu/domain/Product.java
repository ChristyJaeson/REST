package npu.domain;
import org.springframework.beans.factory.annotation.Required;

public class Product {
	private String productID;
	private String name;
	private Double price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String productID,String name, Double price) {
		this.productID=productID;
		this.name=name;
		this.price=((double)Math.round(price*100))/100;
	}
	public String getProductID() {
		return productID;
	}
	@Required
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	@Required
	public void setPrice(Double price) {
		this.price = ((double)Math.round(price*100))/100;
	}
	@Override
	public String toString() {
		return (this.productID+"\t\t"+this.name+"\t\t"+this.price);
	}

}
