package hms.pages;

import org.bouncycastle.asn1.ess.SigningCertificate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.Testbase;

public class Loginpage extends Testbase {
	
	@FindBy(css="img[src='http://triotend.com/tts/backend/images/s_logo.png']")WebElement logo;
	@FindBy(css="h3.font-white")WebElement logintxt;
	@FindBy(css="input#email")WebElement username;
	@FindBy(css="input#password")WebElement password;
	@FindBy(css="button.btn")WebElement siginin;
	@FindBy(css="img.topuser-image")WebElement profile;
	@FindBy(css="div.sspass>a:nth-child(3)")WebElement logout;

	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//To get page title
	public String getpagetitle()
	{
		return driver.getTitle();
	}
	
	//To get screentitle
	public String getscreentitle()
	{
		return logintxt.getText();
	}
	
	//To check logo
	public boolean logoisdisplayed()
	{
		return logo.isDisplayed();
	}
	
	//login
	public void adminlogin(String uname,String pass)
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		siginin.click();
	}
	
	//logout
	public void adminlogout()
	{
		profile.click();
		logout.click();
	}
	
	
}
