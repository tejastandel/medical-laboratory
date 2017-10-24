/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xfinity.controller;

import com.xfinity.data_access_layer.ReportDataAccessLayer;
import com.xfinity.data_access_object.DoctorReferral;
import com.xfinity.data_access_object.Report;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Supun Lakshan
 */
public class ReportController {

    private static final ReportDataAccessLayer REPORT_DAL;

    static {
        REPORT_DAL = new ReportDataAccessLayer();
    }

    public static boolean saveReport(Report report) {
        return REPORT_DAL.saveReport(report);
    }

    public static ArrayList<DoctorReferral> getDoctorReferrals(String referredBy, Date startDate, Date endDate) {
        return REPORT_DAL.getDoctorReferrals(referredBy, startDate, endDate);
    }
    
    public static void fillReportData(Report report){
        REPORT_DAL.fillReportData(report);
    }
    
    public static ArrayList<Report> getHistoryReports(Date startDate, Date endDate, String referredBy, String patientName) {
        return REPORT_DAL.getHistoryReports(startDate, endDate, referredBy, patientName);
    }

    public static void deleteReport(Report e) {
        REPORT_DAL.deleteReport(e);
    }
}