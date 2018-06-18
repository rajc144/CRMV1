package com.crm.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entity.Role;
import com.crm.repository.RoleRepository;
import com.crm.service.CrudOperation;

@Service
@Transactional
public class RoleServiceImpl implements CrudOperation<Role> {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role save(Role t) {
		// TODO Auto-generated method stub
		return roleRepository.save(t);
	}

	@Override
	public Role update(Role t) {
		// TODO Auto-generated method stub
		return roleRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		Role role = roleRepository.findByid(id);
		roleRepository.delete(role);
	}

	@Override
	public Role edit(Long id) {

		return roleRepository.findByid(id);
	}

	@Override
	public List<Role> getAll() {

		return roleRepository.findAll();
	}

}
