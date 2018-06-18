package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	public Company findByid(Long id);
}
