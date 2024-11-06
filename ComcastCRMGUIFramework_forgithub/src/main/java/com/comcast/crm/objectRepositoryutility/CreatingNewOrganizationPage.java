package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {

	public CreatingNewOrganizationPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//input[@class='detailedViewTextBox']"), @FindBy(name = "accountname") })
	private WebElement EnterorgName;
	@FindBy(xpath = "(//input[@value='  Save  '])[1]")
	private WebElement clickonsavebtn;
	@FindBy(name = "industry")
	private WebElement industrydd;

	public WebElement getEnterorgName() {
		return EnterorgName;
	}

	public WebElement getClickonsavebtn() {
		return clickonsavebtn;
	}

	public void createorg(String orgname) {
		EnterorgName.sendKeys(orgname);
		clickonsavebtn.click();

	}

	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement Typeselectdd;

	public WebElement getTypeselect() {
		return Typeselectdd;
	}

	public void SelectType(String text) {

		Select sel = new Select(Typeselectdd);
		sel.selectByVisibleText(text);
	}

	public void createorgwithIndstrywithtype(String orgname, String industry, String type) {
		EnterorgName.sendKeys(orgname);
		Select sel = new Select(industrydd);
		sel.selectByVisibleText(industry);
//		Select sel1=new Select(Typeselectdd);
//		sel1.selectByVisibleText(type);
		SelectType(type);
		clickonsavebtn.click();
	}

	@FindBy(xpath = ("//input[@id='phone']"))
	private WebElement phonenumber;

	public WebElement getphonenum() {
		return phonenumber;
	}

	public void CreateOrgwithPhonenum(String orgname, String Phnum) {
		EnterorgName.sendKeys(orgname);
		phonenumber.sendKeys(Phnum);
		clickonsavebtn.click();
	}
}
