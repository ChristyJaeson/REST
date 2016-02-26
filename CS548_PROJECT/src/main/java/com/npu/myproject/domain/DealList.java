package com.npu.myproject.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DealList implements Serializable{
private static final long serialVersionUID = 1L;
	
	// XmlElement sets the name of the entities
	@XmlElement(name = "Flight")
	private List<Deal> dealList1 ;

	public DealList() {
	}
	
	public List<Deal> getDealList1() {
		return dealList1;
	}

	public void setdealList1(List<Deal> newdealList1) {
		this.dealList1 = newdealList1;
	}
	
	public int numEntries() {
		if (dealList1 == null) return 0;
		return dealList1.size();
	}
	
	public Deal getDeal(int idx) {
		return dealList1.get(idx);
	}
	
	public String toString() {
		String listStr;
		
		listStr = "dealList1{";
		for (Deal entry: dealList1) {
			listStr = listStr + "\n\t" + entry;
		}
		
		listStr = listStr + "\n}";
		return listStr;
	}
}