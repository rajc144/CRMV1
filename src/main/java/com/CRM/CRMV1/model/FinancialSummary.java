package com.CRM.CRMV1.model;

import lombok.Data;

@Data
public class FinancialSummary {


    private String TotalRevenue;

    private String TotalChangeOrders;

    private String PaymentsIn7Days;

    private String PaymentPending;

}
