package com.xfinity.data_access_object;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private int testId;
    private String name;
    private String speciemen;
    private String footer;
    private final List<Element> elements = new ArrayList<>(0);
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return name;
    }

    public void setElements(List<Element> elements) {
        this.elements.clear();
        this.elements.addAll(elements);
    }

    public List<Element> getElements() {
        return this.elements;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
