package Adminlogintest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Loginpage;

public class Logintest extends Testbase {
	
	Loginpage objlog;
	
	public Logintest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		objlog=new Loginpage();
	}
	
	@Test
	public void hmsadminlogin()
	{
		String Expectedtitle="Smart Hospital : Hospital Management System";
		String actualtitle=objlog.getpagetitle();
		Assert.assertEquals(actualtitle, Expectedtitle);
		
		Assert.assertTrue(objlog.logoisdisplayed());
		
		String Expectedscreentitle="Admin Login";
		String actualscreentitle=objlog.getscreentitle();
		Assert.assertEquals(actualscreentitle, Expectedscreentitle);
		
		objlog.adminlogin(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		
		objlog.adminlogout();
		
	   }
		
		@AfterMethod
		public void teardown()
		{
			driver.close();
		}
	

}
