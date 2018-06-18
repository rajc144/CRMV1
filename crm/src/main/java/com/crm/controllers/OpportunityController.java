package com.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.entity.Opportunity;
import com.crm.service.impl.OpportunityServiceImpl;
import com.crm.utils.Constants;
import com.crm.utils.Response;

@RestController
@RequestMapping(value = "/company/opportunity")
@CrossOrigin(origins = "http://localhost:4200")
public class OpportunityController {

	@Autowired
	private OpportunityServiceImpl opportunityServiceImpl;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response newOpportunity(@RequestBody Opportunity opportunity) {
		Response response = new Response();
		try {
			opportunity = opportunityServiceImpl.save(opportunity);
			response.setData(opportunity);
			response.setMessage(Constants.SAVED);
			response.setStatus(Constants.Success);
		} catch (Exception exception) {
			response.setData(null);
			response.setMessage(Constants.NOTSAVED);
			response.setStatus(Constants.failed);
		}

		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Response updateOpportunity(@RequestBody Opportunity opportunity) {

		Response response = new Response();
		try {
			opportunity = opportunityServiceImpl.update(opportunity);
			response.setData(opportunity);
			response.setMessage(Constants.SAVED);
			response.setStatus(Constants.Success);
		} catch (Exception exception) {
			response.setData(null);
			response.setMessage(Constants.NOTFETCHED);
			response.setStatus(Constants.failed);
		}
		return response;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public Response editOpportunity(@PathVariable Long id) {
		Response response = new Response();
		try {
			Opportunity opportunity = opportunityServiceImpl.edit(id);
			response.setData(opportunity);
			response.setMessage(Constants.FETCHED);
			response.setStatus(Constants.Success);

		} catch (Exception exception) {
			response.setData(null);
			response.setMessage(Constants.NOTFETCHED);
			response.setStatus(Constants.failed);
		}
		return response;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public Response deleteOpportunity(@PathVariable Long id) {

		Response response = new Response();
		try {
			opportunityServiceImpl.delete(id);
			response.setData(null);
			response.setMessage(Constants.DELETED);
			response.setStatus(Constants.Success);

		} catch (Exception exception) {
			response.setData(null);
			response.setMessage(Constants.NOTDELETED);
			response.setStatus(Constants.failed);
		}
		return response;

	}

	@RequestMapping(value = "/getAllOpportunity", method = RequestMethod.GET)
	public Response getAllOpportunity() {
		Response response = new Response();
		try {
			List<Opportunity> opportunity = opportunityServiceImpl.getAll();
			response.setData(opportunity);
			response.setMessage(Constants.FETCHED);
			response.setStatus(Constants.Success);

		} catch (Exception exception) {
			response.setData(null);
			response.setMessage(Constants.NOTFETCHED);
			response.setStatus(Constants.failed);
		}
		return response;
	}

}
