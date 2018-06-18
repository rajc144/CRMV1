package com.crm.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entity.FinancialSummary;
import com.crm.repository.FinancialSummaryReportRepository;
import com.crm.service.CrudOperation;

@Service
@Transactional
public class CompanyFinancialServiceImpl implements CrudOperation<FinancialSummary> {
	@Autowired
	private FinancialSummaryReportRepository financialSummaryReportRepository;

	@Override
	public FinancialSummary save(FinancialSummary t) {

		return financialSummaryReportRepository.save(t);
	}

	@Override
	public FinancialSummary update(FinancialSummary t) {

		return financialSummaryReportRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		financialSummaryReportRepository.deleteById(id);

	}

	@Override
	public FinancialSummary edit(Long id) {

		return financialSummaryReportRepository.findByid(id);
	}

	@Override
	public List<FinancialSummary> getAll() {

		return financialSummaryReportRepository.findAll();
	}

}
