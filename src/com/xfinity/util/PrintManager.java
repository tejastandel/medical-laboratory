/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xfinity.util;

import com.xfinity.data_access_object.ElementResult;
import com.xfinity.data_access_object.Receipt;
import com.xfinity.data_access_object.ReceiptTest;
import com.xfinity.data_access_object.Report;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Supun Lakshan
 */
public class PrintManager {

    public static void printReport(Report report) throws JRException, FileNotFoundException, ParseException {
	HashMap<String, Object> parameters = new HashMap<>();
	parameters.put("age", report.getAge());
	parameters.put("collectedDate", report.getSpeciemenCollectedDate());
	parameters.put("performedDate", report.getTestPerformedDate());
	parameters.put("footer", report.getFooter());
	parameters.put("gender", report.getGender());
	parameters.put("comment", report.getComment());
	parameters.put("patientName", report.getPatientName());
	parameters.put("referredBy", report.getReferredBy());
	parameters.put("speciemen", report.getSpeciemen());
	SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat formatter = new SimpleDateFormat("MMddyy");
	parameters.put("speciemenNo", String.format("R%d%s", report.getReportId(), formatter.format(parser.parse(report.getTestPerformedDate()))));
	parameters.put("testName", report.getTestName());

	File unCompiled = new File("reports/report.jrxml");
	File compiled = new File("reports/report-template.rpt");
	//Compile report file if not exists or modified
	if (unCompiled.exists() && (!compiled.exists() || (compiled.lastModified() < unCompiled.lastModified()))) {
	    JasperCompileManager.compileReportToStream(new FileInputStream(unCompiled), new FileOutputStream(compiled));
	}

	Vector<String> columns = new Vector<>();
	columns.add("Description");
	columns.add("Result");
	columns.add("Units");
	columns.add("Ranges");

	DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
	for (ElementResult result : report.getResults()) {
	    tableModel.addRow(new Object[]{
		result.getName(),
		result.getResult(),
		result.getUnit(),
		result.getRange()
	    });
	}
	JRDataSource dataSource = new JRTableModelDataSource(tableModel);
	JasperPrint filledReport = JasperFillManager.fillReport(new FileInputStream(compiled), parameters, dataSource);
	filledReport.setOrientation(OrientationEnum.PORTRAIT);
	JasperViewer.viewReport(filledReport, false);
    }

    public static void printReceipt(Receipt receipt) throws JRException, FileNotFoundException, ParseException {
	HashMap<String, Object> parameters = new HashMap<>();
	parameters.put("age", receipt.getAge());
	parameters.put("collectedDate", receipt.getDate());
	parameters.put("gender",receipt.getGender());
	parameters.put("patientName", receipt.getPatientName());

	File unCompiled = new File("reports/receipt.jrxml");
	File compiled = new File("reports/receipt-template.rpt");
	//Compile report file if not exists or modified
	if (unCompiled.exists() && (!compiled.exists() || (compiled.lastModified() < unCompiled.lastModified()))) {
	    JasperCompileManager.compileReportToStream(new FileInputStream(unCompiled), new FileOutputStream(compiled));
	}

	Vector<String> columns = new Vector<>();
	columns.add("Description");
	columns.add("Price");
	columns.add("Qty");
	columns.add("Discount");

	DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
	for (ReceiptTest test : receipt.getReceiptTests()) {
	    tableModel.addRow(new Object[]{
		test.getTestName(),
		test.getAmount(),
		test.getQty(),
		test.getDiscount()
	    });
	}
	JRDataSource dataSource = new JRTableModelDataSource(tableModel);
	JasperPrint filledReport = JasperFillManager.fillReport(new FileInputStream(compiled), parameters, dataSource);
	filledReport.setOrientation(OrientationEnum.PORTRAIT);
	JasperViewer.viewReport(filledReport, false);
	//JasperPrintManager.printReport(filledReport, true);
    }
}
