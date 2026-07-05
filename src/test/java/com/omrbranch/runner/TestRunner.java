package com.omrbranch.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.report.Reporting;
import com.omrbranch.utility.BaseClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@TC6Y",
		dryRun = false,
		stepNotifications = true,
		snippets = SnippetType.CAMELCASE,
		publish = true,
		monochrome = false,
		plugin = {
				"pretty",
				"html:target/cucumber.html",
				"json:target/cucumber.json",
				"junit:target/cucumber.xml"
		},
		glue = {
				"com.omrbranch.stepdefinition",
				"com.omrbranch.hooks"
		},
		features = "src/test/resources/features"
)
public class TestRunner extends BaseClass {

	@AfterClass
	public static void afterClass() throws IOException {

		Reporting.generateJvmReport(
			getProjectPath()+	getPropertyFileValue("jsonPath"),
			getProjectPath()+	getPropertyFileValue("jvmReportPath"));
	}
}