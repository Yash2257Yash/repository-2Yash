package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
//create seperate java class
//object creation
public class LoginPage extends WebDriverUtility{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	@FindAll({@FindBy (name="user_name"),@FindBy(xpath="//input[@type='text']")})
	private WebElement usernameEdt;
	 @FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
	private WebElement passwordEdt;
	@FindAll({@FindBy(xpath = "//input[@type='submit']"),@FindBy(id="submitButton")})
	private WebElement loginBtn;
	//Object initialization
	
	//object encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//provide ACTION
	public void logintoApp(String url,String username,String Password)
	{
		waitForPageToLoad(driver);
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(Password);
		loginBtn.click();
	}
	public void logintoApp(String username,String Password)
	{
		waitForPageToLoad(driver);
		//driver.get("http://localhost:8888");
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(Password);
		loginBtn.click();
	}

}
