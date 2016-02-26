package npu.services;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import jdk.nashorn.internal.ir.annotations.Reference;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import npu.domain.*;
@Repository("TaxService")
public class AccountingService implements TaxService {
	//VAT Tax Service
	@Resource(name="VAT_KeyValue")
	HashMap<String,Double> VAT_Tax;
	
	//test
	public static void main(String args[]) {
		ApplicationContext container1 = new ClassPathXmlApplicationContext("StateTax.xml");
		AccountingService s= (AccountingService) container1.getBean("VAT_TaxDetails");
		System.out.println(s.getVAT_Tax("OR"));
	}
	@Override
	public double computeTax(Order order) {
		String state = order.getCustomer().getState();
		Double tax = this.getVAT_Tax(state);
		return tax;
	}
	public HashMap<String, Double> getVAT_Tax() {
		return VAT_Tax;
	}
	public Double getVAT_Tax(String key) {
		return this.VAT_Tax.get(key).doubleValue();
	}
	public void setVAT_Tax(HashMap<String, Double> VAT_Tax) {
		this.VAT_Tax = VAT_Tax;
	}

}
