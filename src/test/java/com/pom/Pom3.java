package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Org.baseclass.Baseclass;

public class Pom3 extends Baseclass {
	public Pom3() {
		PageFactory.initElements(driver, this);	
	}
	@FindBy(id="radiobutton_0")
	private WebElement rdbtn;
	@FindBy(id="continue")
	private WebElement contn;
	public WebElement getRdbtn() {
		return rdbtn;
	}
		public WebElement getContn() {
			return contn;
		}
		public void hotel() {
			getRdbtn().click();
			getContn().click();
		}
		
	}
