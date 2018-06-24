package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.entity.Opportunity;

public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

	public Opportunity findByid(Long opportunityid);

}
