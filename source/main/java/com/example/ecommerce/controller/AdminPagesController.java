package com.example.ecommerce.controller;

import com.example.ecommerce.model.Item;
import com.example.ecommerce.model.ReportItem;
import com.example.ecommerce.model.ReportResult;
import com.example.ecommerce.service.SalesReportService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
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
    public String executeReport(@RequestParam("time") String time, Model model, HttpSession session){

        ReportResult result = salesReportService.executeSalesReport(time);

        //if the user doesn't enter an integer, display a message
        if (!result.getSuccess()){

            model.addAttribute("errorMessage",result.getMessage());

            return "run-report";

        }

        // store the sales report results to display in the next page
        session.setAttribute("report",result.getReportItems());

        model.addAttribute("items",result.getReportItems());

        return "sales-report";
    }

    @GetMapping("/export-report")
    public void exportReport(HttpServletResponse response, HttpSession session) throws IOException {

        // download the report when the user clicks the export report button
        response.setContentType("text/plain"); // Written by ChatGPT

        response.setHeader("Content-Disposition", "attachment; filename=sales_report.txt"); // Written by CHatGPT

        List<ReportItem> report = (List<ReportItem>) session.getAttribute("report");

        String reportString = "Sales Report\n" +
                "___________________________________\n";

        for (ReportItem item: report){

            reportString += item.toString();

        }

        response.getWriter().write(reportString); // Written by ChatGPT
    }

}
