package com.crm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FinancialSummary")
public class FinancialSummary implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2381068351702068094L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String TotalRevenue;

	private String TotalChangeOrders;

	private String PaymentsIn7Days;

	private String PaymentPending;

	private int version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTotalRevenue() {
		return TotalRevenue;
	}

	public void setTotalRevenue(String totalRevenue) {
		TotalRevenue = totalRevenue;
	}

	public String getTotalChangeOrders() {
		return TotalChangeOrders;
	}

	public void setTotalChangeOrders(String totalChangeOrders) {
		TotalChangeOrders = totalChangeOrders;
	}

	public String getPaymentsIn7Days() {
		return PaymentsIn7Days;
	}

	public void setPaymentsIn7Days(String paymentsIn7Days) {
		PaymentsIn7Days = paymentsIn7Days;
	}

	public String getPaymentPending() {
		return PaymentPending;
	}

	public void setPaymentPending(String paymentPending) {
		PaymentPending = paymentPending;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
