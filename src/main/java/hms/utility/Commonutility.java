package hms.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import hms.base.Testbase;

public class Commonutility extends Testbase {
	
	//Mousemovement
	public static void mousemovement(WebElement el)
	{
		Actions act=new Actions(driver);
		act.moveToElement(el).click().build().perform();
	}
	
	//Fileupload
	public static void fileupload(String loc) 
	{
		StringSelection sel=new StringSelection(loc);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
	    
	    try {
	    	Thread.sleep(4000);
			Robot rbt=new Robot();
			
			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);
			
			rbt.keyPress(KeyEvent.VK_CONTROL);
			rbt.keyPress(KeyEvent.VK_V);
			rbt.keyRelease(KeyEvent.VK_CONTROL);
			rbt.keyRelease(KeyEvent.VK_V);
			
			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);
			
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Take Screenshot
	public static void takescreenshot()
	{
	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 File desig=new File(System.getProperty("user.dir")+"./Screenshot/"+System.currentTimeMillis()+".png");
	 try {
		FileHandler.copy(src, desig);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	}

}
