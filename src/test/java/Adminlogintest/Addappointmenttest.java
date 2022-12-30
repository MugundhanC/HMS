package Adminlogintest;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Addappointmentpage;
import hms.pages.Frontofficepage;
import hms.pages.Loginpage;

public class Addappointmenttest extends Testbase {
	
	Loginpage objlog;
	Frontofficepage objoff;
	Addappointmentpage objapp;
	
	public Addappointmenttest()
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
		   objapp=new Addappointmentpage();
	}
	
	@Test
	public void addappointmenttest()
	{
		objapp.clickonaddappointment();
		
		Assert.assertTrue(objapp.appointmenttitle());
		
		objapp.addappointmentdetails();
	}

}
