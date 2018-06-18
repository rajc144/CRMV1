package com.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.entity.Activities;
import com.crm.service.impl.ActivityServiceImpl;
import com.crm.utils.Constants;
import com.crm.utils.Response;

@RestController
@RequestMapping(value = "/activity")
@CrossOrigin(origins = "http://localhost:4200")
public class ActivitiesController {
	@Autowired
	private ActivityServiceImpl activityServiceImpl;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response newActivities(@RequestBody Activities activities) {
		Response response = new Response();
		try {
			activities = activityServiceImpl.save(activities);
			response.setData(activities);
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
	public Response updateActivities(@RequestBody Activities activities) {

		Response response = new Response();
		try {
			activities = activityServiceImpl.update(activities);
			response.setData(activities);
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
	public Response editActivities(@PathVariable Long id) {
		Response response = new Response();
		try {
			Activities activities = activityServiceImpl.edit(id);
			response.setData(activities);
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
	public Response deleteActivities(@PathVariable Long id) {

		Response response = new Response();
		try {
			activityServiceImpl.delete(id);
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

	@RequestMapping(value = "/getAllActivities", method = RequestMethod.GET)
	public Response getAllActivities() {
		Response response = new Response();
		try {
			List<Activities> activities = activityServiceImpl.getAll();
			response.setData(activities);
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
