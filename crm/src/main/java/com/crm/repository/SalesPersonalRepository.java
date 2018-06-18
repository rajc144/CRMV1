package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.entity.SalesPerson;

public interface SalesPersonalRepository extends JpaRepository<SalesPerson, Long> {

}
