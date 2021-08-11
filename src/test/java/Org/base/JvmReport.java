package Org.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class JvmReport {
	public static void report(String jsonfile) {
		File a=new File("C:\\Users\\Vishnu Vardhan\\eclipse-workspace\\Cucumberclass\\src\\test\\resources\\report");
		Configuration Con =new Configuration(a, "Adactin Hotel"); 
		Con.addClassifications("OS","Windows 10");
		Con.addClassifications("Browser","Chrome");
		Con.addClassifications("Version","92");
		Con.addClassifications("sprint","36");
		Con.addClassifications("sign-off","positive");
		List<String> b=new ArrayList<String>();
		b.add(jsonfile);
		ReportBuilder report=new ReportBuilder(b, Con);
		report.generateReports();
	}
}
