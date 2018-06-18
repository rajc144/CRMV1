package com.crm.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entity.Users;
import com.crm.repository.UserRepository;
import com.crm.service.CrudOperation;

@Service
@Transactional
public class UserServiceImpl implements CrudOperation<Users> {
	@Autowired
	private UserRepository userRepository;

	@Override
	public Users save(Users t) {

		return userRepository.save(t);
	}

	@Override
	public Users update(Users t) {

		return userRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Users edit(Long id) {

		return userRepository.findByprofileid(id);
	}

	@Override
	public List<Users> getAll() {

		return userRepository.findAll();
	}

	public List<Users> findByUserName(String name) {
		return userRepository.findByusername(name);
	}

	public Users authentication(String userName) {
		return userRepository.authenticate(userName);
	}
}
