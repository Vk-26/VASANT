package com.runner.Package;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import Org.base.JvmReport;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features\\Booking.feature",glue="com.Stepdef",dryRun=false,snippets=SnippetType.CAMELCASE,monochrome=true,plugin= {"pretty","json:C:\\Users\\Vishnu Vardhan\\eclipse-workspace\\Cucumbertask\\src\\test\\resources\\Report\\output.json"})
public class TestRunner{
	@AfterClass
	public static void afterclass() {
	JvmReport.report("C:\\Users\\Vishnu Vardhan\\eclipse-workspace\\Cucumbertask\\src\\test\\resources\\Report\\output.json");

	}

}















