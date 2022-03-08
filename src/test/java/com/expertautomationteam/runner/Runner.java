package com.expertautomationteam.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/nacer-zimu/GitHubProjects/eat-cucumber-framework/src/test/resources/login.feature",
        glue = "com.expertautomationteam.stepdef",
        plugin = {"pretty", "junit:junit_xml/cucumber.xml"},
        monochrome = true,
        //strict = true,
        dryRun = true,
        tags = {"@Regression"}
)

public class Runner {

}
