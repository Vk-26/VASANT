package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Org.baseclass.Baseclass;

public class Pom1 extends Baseclass {
	public Pom1() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	private WebElement txtusr;

	@FindBy(id="password")
	private WebElement txtpass;

	@FindBy(id="login")
	private WebElement btnlogin;



	public WebElement getTxtusr() {
		return txtusr;
	}

	public WebElement getTxtpass() {
		return txtpass;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}

	public void loginPage(String Vasanthuser,String Password) {
		getTxtusr().sendKeys(Vasanthuser);
		getTxtpass().sendKeys(Password);
		getBtnlogin().click();
	}

}


