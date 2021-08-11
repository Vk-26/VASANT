package com.Stepdef;
import com.pom.Pom1;
import com.pom.Pom2;
import com.pom.Pom3;
import com.pom.Pom4;
import Org.baseclass.Baseclass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDef extends Baseclass {

	@Given("User should login by using {string}, {string} and click login button")
	public void userShouldLoginByUsingAndClickLoginButton(String Vasanthuser, String Password) {
			Pom1 p1=new Pom1();
			p1.loginPage(Vasanthuser, Password);
	}

	@Given("User should enter the {string},{string},{string},{string},{string},{string},{string},{string} and click search button")
	public void userShouldEnterTheAndClickSearchButton(String location, String hotels, String roomtype, String noOfroom, String checkIn, String checkOut, String adultPerroom, String childPerroom) {
		Pom2 p2=new Pom2();
		p2.searchHotel(location, hotels, roomtype, noOfroom, checkIn, checkOut, adultPerroom, childPerroom);
	}

	@Then("User should click the checkbox and Search button")
	public void userShouldClickTheCheckboxAndSearchButton() {
		Pom3 p3 =new Pom3();
		p3.hotel();
	}

	@Then("User should enter some details like {string},{string},{string},{string},{string},{string},{string},{string} and click Book Now button")
	public void userShouldEnterSomeDetailsLikeAbdClickBookNowButton(String firstName, String lastName, String address, String ccno, String cctype, String exmonth, String exyear, String cvv) {
		Pom4 p4=new Pom4();
		p4.payment(firstName, lastName, address, ccno, cctype, exmonth, exyear, cvv);
	}

	@Then("User should validate the Booking Confirmation")
	public void userShouldValidateTheBookingConfirmation() throws InterruptedException {
		Pom4 p4=new Pom4();
		Thread.sleep(7000);
		p4.orderid();
	}
}
