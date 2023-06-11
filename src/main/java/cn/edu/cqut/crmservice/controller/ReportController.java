package cn.edu.cqut.crmservice.controller;


import cn.edu.cqut.crmservice.entity.Report;
import cn.edu.cqut.crmservice.service.ICustomerService;
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

    @GetMapping("/getCustomerCountByRegion")
    public ReportResult getCustomerCountByRegion() {
        List<Report> reports = customerService.getCustomerCountByRegion();
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return ReportResult.ok(items,values);
    }
}
