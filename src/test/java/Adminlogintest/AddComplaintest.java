package Adminlogintest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.AddComplainpage;
import hms.pages.Frontofficepage;
import hms.pages.Loginpage;

public class AddComplaintest extends Testbase {
	
	Loginpage objlog;
	Frontofficepage objoff;
	AddComplainpage objcom;
	
	public AddComplaintest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		objlog=new Loginpage();
		objlog.adminlogin(prop.getProperty("USERNAME"),prop.getProperty("PASSWORD"));
		objoff=new Frontofficepage();
		objoff.cliconfrontoffice();
		objoff.clickoncomplain();
		objcom=new AddComplainpage();
	}
	@Test
	public void addcomplaintest()
	{
		String actualtitle=objcom.gettabletitle();
		String expectedtitle="Complain List";
		Assert.assertEquals(actualtitle, expectedtitle);
		
		objcom.clickonaddcomplain();
		
		Assert.assertTrue(objcom.logoisdisplayed());
		
		objcom.addcomplaindetails();
	}
	@AfterMethod
	public void teardown()
	{
		//driver.close();
	}
	
	
	
	
	

}
