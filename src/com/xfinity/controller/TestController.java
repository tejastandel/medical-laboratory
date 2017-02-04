package com.xfinity.controller;

import com.xfinity.data_access_layer.TestDataAccessLayer;
import com.xfinity.data_access_object.Test;
import java.util.List;

public class TestController {

    private static final TestDataAccessLayer TEST_DAL;

    static {
	TEST_DAL = new TestDataAccessLayer();
    }

    public static boolean addTest(Test test) {
	return TEST_DAL.addTest(test);
    }

    public static List<Test> getAvailableTests() {
	return TEST_DAL.getAvailableTests();
    }
}
