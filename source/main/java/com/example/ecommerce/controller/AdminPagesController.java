package com.example.ecommerce.controller;

import com.example.ecommerce.model.Item;
import com.example.ecommerce.model.ReportResult;
import com.example.ecommerce.service.SalesReportService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminPagesController {

    private final SalesReportService salesReportService;

    public AdminPagesController(SalesReportService salesReportService){

        this.salesReportService= salesReportService;
    }

    @GetMapping("/admin-actions")
    public String adminActions(){

        return "admin-actions";
    }

    @GetMapping("/promote-user")
    public String promoteUser(){

        return "promote-user";
    }

    @GetMapping("/input-inventory")
    public String inputInventory(){

        return "input-inventory";
    }

    @GetMapping("/run-report")
    public String runReport(){

        return "run-report";
    }

    @PostMapping("/run-report")
    public String executeReport(@RequestParam("time") String time, Model model){

        ReportResult result = salesReportService.executeSalesReport(time);

        if (!result.getSuccess()){

            model.addAttribute("errorMessage",result.getMessage());

            return "redirect:/run-report";

        }

        model.addAttribute("items",result.getReportItems());

        return "redirect:/sales-report";
    }

    @GetMapping("/sales-report")
    public String showReport(){

        return "sales-report";
    }
}
