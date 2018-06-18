package com.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.entity.Proposals;
import com.crm.service.impl.ProposalServiceImpl;
import com.crm.utils.Constants;
import com.crm.utils.Response;

@RestController
@RequestMapping(value = "/proposals")
@CrossOrigin(origins = "http://localhost:4200")
public class ProposalController {
	@Autowired
	private ProposalServiceImpl proposalServiceImpl;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response newProposals(@RequestBody Proposals proposals) {
		Response response = new Response();
		try {
			proposals = proposalServiceImpl.save(proposals);
			response.setData(proposals);
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
	public Response updateProposals(@RequestBody Proposals proposals) {

		Response response = new Response();
		try {
			proposals = proposalServiceImpl.update(proposals);
			response.setData(proposals);
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
	public Response editProposals(@PathVariable Long id) {
		Response response = new Response();
		try {
			Proposals proposals = proposalServiceImpl.edit(id);
			response.setData(proposals);
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
	public Response deleteProposals(@PathVariable Long id) {

		Response response = new Response();
		try {
			proposalServiceImpl.delete(id);
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

	@RequestMapping(value = "/getAllProposals", method = RequestMethod.GET)
	public Response getAllProposals() {
		Response response = new Response();
		try {
			List<Proposals> opportunity = proposalServiceImpl.getAll();
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
