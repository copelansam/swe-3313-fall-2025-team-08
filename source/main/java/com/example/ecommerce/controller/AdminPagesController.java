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

    // displays the admin actions page
    @GetMapping("/admin-actions")
    public String adminActions(){

        return "admin-actions";
    }

    // displays the promote user page
    @GetMapping("/promote-user")
    public String promoteUser(){

        return "promote-user";
    }

    // displays the inventory creation page
    @GetMapping("/input-inventory")
    public String inputInventory(){

        return "input-inventory";
    }

    // displays the run sales report page
    @GetMapping("/run-report")
    public String runReport(){

        return "run-report";
    }

    // retrieves and displays a list of sold items in the time frame specified by the user
    @PostMapping("/run-report")
    public String executeReport(@RequestParam("time") String time, Model model, HttpSession session){

        ReportResult result = salesReportService.executeSalesReport(time);

        // If the user doesn't enter an integer, display a message
        if (!result.getSuccess()){

            model.addAttribute("errorMessage",result.getMessage());

            return "run-report";

        }

        // Store the sales report results to display in the next page
        session.setAttribute("report",result.getReportItems());

        model.addAttribute("items",result.getReportItems());

        return "sales-report";
    }

    // Download the sales report when the user hits the export button
    @GetMapping("/export-report")
    public void exportReport(HttpServletResponse response, HttpSession session) throws IOException {

        response.setContentType("text/plain"); // Written by ChatGPT

        response.setHeader("Content-Disposition", "attachment; filename=sales_report.csv"); // Written by CHatGPT

        List<ReportItem> report = (List<ReportItem>) session.getAttribute("report");

        String reportString = "Item Name,Price,Date Sold,Order Number,Purchased By\n";

        for (ReportItem item: report){

            // Add each item in the report to the CSV string that will be written to the file
            reportString += item.toCSV();

        }

        response.getWriter().write(reportString); // Written by ChatGPT
    }

}
