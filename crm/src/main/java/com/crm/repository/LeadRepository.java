package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

	public Lead findByid(Long id);
}
