package com.xfinity.data_access_object;

public class ElementResult {

    private String name;
    private String unit;
    private String range;
    private String result;
    private int elementId;

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

    public String getResult() {
	return result;
    }

    public void setResult(String result) {
	this.result = result;
    }

    public int getElementId() {
	return elementId;
    }

    public void setElementId(int elementId) {
	this.elementId = elementId;
    }

    @Override
    public String toString() {
        return "ElementResult{" + "name=" + name + ", unit=" + unit + ", range=" + range + ", result=" + result + ", elementId=" + elementId + '}';
    }
    
}
