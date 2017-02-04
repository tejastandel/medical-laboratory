package com.xfinity.data_access_layer;

import com.xfinity.data_access_object.Element;
import com.xfinity.data_access_object.Test;
import com.xfinity.db.DBHandler;
import com.xfinity.db.DbConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestDataAccessLayer {

    public List<Test> getAvailableTests() {
	List<Test> availableTests = new ArrayList<>();
	try (Connection connection = DbConnectionProvider.getDbConnection()) {
	    String sql = "SELECT testId, testName, speciemen, footer FROM tbl_test where isActive='Y' order by testName asc";
	    PreparedStatement preparedStatement = connection.prepareStatement("select te.testElementId, te.testElementName, te.unit, te.`range`, te.results from tbl_test_element as te where te.testId=?");
	    ResultSet testData = DBHandler.getData(connection, sql);
	    if (testData.first()) {
		int indexTestId = testData.findColumn("testId");
		int indexTestName = testData.findColumn("testName");
		int indexFooter = testData.findColumn("footer");
		int indexSpeciemen = testData.findColumn("speciemen");
		Test test;
		do {
		    test = new Test();
		    int testId;
		    test.setTestId(testId = testData.getInt(indexTestId));
		    test.setName(testData.getString(indexTestName));
		    test.setSpeciemen(testData.getString(indexSpeciemen));
		    test.setFooter(testData.getString(indexFooter));
		    ResultSet elementsData = DBHandler.getData(preparedStatement, new Object[]{testId});
		    List<Element> elements = new ArrayList<>();
		    if (elementsData.first()) {
			int indexTestElementName = elementsData.findColumn("testElementName");
			int indexUnit = elementsData.findColumn("unit");
			int indexRange = elementsData.findColumn("range");
			int indexResults = elementsData.findColumn("results");
			int indexElementId = elementsData.findColumn("testElementId");

			Element element;
			do {
			    elements.add(element = new Element());
			    element.setName(elementsData.getString(indexTestElementName));
			    element.setRange(elementsData.getString(indexRange));
			    element.setUnit(elementsData.getString(indexUnit));
			    element.setResults(elementsData.getString(indexResults));
			    element.setElementId(elementsData.getInt(indexElementId));
			} while (elementsData.next());
		    }
		    test.setElements(elements);
		    availableTests.add(test);
		} while (testData.next());
	    }
	} catch (SQLException | ClassNotFoundException ex) {
	    Logger.getLogger(TestDataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
	}
	return availableTests;
    }

    public boolean addTest(Test test) {
	try (Connection connection = DbConnectionProvider.getDbConnection()) {
	    try {
		connection.setAutoCommit(false);
		String insertTestSql = "insert into tbl_test (testName, speciemen, footer, isActive) values (?,?,?,?)";
		int testId = DBHandler.setData(connection, insertTestSql, new Object[]{
		    test.getName(),
		    test.getSpeciemen(),
		    test.getFooter(),
		    "Y"
		});
		String insertTestDetailsSql = "insert into tbl_test_element (testId, testElementName, unit, `range`, results) values (?,?,?,?,?)";
		for (Element element : test.getElements()) {
		    DBHandler.setData(connection, insertTestDetailsSql, new Object[]{
			testId,
			element.getName(),
			element.getUnit(),
			element.getRange(),
			element.getResults()
		    });
		}
		connection.commit();
		return testId > 0;
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
