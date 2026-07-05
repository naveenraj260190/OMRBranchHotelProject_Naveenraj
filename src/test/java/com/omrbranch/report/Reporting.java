package com.omrbranch.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void generateJvmReport(String jsonFile, String jvmReportPath) {

		// Create Configuration Object
		Configuration configuration = new Configuration(new File(jvmReportPath), "OMR Branch Hotel Project");

		// Report Classifications
		configuration.addClassifications("Project", "OMR Branch Hotel Project");
		configuration.addClassifications("Module", "Hotel Booking");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Browser Version", "Latest");
		configuration.addClassifications("OS", "Windows 11");
		configuration.addClassifications("Environment", "QA");
		configuration.addClassifications("Testing Type", "Regression");
		configuration.addClassifications("Framework", "Selenium Java + Cucumber");
		configuration.addClassifications("Build Tool", "Maven");
		configuration.addClassifications("Execution", "Local");
		configuration.addClassifications("Author", "Naveenraj");

		// Add JSON Report
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		// Generate JVM Report
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);

		reportBuilder.generateReports();
	}
}