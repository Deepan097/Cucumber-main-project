package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
/**
 * 
 * @author Deepan
 *@description Used to run the cucumber project
 *@date 28/08/22
 */
@RunWith(Cucumber.class)
// tages="not @CancelBookingOnly"
@CucumberOptions(features = "src\\test\\resources\\Features", glue = "com.stepdefinition", dryRun = false, stepNotifications = true, publish = true,
plugin = {"pretty", "json:target\\output.json"}, monochrome = true, snippets = SnippetType.CAMELCASE)

public class TestRunnerClass {

	@AfterClass
	public static void afterClass() {
		Reporting.generateJVMReport(System.getProperty("user.dir") + "\\target\\Output.json");

	}
}