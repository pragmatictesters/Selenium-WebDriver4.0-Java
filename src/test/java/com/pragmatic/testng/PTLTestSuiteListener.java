package com.pragmatic.testng;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class PTLTestSuiteListener extends  TestListenerAdapter implements ISuiteListener {

    private int m_count = 0;

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Test suite is started ");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Test suite is completed ");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        log("F>>");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        log("S>>");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        log(".>>");
    }

    private void log(String string) {
        System.out.print(string);
        if (++m_count % 40 == 0) {
            System.out.println("");
        }
    }

}
