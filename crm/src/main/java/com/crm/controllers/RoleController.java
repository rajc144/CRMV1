package com.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.entity.Role;
import com.crm.service.impl.RoleServiceImpl;
import com.crm.utils.Constants;
import com.crm.utils.Response;

@RestController
@RequestMapping(value = "/role")
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {
	@Autowired
	private RoleServiceImpl roleServiceImpl;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response newRole(@RequestBody Role role) {
		Response response = new Response();
		try {
			role = roleServiceImpl.save(role);
			response.setData(role);
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
	public Response updateRole(@RequestBody Role role) {

		Response response = new Response();
		try {
			role = roleServiceImpl.update(role);
			response.setData(role);
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
	public Response editRole(@PathVariable Long id) {
		Response response = new Response();
		try {
			Role role = roleServiceImpl.edit(id);
			response.setData(role);
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
	public Response deleteRole(@PathVariable Long id) {

		Response response = new Response();
		try {
			roleServiceImpl.delete(id);
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

	@RequestMapping(value = "/getAllRole", method = RequestMethod.GET)
	public Response getAllRole() {
		Response response = new Response();
		try {
			List<Role> roles = roleServiceImpl.getAll();
			response.setData(roles);
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
