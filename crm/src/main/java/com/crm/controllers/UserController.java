package com.crm.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.entity.Users;
import com.crm.pojos.Login;
import com.crm.service.impl.UserServiceImpl;
import com.crm.utils.Constants;
import com.crm.utils.Response;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response newUser(@RequestBody Users user) {
		Response response = new Response();
		try {

			user.setJoindate(new Date());
			user = userServiceImpl.save(user);
			response.setData(user);
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
	public Response updateUser(@RequestBody Users users) {

		Response response = new Response();
		try {
			users = userServiceImpl.update(users);
			response.setData(users);
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

	@RequestMapping(value = "/edit/{profileid}", method = RequestMethod.GET)
	public Response editUser(@PathVariable Long profileid) {
		Response response = new Response();
		try {
			Users users = userServiceImpl.edit(profileid);
			response.setData(users);
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

	@RequestMapping(value = "/getAllProfiles", method = RequestMethod.GET)
	public Response getAllUser() {
		Response response = new Response();
		try {
			List<Users> users = userServiceImpl.getAll();
			response.setData(users);
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

	@RequestMapping(value = "/getByUserName/{username}", method = RequestMethod.GET)
	public Response getUserByUserName(@PathVariable String username) {

		Response response = new Response();
		try {
			List<Users> users = userServiceImpl.findByUserName(username);
			response.setData(users);
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

	@RequestMapping(value = "/delete/{profileid}", method = RequestMethod.GET)
	public Response deleteUser(@PathVariable Long profileid) {

		Response response = new Response();
		try {
			userServiceImpl.delete(profileid);
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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Response login(@RequestBody Login login) {

		Response response = new Response();
		try {
			Users users = userServiceImpl.authentication(login.getUserName());
			if (users.getPassword().equals(login.getPassword())) {
				response.setData(users);
				response.setMessage(Constants.AUTHENTICATIONSUCCESS);
				response.setStatus(Constants.Success);
			} else {
				response.setData(null);
				response.setMessage(Constants.AUTHENTICATIONFAILED);
				response.setStatus(Constants.failed);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			response.setData(null);
			response.setMessage(Constants.AUTHENTICATIONFAILED);
			response.setStatus(Constants.failed);
		}
		return response;

	}

}
