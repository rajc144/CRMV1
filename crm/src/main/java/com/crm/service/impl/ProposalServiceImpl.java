package com.crm.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entity.Proposals;
import com.crm.repository.ProposalRepository;
import com.crm.service.CrudOperation;

@Service
@Transactional
public class ProposalServiceImpl implements CrudOperation<Proposals> {
	@Autowired
	private ProposalRepository proposalRepository;

	@Override
	public Proposals save(Proposals t) {

		return proposalRepository.save(t);
	}

	@Override
	public Proposals update(Proposals t) {

		return proposalRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		Proposals proposals = proposalRepository.findByid(id);
		proposalRepository.delete(proposals);
	}

	@Override
	public Proposals edit(Long id) {

		return proposalRepository.findByid(id);
	}

	@Override
	public List<Proposals> getAll() {

		return proposalRepository.findAll();
	}

}
