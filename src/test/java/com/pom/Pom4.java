package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Org.baseclass.Baseclass;

public class Pom4 extends Baseclass {
		public Pom4() {
			PageFactory.initElements(driver, this);
		}
		@FindBy(id="first_name")
		private WebElement firstName;
		@FindBy(id="last_name")
		private WebElement lastName;
		@FindBy(id="address")
		private WebElement address;
		@FindBy(id="cc_num")
		private WebElement creditCardNo;
		@FindBy(id="cc_type")
		private WebElement CreditCardType;
		@FindBy(id="cc_exp_month")
		private WebElement expiryMonth;
		@FindBy(id="cc_exp_year")
		private WebElement expiryYear;
		@FindBy(id="cc_cvv")
		private WebElement cvv;
		@FindBy(id="book_now")
		private WebElement bookNow;
		public WebElement getFirstName() {
			return firstName;
		}
		public WebElement getLastName() {
			return lastName;
		}
		public WebElement getAddress() {
			return address;
		}
		public WebElement getCreditCardNo() {
			return creditCardNo;
		}
		public WebElement getCreditCardType() {
			return CreditCardType;
		}
		public WebElement getExpiryMonth() {
			return expiryMonth;
		}
		public WebElement getExpiryYear() {
			return expiryYear;
		}
		public WebElement getCvv() {
			return cvv;
		}
		public WebElement getBookNow() {
			return bookNow;
		}
		public void payment(String firstName, String lastName, String address,String ccno,String cctype,String exmonth,String exyear, String cvv) {
			getFirstName().sendKeys(firstName);
			getLastName().sendKeys(lastName);
			getAddress().sendKeys(address);
			getCreditCardNo().sendKeys("1234567891234567");
			getCreditCardType().sendKeys(cctype);
			getExpiryMonth().sendKeys(exmonth);
			getExpiryYear().sendKeys(exyear);
			getCvv().sendKeys(cvv);
			getBookNow().click();
			}
		public void orderid() {
			WebElement order_no = driver.findElement(By.id("order_no"));
			String orderId = order_no.getAttribute("value");
			System.out.println("Order id is " + orderId);
		
		}
	}
