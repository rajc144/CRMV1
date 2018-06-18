package com.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.entity.FinancialSummary;
import com.crm.service.impl.CompanyFinancialServiceImpl;
import com.crm.utils.Constants;
import com.crm.utils.Response;

@RestController
@RequestMapping(value = "/company/financial")
@CrossOrigin(origins = "http://localhost:4200")
public class CompanyFinancialSummaryController {

	@Autowired
	private CompanyFinancialServiceImpl companyFinancialServiceImpl;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response newFinancial(@RequestBody FinancialSummary financialSummary) {
		Response response = new Response();
		try {
			financialSummary = companyFinancialServiceImpl.save(financialSummary);
			response.setData(financialSummary);
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
	public Response updateFinancial(@RequestBody FinancialSummary financialSummary) {

		Response response = new Response();
		try {
			financialSummary = companyFinancialServiceImpl.update(financialSummary);
			response.setData(financialSummary);
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
	public Response editFinancial(@PathVariable Long id) {
		Response response = new Response();
		try {
			FinancialSummary financialSummary = companyFinancialServiceImpl.edit(id);
			response.setData(financialSummary);
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
	public Response deleteFinancial(@PathVariable Long id) {

		Response response = new Response();
		try {
			companyFinancialServiceImpl.delete(id);
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

	@RequestMapping(value = "/getAllFinancialSummary", method = RequestMethod.GET)
	public Response getAllFinancial() {
		Response response = new Response();
		try {
			List<FinancialSummary> financialSummaries = companyFinancialServiceImpl.getAll();
			response.setData(financialSummaries);
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
