package com.xfinity.data_access_layer;

import com.xfinity.data_access_object.DoctorReferral;
import com.xfinity.data_access_object.ElementResult;
import com.xfinity.data_access_object.Report;
import com.xfinity.db.DBHandler;
import com.xfinity.db.DbConnectionProvider;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportDataAccessLayer {

    public boolean saveReport(Report report) {
        try (Connection connection = DbConnectionProvider.getDbConnection()) {
            try {
                connection.setAutoCommit(false);
                String deleteOldOne = "delete from tbl_test_report where testId=? and patientName=? and date=?";
                String insertReportSql = "insert into tbl_test_report (patientName, testId, age, referredBy, gender, date, comment) values (?,?,?,?,?,?,?)";
                String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                DBHandler.setData(connection, deleteOldOne, report.getTestId(), report.getPatientName(), today);
                int reportId = DBHandler.setData(connection, insertReportSql, new Object[]{
                    report.getPatientName(),
                    report.getTestId(),
                    report.getAge(),
                    report.getReferredBy(),
                    report.getGender(),
                    today, 
                    report.getComment()
                });
                report.setReportId(reportId);
                String updatePriceSql= "update tbl_test_report ttr inner join tbl_test tt on tt.testId=ttr.testId set ttr.price = tt.price where ttr.reportId=?";
                DBHandler.setData(connection, updatePriceSql, reportId);
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

    public ArrayList<DoctorReferral> getDoctorReferrals(String referredBy, Date startDate, Date endDate) {
        ArrayList<DoctorReferral> reffarals = new ArrayList<>();
        try (Connection connection = DbConnectionProvider.getDbConnection()) {
            String sql = "select distinct tt.testName, ttr.patientName, ttr.price, ttr.`date` from tbl_test as tt inner join tbl_test_report as ttr on ttr.testId=tt.testId where (ifnull(?, true) or ttr.referredBy=?) and ttr.`date` between ? and ? order by ttr.reportId";
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            ResultSet resultSet = DBHandler.getData(connection, sql, referredBy, referredBy, formatter.format(startDate), formatter.format(endDate));
            if (resultSet.first()) {
                int testName = resultSet.findColumn("testName");
                int patientName = resultSet.findColumn("patientName");
                int price = resultSet.findColumn("price");
                int date = resultSet.findColumn("date");
                DoctorReferral refferal;
                do {
                    reffarals.add(refferal = new DoctorReferral());
                    refferal.setTestName(resultSet.getString(testName));
                    refferal.setPatientName(resultSet.getString(patientName));
                    refferal.setPrice(resultSet.getDouble(price));
                    refferal.setTestPerformedDate(resultSet.getString(date));
                    refferal.setSpeciemenCollectedDate(resultSet.getString(date));
                } while (resultSet.next());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TestDataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reffarals;
    }

    public void fillReportData(Report report) {
        try(Connection connection = DbConnectionProvider.getDbConnection()){
            ArrayList<ElementResult> results = new ArrayList<>();
            String sql = "select tte.testElementName, tte.testElementId, tte.unit, tte.`range`, trr.`result` from medilab.tbl_report_result as trr inner join medilab.tbl_test_element as tte on tte.testElementId=trr.elementId where trr.reportId=?";
            ResultSet data = DBHandler.getData(connection, sql, report.getReportId());
            if(data.first()){
                int testElementName = data.findColumn("testElementName");
                int testElementId = data.findColumn("testElementId");
                int unit = data.findColumn("unit");
                int range = data.findColumn("range");
                int result = data.findColumn("result");
                
                ElementResult e;
                do {                    
                    results.add(e = new ElementResult());
                    e.setElementId(data.getInt(testElementId));
                    e.setName(data.getString(testElementName));
                    e.setRange(data.getString(range));
                    e.setResult(data.getString(result));
                    e.setUnit(data.getString(unit));
                } while (data.next());
            }
            report.setResults(results);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ReportDataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Report> getHistoryReports(Date startDate, Date endDate, String referredBy, String patientName) {
        if(patientName == null || patientName.trim().isEmpty()){
            patientName = null;
        } else {
            patientName = '%' + String.format("%S", patientName) + '%';
        }
        ArrayList<Report> reports = new ArrayList<>();
        try (Connection connection = DbConnectionProvider.getDbConnection()) {
            CallableStatement prepareCall = connection.prepareCall("call sp_get_reports(?,?,?,?)");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            ResultSet data = DBHandler.getData(prepareCall, formatter.format(startDate), formatter.format(endDate), referredBy, patientName);
            if(data.first()){
                int patientNameIndex = data.findColumn("patientName");
                int dateIndex = data.findColumn("date");
                int referredByIndex = data.findColumn("referredBy");
                int genderIndex = data.findColumn("gender");
                int ageIndex = data.findColumn("age");
                int reportIdIndex = data.findColumn("reportId");
                int testNameIndex = data.findColumn("testName");
                int speciemenIndex = data.findColumn("speciemen");
                int footerIndex = data.findColumn("footer");
                int testIdIndex = data.findColumn("testId");
                int commentIndex = data.findColumn("comment");
                Report report;
                do{
                    reports.add(report = new Report());
                    report.setAge(data.getString(ageIndex));
                    report.setPatientName(data.getString(patientNameIndex));
                    report.setTestPerformedDate(data.getString(dateIndex));
                    report.setSpeciemenCollectedDate(data.getString(dateIndex));
                    report.setReferredBy(data.getString(referredByIndex));
                    report.setGender(data.getString(genderIndex));
                    report.setReportId(data.getInt(reportIdIndex));
                    report.setSpeciemen(data.getString(speciemenIndex));
                    report.setTestName(data.getString(testNameIndex));
                    report.setTestId(data.getInt(testIdIndex));
                    report.setFooter(data.getString(footerIndex));
                    report.setComment(data.getString(commentIndex));
                } while(data.next());
            }
        } catch(Exception ex){
            Logger.getLogger(TestDataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reports;
    }

    public void deleteReport(Report e) {
        try(Connection connection = DbConnectionProvider.getDbConnection()){
            String sql = "delete from tbl_test_report where reportId=?";
            DBHandler.setData(connection, sql, e.getReportId());
        } catch(Exception ex){
            Logger.getLogger(TestDataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
