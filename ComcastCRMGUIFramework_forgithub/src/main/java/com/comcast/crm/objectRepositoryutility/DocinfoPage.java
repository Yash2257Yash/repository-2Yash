package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocinfoPage {
WebDriver driver;
	public DocinfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath="//span[@id='dtlview_Title']")
		private WebElement headermsg;

		public WebElement getHeadermsg() {
			return headermsg;
		}

	}


