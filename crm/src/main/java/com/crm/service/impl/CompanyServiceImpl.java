package com.crm.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entity.Company;
import com.crm.repository.CompanyRepository;
import com.crm.service.CrudOperation;

@Service
@Transactional
public class CompanyServiceImpl implements CrudOperation<Company> {
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company save(Company t) {

		return companyRepository.save(t);
	}

	@Override
	public Company update(Company t) {

		return companyRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		companyRepository.deleteById(id);

	}

	@Override
	public Company edit(Long id) {

		return companyRepository.findByid(id);
	}

	@Override
	public List<Company> getAll() {

		return companyRepository.findAll();
	}

}
