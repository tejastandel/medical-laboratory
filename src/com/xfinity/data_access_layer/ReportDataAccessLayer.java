/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xfinity.data_access_layer;

import com.xfinity.data_access_object.ElementResult;
import com.xfinity.data_access_object.Report;
import com.xfinity.db.DBHandler;
import com.xfinity.db.DbConnectionProvider;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Supun Lakshan
 */
public class ReportDataAccessLayer {

    public boolean saveReport(Report report) {
	try (Connection connection = DbConnectionProvider.getDbConnection()) {
	    try {
		connection.setAutoCommit(false);
		String insertReportSql = "insert into tbl_test_report (patientName, testId, age, referredBy, gender, date) values (?,?,?,?,?,?)";
		int reportId = DBHandler.setData(connection, insertReportSql, new Object[]{
		    report.getPatientName(),
		    report.getTestId(),
		    report.getAge(),
		    report.getReferredBy(),
		    report.getGender(),
		    new SimpleDateFormat("yyyy-MM-dd").format(new Date())
		});
		report.setReportId(reportId);
		String insertReportDetailsSql = "insert into tbl_report_result (reportId, elementId, result) values (?,?,?)";
		for (ElementResult result : report.getResults()) {
		    DBHandler.setData(connection, insertReportDetailsSql, new Object[]{
			reportId,
			result.getElementId(),
			result.getResult()
		    });
		}
		connection.commit();
		return reportId > 0;
	    } catch (Exception ex) {
		connection.rollback();
		throw ex;
	    } finally {
		connection.setAutoCommit(true);
	    }
	} catch (SQLException | ClassNotFoundException ex) {
	    Logger.getLogger(TestDataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
	}
	return false;
    }

}
