package com.CRM.CRMV1.controller;


import com.CRM.CRMV1.model.FinancialSummary;
import com.CRM.CRMV1.model.Users;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/financials")
public class CompanyFinancialSummaryController {



    @GetMapping(value="/{companyid}")
    public @ResponseBody FinancialSummary getFinancialSummaryByCompanyId(@PathVariable Integer companyid )
    {
        FinancialSummary fs = new FinancialSummary();
        fs.setTotalRevenue("$34,555.33");
        fs.setTotalChangeOrders("$12,331.22");
        fs.setPaymentsIn7Days("$9,000.22");
        fs.setPaymentPending("$46,889.00");

        return fs;
    }


}
