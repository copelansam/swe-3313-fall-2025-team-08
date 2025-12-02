package com.example.ecommerce.model;

import java.util.List;

// This class will track if we were able to retrieve a sales report, and store the results
public class ReportResult {

    private boolean success;

    private String message;

    private List<ReportItem> reportItems;

    public ReportResult(boolean success, String message, List<ReportItem> reportItems){

        this.success = success;

        this.message = message;

        this.reportItems = reportItems;
    }

    public boolean getSuccess(){

        return this.success;
    }

    public void setSuccess(boolean success){

        this.success = success;
    }

    public String getMessage(){

        return this.message;
    }

    public void setMessage(String message){

        this.message = message;
    }

    public List<ReportItem> getReportItems(){

        return this.reportItems;
    }

    public void setReportItems(List<ReportItem> reportItems) {
        this.reportItems = reportItems;
    }
}
