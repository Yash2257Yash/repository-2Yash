package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createNewOppertunitiesPage {

	
		WebDriver driver;

		public createNewOppertunitiesPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath="//img[@alt='Create Opportunity...']")
		private WebElement createNewoppertunities;
		

		public WebElement getcreateNewoppertunities() {
			return createNewoppertunities;
		}
		//click on save btn
		@FindBy(xpath ="//input[@value='  Save  ']")
		private WebElement savebtn;
		

		public WebElement getsavebtn() {
			return savebtn;
		}

	
}
