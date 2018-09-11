package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class webconnector {
	// intitalising files and driver
	public static WebDriver driver = null;
	public static String browser = null;
	public static FileInputStream configfile = null;
	public static Properties prop = null;
	public static FileInputStream fis = null;
	public static Workbook wb =null;
	public static Sheet sheetdata =null;

	// intialise the config file

	public static void intialise() throws IOException, BiffException {
		configfile = new FileInputStream("src\\main\\java\\resource\\Config.properties");
		prop = new Properties();
		prop.load(configfile);
		fis = new FileInputStream("src\\main\\java\\resource\\TestFolder\\test1.xls");

	    wb = Workbook.getWorkbook(fis);
	    sheetdata = wb.getSheet(0);
	}

	// getting browser from config file

	public static String getbrowser() {
		return browser = prop.getProperty("browser");

	}

	/////////////////////////////////////// OPEN BROWSER////////////////////////////////////////////////////////
	public static WebDriver open_browser() {

		if (driver == null) {

			// firefox browser
			if (getbrowser().equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"src\\main\\java\\resource\\geckodriver.exe");
				driver = new FirefoxDriver();

				// Chrome browser
			} else if (getbrowser().equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "src\\main\\java\\resource\\chromedriver.exe");
				driver = new ChromeDriver();

				// IE browser
			} else if (getbrowser().equalsIgnoreCase("IE")) {

				System.setProperty("webdriver.ie.driver", "path to ie driver");
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				ieCapabilities.setCapability("nativeEvents", false);
				ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
				ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
				ieCapabilities.setCapability("disable-popup-blocking", true);
				ieCapabilities.setCapability("enablePersistentHover", true);
				driver = new InternetExplorerDriver(ieCapabilities);

			}

		}

		return driver;
	}

	// navigating to website
	public static void gotowebsite() {

		if (!webconnector.driver.getCurrentUrl().contains("dvla")) {
			webconnector.driver.manage().window().maximize();
			webconnector.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			webconnector.driver.get(prop.getProperty("url"));

		}
	}

	// quit browser
	public static void quitbrowser() {
		webconnector.driver.quit();
	}

}
