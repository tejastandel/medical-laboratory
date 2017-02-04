package com.xfinity.data_access_object;

import java.util.ArrayList;
import java.util.List;

public class Report {

    private String patientName;
    private String testName;
    private String age;
    private String referredBy;
    private String gender;
    private String speciemen;
    private String footer;
    private String testPerformedDate;
    private String speciemenCollectedDate;

    private final List<ElementResult> results = new ArrayList<>();
    private int testId;
    private int reportId;
    private String comment;

    public String getPatientName() {
	return patientName;
    }

    public void setPatientName(String patientName) {
	this.patientName = patientName;
    }

    public String getTestName() {
	return testName;
    }

    public void setTestName(String testName) {
	this.testName = testName;
    }

    public String getAge() {
	return age;
    }

    public void setAge(String age) {
	this.age = age;
    }

    public String getReferredBy() {
	return referredBy;
    }

    public void setReferredBy(String referredBy) {
	this.referredBy = referredBy;
    }

    public String getGender() {
	return gender;
    }

    public void setGender(String gender) {
	this.gender = gender;
    }

    public String getSpeciemen() {
	return speciemen;
    }

    public void setSpeciemen(String speciemen) {
	this.speciemen = speciemen;
    }

    public String getFooter() {
	return footer;
    }

    public void setFooter(String footer) {
	this.footer = footer;
    }

    public String getTestPerformedDate() {
	return testPerformedDate;
    }

    public void setTestPerformedDate(String testPerformedDate) {
	this.testPerformedDate = testPerformedDate;
    }

    public List<ElementResult> getResults() {
	return results;
    }

    public void setResults(List<ElementResult> results) {
	this.results.clear();
	this.results.addAll(results);
    }

    public int getTestId() {
	return testId;
    }

    public void setTestId(int testId) {
	this.testId = testId;
    }

    public int getReportId() {
	return reportId;
    }

    public void setReportId(int reportId) {
	this.reportId = reportId;
    }

    public String getSpeciemenCollectedDate() {
	return speciemenCollectedDate;
    }

    public void setSpeciemenCollectedDate(String speciemenCollectedDate) {
	this.speciemenCollectedDate = speciemenCollectedDate;
    }

    public void setComment(String comment) {
	this.comment = comment;
    }

    public String getComment() {
	return comment;
    }
}
