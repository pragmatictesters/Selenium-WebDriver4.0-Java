package com.pragmatic.testng;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class PTLTestSuiteListener  implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Starting the test suite");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Completing the test suite");
    }

}
