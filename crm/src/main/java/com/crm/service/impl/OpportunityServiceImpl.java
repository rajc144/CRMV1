package com.crm.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entity.Opportunity;
import com.crm.repository.OpportunityRepository;
import com.crm.service.CrudOperation;

@Service
@Transactional
public class OpportunityServiceImpl implements CrudOperation<Opportunity> {
	@Autowired
	private OpportunityRepository opportunityRepository;

	@Override
	public Opportunity save(Opportunity t) {

		return opportunityRepository.save(t);
	}

	@Override
	public Opportunity update(Opportunity t) {

		return opportunityRepository.save(t);
	}

	@Override
	public void delete(Long id) {

		opportunityRepository.deleteById(id);
	}

	@Override
	public Opportunity edit(Long id) {
		
		return opportunityRepository.findByopportunityid(id);
	}

	@Override
	public List<Opportunity> getAll() {
		
		return opportunityRepository.findAll();
	}

}
