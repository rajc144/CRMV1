package com.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.entity.Lead;
import com.crm.service.impl.LeadServiceImpl;
import com.crm.utils.Constants;
import com.crm.utils.Response;

@RestController
@RequestMapping(value = "/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class LeadController {
	@Autowired
	private LeadServiceImpl leadServiceImpl;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response saveLead(@RequestBody Lead lead) {
		Response response = new Response();
		try {
			lead = leadServiceImpl.save(lead);
			response.setData(lead);
			response.setMessage(Constants.SAVED);
			response.setStatus(Constants.Success);
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setData(null);
			response.setMessage(Constants.NOTSAVED);
			response.setStatus(Constants.failed);
		}

		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Response updateLead(@RequestBody Lead lead) {

		Response response = new Response();
		try {
			lead = leadServiceImpl.update(lead);
			response.setData(lead);
			response.setMessage(Constants.SAVED);
			response.setStatus(Constants.Success);
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setData(null);
			response.setMessage(Constants.NOTFETCHED);
			response.setStatus(Constants.failed);
		}
		return response;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public Response editLead(@PathVariable Long id) {
		Response response = new Response();
		try {
			Lead lead = leadServiceImpl.edit(id);
			response.setData(lead);
			response.setMessage(Constants.FETCHED);
			response.setStatus(Constants.Success);
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setData(null);
			response.setMessage(Constants.NOTFETCHED);
			response.setStatus(Constants.failed);
		}
		return response;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public Response deleteLead(@PathVariable Long id) {

		Response response = new Response();
		try {
			leadServiceImpl.delete(id);
			response.setData(null);
			response.setMessage(Constants.DELETED);
			response.setStatus(Constants.Success);

		} catch (Exception exception) {
			exception.printStackTrace();
			response.setData(null);
			response.setMessage(Constants.NOTDELETED);
			response.setStatus(Constants.failed);
		}
		return response;

	}

	@RequestMapping(value = "/getAllLead", method = RequestMethod.GET)
	public Response getAllLead() {
		Response response = new Response();
		try {
			List<Lead> leads = leadServiceImpl.getAll();
			response.setData(leads);
			response.setMessage(Constants.FETCHED);
			response.setStatus(Constants.Success);
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setData(null);
			response.setMessage(Constants.NOTFETCHED);
			response.setStatus(Constants.failed);
		}
		return response;
	}
}
