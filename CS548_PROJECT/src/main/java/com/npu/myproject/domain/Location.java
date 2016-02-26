package com.npu.myproject.domain;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;


@XmlRootElement(name = "location")
public class Location {

	private int id;
	@Size(min=2, max=30)
	  private String code;
	@NotEmpty
	  private String name;
	@NotEmpty
	  private String city;
	@NotEmpty
	  private String country;
	@NotEmpty
	  
	  public Location(){
	  }
	  
	
	  public Location(String name, String city, String country, String code) {
		this.name=name;
		this.city=city;
		this.country=country;
		this.code=code;
		
	}

	public int getId() {
	    return id;
	  }
	
	  public void setId(int id) {
	    this.id = id;
	  }
	  
	  public String getCode() {
		    return code;
	  }
	
	  public void setCode(String code) {
	    this.code = code;
	  }
	  
	  public String getName() {
	    return name;
	  }
	
	  public void setName(String name) {
	    this.name = name;
	  }
	
	  public String getCity() {
	    return city;
	  }
	
	  public void setCity(String city) {
	    this.city = city;
	  }
	
	  public String getCountry() {
	    return country;
	  }
	
	  public void setCountry(String country) {
	    this.country = country;
	  }

	
}
