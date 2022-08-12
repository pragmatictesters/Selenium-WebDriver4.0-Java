package com.pragmatic.hrm;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",
        features = {"src/test/resources/features/Login.feature"},
        glue = {"com.pragmatic.hrm.steps"},
        dryRun = true,
        monochrome = false,
        publish = true
)
public class CucumberTestNGTestRunner extends AbstractTestNGCucumberTests {
}
