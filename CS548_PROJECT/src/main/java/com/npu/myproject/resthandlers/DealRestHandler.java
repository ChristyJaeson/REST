package com.npu.myproject.resthandlers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.npu.myproject.domain.Deal;
import com.npu.myproject.domain.DealList;
import com.npu.myproject.exceptions.UnknownResourceException;
import com.npu.myproject.services.DealService;

@Path("/")
public class DealRestHandler {
	@Autowired
	@Qualifier("dealservice")
	private DealService dealservice;
	private Logger logger = Logger.getLogger(DealRestHandler.class);
    
	
	/* Return a list of all the students
	 * Matching Url:
	 * http://localhost:8080/myproject/webservices/deal
	 * See web.xml file for Jersey configuration
	 */
	
	@GET
	@Path("/deal/{id}")
	@Produces("application/xml, application/json")
	public Deal getStudent(@PathParam("id") int id) {
		Deal deal = null;
		
		try {
			deal = dealservice.findDealByDealId(id);
		} catch (Exception ex) {
			throw new WebApplicationException(ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
		}
		System.out.println(deal);
		if (deal == null) {
			logger.debug("Failed Request to lookup deal with id  : " + id);
			throw new UnknownResourceException("Student id: " + id + " is invalid");
		}
		
		return deal;
	}
	
	@GET
	@Path("/deal")
	@Produces("application/xml")
	public List<Deal> getDealList()
	{
		List<Deal> dList;
		//DealList listofDeal=new DealList();
		logger.info("Completion of cst method --2222");
		dList = dealservice.selectDeals();
		System.out.println("got the deals: "+dList);
		//listofDeal.setDList(dList);
		//logger.info(listofDeal.toString());
		return dList;
		}
	/* Create a new Deal
	 * URL:  http://localhost:8080/myproject/webservices/deal
	 */
	@POST
	@Path("/deal")
	@Produces("application/json, application/xml")
	@Consumes("application/json, application/xml")
	public Response addDeal(Deal newDeal) {
		ResponseBuilder respBuilder;
		System.out.println("Print data"+newDeal);
		try { 
			dealservice.insertDeal(newDeal);
			System.out.println("Print data" +newDeal);
			
		} catch (Exception ex) {
			throw new WebApplicationException(ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
		}
		
		logger.debug("Successfully created a new Deal: " + newDeal);
		respBuilder = Response.status(Status.CREATED);
		respBuilder.entity(newDeal);
		return respBuilder.build();
		
}
	}

