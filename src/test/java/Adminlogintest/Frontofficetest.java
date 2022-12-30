package Adminlogintest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Frontofficepage;
import hms.pages.Loginpage;

public class Frontofficetest extends Testbase {
	
	Loginpage objlog;
	Frontofficepage objoff;
	
	public Frontofficetest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		objlog=new Loginpage();
		objlog.adminlogin(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		objoff=new Frontofficepage();
	}
	
	@Test
	public void frontofficetest()
	{
		objoff.cliconfrontoffice();
		
		 String Expectedtabletitle="Appointment Details";
		 String Actualtabletitle=objoff.gettabletitle();
		 
		 Assert.assertEquals(Actualtabletitle, Expectedtabletitle);
		 
		 objoff.clickonvisitorbook();
		 
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	

}
