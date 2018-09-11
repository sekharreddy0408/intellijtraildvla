package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class util {

// waiting for element to appear	
public static WebElement waitforelementtoappear(WebElement element){
	
	WebDriverWait wait = new WebDriverWait(webconnector.driver, 10);
	 
	 return wait.until(ExpectedConditions.elementToBeClickable(element));
	
}


public static void getscreenshot() throws IOException{
	
	File scrFile = ((TakesScreenshot)webconnector.driver).getScreenshotAs(OutputType.FILE);
	// Now you can do whatever you need to do with it, for example copy somewhere
	FileUtils.copyFile(scrFile, new File("DVLA_Test\\target\\screenshotDVLA_PAGE.png"));
}


}
