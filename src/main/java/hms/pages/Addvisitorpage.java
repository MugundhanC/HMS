package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.Commonutility;
import hms.utility.Datepicker;
import net.bytebuddy.asm.Advice.This;



public class Addvisitorpage extends Testbase {
	
	@FindBy(css="h3.box-title")WebElement tabletitle;
	@FindBy(css="div.box-tools>a")WebElement addvisitor;
	@FindBy(xpath="//h4[text()= ' Add Visitor']")WebElement addvisitortitle;
	
	@FindBy(css="form#formadd select[name='purpose']")WebElement purpose;
	@FindBy(css="form#formadd input[name='name']")WebElement pname;
	@FindBy(css="form#formadd input[name='contact']")WebElement phone;
	@FindBy(css="form#formadd input[name='id_proof']")WebElement idcard;
	@FindBy(css="form#formadd input[name='pepples']")WebElement noper;
	@FindBy(css="form#formadd input[name='date']")WebElement datepicker;
	@FindBy(css="form#formadd textarea[name='note']")WebElement note;
	@FindBy(css="form#formadd input[name='file']")WebElement upfile;
	@FindBy(css="button.close")WebElement close;
	
	public Addvisitorpage() 
	{
	  PageFactory.initElements(driver, this);
	}
	
	public String gettabletitle() 
	{
		return tabletitle.getText();
		
	}
	public void clickonaddvisitor()
	{
		addvisitor.click();
	}
	public boolean logoisdisplayed()
	{
		waitforelement(addvisitortitle);
		return addvisitortitle.isDisplayed();
	}
	
	public void addvisitordetails(String dt[]) 
	{
		Select drp=new Select(purpose);
		drp.selectByVisibleText(dt[0]);
		pname.sendKeys(dt[1]);
		phone.sendKeys(dt[2]);
		idcard.sendKeys(dt[3]);
		noper.sendKeys(dt[5]);
		datepicker.click();
		Datepicker dat=new Datepicker();
		dat.datpicker(dt[4]);
		note.sendKeys(dt[6]);
		Commonutility.mousemovement(upfile);
		Commonutility.fileupload(dt[7]);
		close.click();
	}
	
	

}
