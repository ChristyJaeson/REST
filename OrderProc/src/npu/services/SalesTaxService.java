package npu.services;

import java.awt.image.SampleModel;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import npu.domain.Order;

public class SalesTaxService implements TaxService{
	HashMap<String,Double> stateTax;
	
	//test
	public static void main(String args[]) {
		ApplicationContext container1 = new ClassPathXmlApplicationContext("StateTax.xml");
		SalesTaxService s= (SalesTaxService) container1.getBean("StateTaxDetails");
		System.out.println(s.getStateTax("OR"));
	}
	
	@Override
	public double computeTax(Order order) {
		String state = order.getCustomer().getState();
		Double tax = this.getStateTax(state);
		return tax;
	}
	@Autowired // This is required or else Spring will try using the default constructor
	 public SalesTaxService(@Value("${stateTaxRates.list}") String taxRateListStr) {
		stateTax = convertStringListToMap(taxRateListStr);
	 }
	public HashMap<String,Double> convertStringListToMap(String taxRateListStr){
		HashMap<String,Double> temp = new HashMap<String,Double>();
		
		String[] mapList= taxRateListStr.split(",");
		for(int i=0;i<mapList.length;i=i+2){
			temp.put(mapList[i], Double.parseDouble(mapList[i+1]));
		}		
		System.out.println(temp.get("NV"));
		return temp;
	}
	public HashMap<String, Double> getStateTax() {
		return stateTax;
	}
	public Double getStateTax(String key) {
		return this.stateTax.get(key);
	}
	public void setStateTax(HashMap<String, Double> stateTax) {
		this.stateTax = stateTax;
	}
	

}
