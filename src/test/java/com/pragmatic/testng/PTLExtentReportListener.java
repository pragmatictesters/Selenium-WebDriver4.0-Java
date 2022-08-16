package com.pragmatic.testng;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class PTLExtentReportListener  extends TestListenerAdapter {

    private int m_count = 0;

    @Override
    public void onTestFailure(ITestResult tr) {
        log(String.format("F>>%s< %s< %s <<<",tr.getName(), tr.getMethod(),tr.getTestName()  ));
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
