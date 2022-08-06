package com.pragmatic.assertj;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AssertPatternsExample {

    @Test
    public void testPatterns(){
        String pageTitle = "OrangeHRM";

        assertThat(pageTitle).containsPattern("[Oo]range[HRMhrm]{3}");

    }
}
