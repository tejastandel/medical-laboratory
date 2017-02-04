/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xfinity.controller;

import com.xfinity.data_access_layer.ReportDataAccessLayer;
import com.xfinity.data_access_object.Report;

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

}
