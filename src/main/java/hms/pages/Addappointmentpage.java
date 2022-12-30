package hms.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.Datepicker;

public class Addappointmentpage extends Testbase {
	@FindBy(css="div.box-tools>a")WebElement Addappointment;
	@FindBy(css="h4.box-title")WebElement Appointmenttitle;
	
	@FindBy(css="form#formadd input#date")WebElement datepicker;
	@FindBy(css="form#formadd input[name='patient_id']")WebElement pid;
	@FindBy(css="form#formadd input[name='patient_name']")WebElement pname;
	@FindBy(css="form#formadd select[name='gender']")WebElement gender;
	@FindBy(css="form#formadd input[name='email']")WebElement email;
	@FindBy(css="form#formadd input[name='mobileno']")WebElement phone;
	@FindBy(css="form#formadd select[name='doctor']")WebElement doctor;
	@FindBy(css="form#formadd textarea[name='message']")WebElement message;
	@FindBy(css="form#formadd select[name='appointment_status']")WebElement status;
	
	public Addappointmentpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonaddappointment()
	{
		Addappointment.click();
	}
	
	public boolean appointmenttitle()
	{
		waitforelement(Appointmenttitle);
		return Appointmenttitle.isDisplayed();	
	}
	
	public void  addappointmentdetails()
	{
     datepicker.sendKeys("19/04/2005");
	 pid.sendKeys("1930");
	 pname.sendKeys("Mugu");
	 Select drp=new Select(gender);
	 drp.selectByVisibleText("Male");
	 email.sendKeys("mugupoo@gmail.com");
	 phone.sendKeys("854723698");
	 Select dr=new Select(doctor);
	 dr.selectByVisibleText("Ranjeeth R");
	 message.sendKeys("hai doctor,how are you");
	 Select stat=new Select(status);
	 stat.selectByVisibleText("Approved");
	 
	 
	 
	 
	}
	
	
	

}
 