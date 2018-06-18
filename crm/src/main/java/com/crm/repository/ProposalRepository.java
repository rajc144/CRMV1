package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.entity.Proposals;

public interface ProposalRepository extends JpaRepository<Proposals, Long> {

	public Proposals findByid(Long id);
}
