package com.npu.myproject.domain;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
@XmlRootElement(name = "deal")
public class Deal {

	private int id;
	@Size(min=2, max=30)
	private int price;
	
	private int discount;
	private String event;
	@NotEmpty
	private String dates;
	@NotEmpty
	private String location_code;
	@NotEmpty
	private String place;

public Deal()
{
		
}
	public Deal(int id,String location_code, int price, int discount, String event,
			String dates, String place) {
		this.id=id;
		this.location_code=location_code;
		this.price=price;
		this.discount=discount;
		this.event=event;
		this.dates=dates;
		this.place=place;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getlocation_code() {
		return location_code;
	}

	public void setlocation_code(String location_code) {
		this.location_code = location_code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String toString(){
		String dealstr="Deal[" +id+" "+location_code + " " +price + " " +discount+ " " +event + " " +dates + " " +place+ "]";
		return dealstr;			
	}
	public boolean equals(Object otherObj) {
		Deal othrDeal;
		
		if (!(otherObj instanceof Deal)) return false;
		othrDeal = (Deal) otherObj;
		return (id == othrDeal.id && location_code.equals(othrDeal.location_code) && price==othrDeal.price
				&& discount==othrDeal.discount && event.equals(othrDeal.event) && dates.equals(othrDeal.dates)
				&& place.equals(othrDeal.place));
		
	}
}
