package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.entity.FinancialSummary;

public interface FinancialSummaryReportRepository extends JpaRepository<FinancialSummary, Long> {

	public FinancialSummary findByid(Long id);
}
