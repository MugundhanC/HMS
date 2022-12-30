package Adminlogintest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Addvisitorpage;
import hms.pages.Frontofficepage;
import hms.pages.Loginpage;
import hms.utility.Commonutility;
import hms.utility.ReadExcel;

public class Addvisitortest extends Testbase{
	
	Loginpage objlog;
	Frontofficepage objoff;
	Addvisitorpage objaddvis;
	
   public Addvisitortest()
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
	   objoff.clickonvisitorbook();
	   objaddvis=new Addvisitorpage();
   }
	@DataProvider
	public Object getAddvisitordata()
	{
	    Object[][]data=ReadExcel.getTestData("test data");
		return data;
		
	}
  @Test(dataProvider="getAddvisitordata")
   public void addvisitortest(String vis[])
   {
	   String Actualtabletitle=objaddvis.gettabletitle();
	   String Expectedtabletitle="Visitor List";
	   Assert.assertEquals(Actualtabletitle, Expectedtabletitle);
	   
	   objaddvis.clickonaddvisitor();
	   
	   Assert.assertTrue(objaddvis.logoisdisplayed());
	   
	   objaddvis.addvisitordetails(vis);
   }
  @AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
