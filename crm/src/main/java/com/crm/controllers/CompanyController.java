package com.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.entity.Company;
import com.crm.service.impl.CompanyServiceImpl;
import com.crm.utils.Constants;
import com.crm.utils.Response;

@RestController
@RequestMapping(value = "/company")
@CrossOrigin(origins = "http://localhost:4200")
public class CompanyController {

	@Autowired
	private CompanyServiceImpl companyServiceImpl;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response newCompany(@RequestBody Company company) {
		Response response = new Response();
		try {
			company = companyServiceImpl.save(company);
			response.setData(company);
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
	public Response updateCompany(@RequestBody Company company) {

		Response response = new Response();
		try {
			company = companyServiceImpl.update(company);
			response.setData(company);
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
	public Response editCompany(@PathVariable Long id) {
		Response response = new Response();
		try {
			Company company = companyServiceImpl.edit(id);
			response.setData(company);
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
	public Response deleteCompany(@PathVariable Long id) {

		Response response = new Response();
		try {
			companyServiceImpl.delete(id);
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

	
	@RequestMapping(value = "/getAllCompanies", method = RequestMethod.GET)
	public Response getAllCompany() {
		Response response = new Response();
		try {
			List<Company> companies = companyServiceImpl.getAll();
			response.setData(companies);
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
