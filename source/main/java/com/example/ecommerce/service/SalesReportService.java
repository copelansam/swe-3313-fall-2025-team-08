package com.example.ecommerce.service;

import com.example.ecommerce.model.Item;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.ReportItem;
import com.example.ecommerce.model.ReportResult;
import com.example.ecommerce.repository.OrderEntityRepository;
import com.example.ecommerce.repository.SalesReportRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class SalesReportService {

    private final SalesReportRepository orderTables;

    public SalesReportService(SalesReportRepository orderTables){

        this.orderTables = orderTables;
    }

    public ReportResult executeSalesReport(String time){

        boolean success = false;

        String message = " ";

        try {

            // check that the user input a number of days
            int timeDay = Integer.parseInt(time.trim());

            // if so, retrieve items and pass them along
            return new ReportResult(true, null, orderTables.salesReport(timeDay));
        }
        catch (Exception e){

            // otherwise, use exception handling to avoid a crash
            System.out.println("Incorrect data type entered" + e.getMessage());

            message = "Please enter a whole number";

            return new ReportResult(success, message, null);
        }

    }
}
