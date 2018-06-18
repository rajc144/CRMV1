package com.crm.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entity.Lead;
import com.crm.repository.LeadRepository;
import com.crm.service.CrudOperation;

@Service
@Transactional
public class LeadServiceImpl implements CrudOperation<Lead> {
	@Autowired
	private LeadRepository leadRepository;

	@Override
	public Lead save(Lead t) {

		return leadRepository.save(t);
	}

	@Override
	public Lead update(Lead t) {

		return leadRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		Lead lead = leadRepository.findByid(id);

		leadRepository.delete(lead);

	}

	@Override
	public Lead edit(Long id) {
		Lead lead = leadRepository.findByid(id);
		return lead;
	}

	@Override
	public List<Lead> getAll() {

		return leadRepository.findAll();
	}

}
