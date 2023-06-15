package cn.edu.cqut.crmservice.controller;


import cn.edu.cqut.crmservice.entity.Report;
import cn.edu.cqut.crmservice.service.ICustomerService;
import cn.edu.cqut.crmservice.util.Auth;
import cn.edu.cqut.crmservice.util.ReportResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/report")
@CrossOrigin
public class ReportController {

    @Autowired
    private ICustomerService customerService;

    @Auth(roles = {"MANAGER", "ADMIN"})
    @GetMapping("/getCustomerCountByRegion")
    public ReportResult getCustomerCountByRegion() {
        List<Report> reports = customerService.getCustomerCountByRegion();
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return ReportResult.ok(items, values);
    }

    @Auth(roles = {"MANAGER", "ADMIN"})
    @GetMapping("/getAmountByReCusID")
    public ReportResult getAmountByReCusID() {
        List<Report> reports = customerService.getAmountByReCusID();
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(customerService.getCusNameByID(Integer.parseInt(report.getItem())));
            values.add(report.getValue());
        }
        return ReportResult.ok(items, values);
    }

    @Auth(roles = {"MANAGER", "ADMIN"})
    @GetMapping("/getAmountByReCusName")
    public ReportResult getAmountByReCusName(String username) {
        Report report = customerService.getAmountByReCusName(username);
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();

        items.add(report.getItem());
        values.add(report.getValue());

        return ReportResult.ok(items, values);
    }

    @Auth(roles = {"MANAGER", "ADMIN"})
    @GetMapping("/getCustomerCountByIndustry")
    public ReportResult getCustomerCountByIndustry() {
        List<Report> reports = customerService.getCustomerCountByIndustry();
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return ReportResult.ok(items, values);
    }

    @Auth(roles = {"MANAGER", "ADMIN"})
    @GetMapping("/getCustomerCountByCredit")
    public ReportResult getCustomerCountByCredit() {
        List<Report> reports = customerService.getCustomerCountByCredit();
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return ReportResult.ok(items, values);
    }

    @Auth(roles = {"MANAGER", "ADMIN"})
    @GetMapping("/getServiceCountByTypeAndYear")
    public ReportResult getServiceCountByTypeAndYear(int year) {
        List<Report> reports = customerService.getServiceCountByTypeAndYear(year);
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return ReportResult.ok(items, values);
    }

    @Auth(roles = {"MANAGER", "ADMIN"})
    @GetMapping("/getServiceCountByType")
    public ReportResult getServiceCountByType() {
        List<Report> reports = customerService.getServiceCountByType();
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return ReportResult.ok(items, values);
    }

    @Auth(roles = {"MANAGER", "ADMIN"})
    @GetMapping("/getCustomerLossRecordsBySalespersonName")
    public ReportResult getCustomerLossRecordsBySalespersonName(String name) {
        List<Report> reports = customerService.getCustomerLossRecordsBySalespersonName(name);
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return ReportResult.ok(items, values);
    }
}
