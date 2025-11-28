package com.example.ecommerce.service;

import com.example.ecommerce.model.Item;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.ReportResult;
import com.example.ecommerce.repository.OrderEntityRepository;
import com.example.ecommerce.repository.SalesReportRepository;
import org.springframework.stereotype.Service;

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
            int timeDay = Integer.parseInt(time);

            return new ReportResult(true, null, orderTables.salesReport(timeDay));
        }
        catch (Exception e){

            System.out.println("Incorrect data type entered");

            message = "Please enter a whole number";

            return new ReportResult(success, message, null);
        }

    }
}
