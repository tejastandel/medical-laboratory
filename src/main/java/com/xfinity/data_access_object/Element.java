package com.xfinity.data_access_object;

public class Element {

    private String name;
    private String unit;
    private String range;
    private String results;
    private int elementId;
    private boolean grouping;
    private int floatingPoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public boolean isGrouping() {
        return grouping;
    }

    public void setGrouping(boolean grouping) {
        this.grouping = grouping;
    }

    public int getFloatingPoints() {
        return floatingPoints;
    }

    public void setFloatingPoints(int floatingPoints) {
        this.floatingPoints = floatingPoints;
    }
}
