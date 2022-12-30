package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.Commonutility;
import hms.utility.Datepicker;

public class AddComplainpage extends Testbase {
	
	@FindBy(css="h3.box-title")WebElement tabletitle;
	@FindBy(css="div.box-tools>a")WebElement AddComplain;
	@FindBy(xpath="//h4[text()=' Add Complain']")WebElement AddComplaintitle;
	
	@FindBy(css="form#formadd select[name='complaint']")WebElement complaintype;
	@FindBy(css="form#formadd select[name='source']")WebElement source;
	@FindBy(css="form#formadd input[name='name']")WebElement complainby;
	@FindBy(css="form#formadd input[name='contact']")WebElement phone;
	@FindBy(css="form#formadd input[name='date']")WebElement date;
	@FindBy(css="form#formadd textarea[name='description']")WebElement description;
	@FindBy(css="form#formadd input[name='action_taken']")WebElement actiontaken;
	@FindBy(css="form#formadd input[name='assigned']")WebElement assigned;
	@FindBy(css="form#formadd textarea[name='note']")WebElement note;
	@FindBy(css="form#formadd input[name='file']")WebElement attachdoc;
	
	public AddComplainpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String gettabletitle()
	{
		return tabletitle.getText();
	}
	
	public void clickonaddcomplain()
	{
		AddComplain.click();
	}
	
	public boolean logoisdisplayed()
	{
		waitforelement(AddComplaintitle);
		return AddComplaintitle.isDisplayed();
	}
	
	public void addcomplaindetails()
	{
		Select drp1=new Select(complaintype);
		drp1.selectByVisibleText("o2 prblm");
		Select drp2=new Select(source); 
		drp2.selectByVisibleText("Oxygen level");
		complainby.sendKeys("Mugu");
		phone.sendKeys("9865571263");
		date.click();
		Datepicker dat=new Datepicker();
		dat.datpicker("19/4/2005");
		description.sendKeys("hai doctor");
		actiontaken.sendKeys("take Rest");
		assigned.sendKeys("pls assigned");
		note.sendKeys("o2 level low");
		Commonutility.mousemovement(attachdoc);
		Commonutility.fileupload("E:\\Trio Tend Solutions\\GUI CHECKLIST");
	}
	
	
	
	
	

	
	
	
}
