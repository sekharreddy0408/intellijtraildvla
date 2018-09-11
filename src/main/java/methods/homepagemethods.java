package methods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.util;
import Utilities.webconnector;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class homepagemethods extends webconnector{

	//repository for elements
	
	@FindBy(linkText="Start now")
    public static WebElement click_On_Start;
	
	@FindBy(css="input.form-control.form-control-1-4.input-upper")
    public static WebElement Text_Reg;
	
	@FindBy(name="Continue")
    public static WebElement click_continue;
	
	@FindBy(xpath="//*[@id='pr3']/div/ul/li[2]/span[2]/strong")
    public static WebElement make;
	
	@FindBy(xpath="//*[@id='pr3']/div/ul/li[3]/span[2]/strong")
    public static WebElement color;
	
	
	//Clickinig on start button
	public static void click_on_Start_button(){
try {

	util.waitforelementtoappear(click_On_Start);
	click_On_Start.click();

} catch ( Exception e) {
	
	e.printStackTrace();
}
		
	}


	//Entering text of reg number
	public static void Enter_Reg_Number() {
		try {
	
	util.waitforelementtoappear(Text_Reg);
	Text_Reg.sendKeys(sheetdata.getCell(0,0).getContents());

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	//Clicking on continue
	public static void Click_continue(){
try {

	util.waitforelementtoappear(click_continue);
	click_continue.click();

} catch (Exception e) {
	
	e.printStackTrace();
}
		
	}
	
	
//verifying make
	public static void verifymake(){
try {
	
	util.waitforelementtoappear(make);
	Assert.assertEquals(sheetdata.getCell(1,0).getContents(), make.getText());
	
} catch (Exception e) {
	
	e.printStackTrace();
}
		
	}
	
	
	//verifying color
	public static void verifycolor(){
try {
	
	util.waitforelementtoappear(color);
	Assert.assertEquals(sheetdata.getCell(2,0).getContents(), color.getText());
	
		
} catch (Exception e) {
	
	e.printStackTrace();
}
		
	}
	
}
