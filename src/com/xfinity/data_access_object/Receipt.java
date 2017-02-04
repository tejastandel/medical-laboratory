package com.xfinity.data_access_object;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    
    private String patientName;
    private String age;
    private String gender;
    private String date;
    private final List<ReceiptTest> receiptTests = new ArrayList<>();

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ReceiptTest> getReceiptTests() {
        return receiptTests;
    }
    
    public void setReceiptTests(List<ReceiptTest> receiptTests) {
        this.receiptTests.clear();
        this.receiptTests.addAll(receiptTests);
    }

}
