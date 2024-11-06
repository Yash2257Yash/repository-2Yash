

package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposeLinkPage  {
	WebDriver driver;

	public ComposeLinkPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	 @FindBy(xpath ="(//span[@class='mailClientCSSButton'])[1]")
			
	private WebElement plusiconinComposeLinkpage;

	public WebElement getplusiconinComposeLinkpage() {
		return plusiconinComposeLinkpage;
	}
	
	
	
	@FindBy(xpath ="//input[@name='subject']")
	
	private WebElement subject;

	public WebElement getsubject() {
		return subject;
	}
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement clickonSavebtn;
	
	
	public WebElement getclickonSavebtn() {
		return clickonSavebtn;
	}
		


}


