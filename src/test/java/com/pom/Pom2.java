package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Org.baseclass.Baseclass;

public class Pom2 extends Baseclass{
	public Pom2() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="location")
	private WebElement location;
	@FindBy(id="hotels")
	private WebElement hotels;
	@FindBy(id="room_type")
	private WebElement roomType;
	@FindBy(id="room_nos")
	private WebElement roomNos;
	@FindBy(id="datepick_in")
	private WebElement fromDate;
	@FindBy(id="datepick_out")
	private WebElement toDate;
	@FindBy(id="adult_room")
	private WebElement adultRoom;
	@FindBy(id="child_room")
	private WebElement childRoom;
	@FindBy(id="Submit")
	private WebElement submit;
	public WebElement getSubmit() {
		return submit;
	}
	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotels() {
		return hotels;
	}
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getRoomNos() {
		return roomNos;
	}
	public WebElement getFromDate() {
		return fromDate;
	}
	public WebElement getToDate() {
		return toDate;
	}
	public WebElement getAdultRoom() {
		return adultRoom;
	}
	public WebElement getChildRoom() {
		return childRoom;
	}
	public void searchHotel(String location, String hotels, String roomtype, String noOfroom,
			String checkIn, String checkOut, String adultPerroom, String childPerroom) {
		getLocation().sendKeys(location);
		getHotels().sendKeys(hotels);
		getRoomType().sendKeys(roomtype);
		getRoomNos().sendKeys(noOfroom);
		getAdultRoom().sendKeys(adultPerroom);
		getChildRoom().sendKeys(childPerroom);
		getFromDate().sendKeys(checkIn);
		getToDate().sendKeys(checkOut);
		getSubmit().click();


	}

}


