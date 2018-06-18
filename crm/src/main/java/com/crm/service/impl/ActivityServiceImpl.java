package com.crm.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entity.Activities;
import com.crm.repository.ActivitesRepository;
import com.crm.service.CrudOperation;

@Service
@Transactional
public class ActivityServiceImpl implements CrudOperation<Activities> {
	@Autowired
	private ActivitesRepository activitesRepository;

	@Override
	public Activities save(Activities t) {
		// TODO Auto-generated method stub
		return activitesRepository.save(t);
	}

	@Override
	public Activities update(Activities t) {
		// TODO Auto-generated method stub
		return activitesRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		Activities activities = activitesRepository.findByid(id);

		activitesRepository.delete(activities);
	}

	@Override
	public Activities edit(Long id) {

		return activitesRepository.findByid(id);
	}

	@Override
	public List<Activities> getAll() {

		return activitesRepository.findAll();
	}

}
