package com.Stepdef;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import Org.baseclass.Baseclass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class hooksClass extends Baseclass{
	@Before
	public void beforesce() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/HotelAppBuild2/");
		driver.manage().window().maximize();
	}
	@After
	public void aftersce(Scenario sc) {
		if (sc.isFailed()) {
			TakesScreenshot js=(TakesScreenshot)driver;
			byte[] screenshotAs = js.getScreenshotAs(OutputType.BYTES);
			sc.embed(screenshotAs, sc.getName()+".png");
			driver.quit();

		}

	}
}