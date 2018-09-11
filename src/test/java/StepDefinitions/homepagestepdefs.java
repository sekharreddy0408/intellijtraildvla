package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import Utilities.util;
import Utilities.webconnector;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import jxl.read.biff.BiffException;
import methods.homepagemethods;

public class homepagestepdefs {

	//creating object for methods
	public homepagemethods homepage_method;

	//contructor initialising config file and homepage method
    public homepagestepdefs() throws IOException, BiffException {
    	webconnector.intialise();
      homepage_method  =PageFactory.initElements(webconnector.open_browser(),homepagemethods.class);

    }
    
    
    //opening browser and navigating to website
	@Before()
	public void firstbefore() throws IOException{
		webconnector.open_browser();
    	webconnector.gotowebsite();
		
	}
	//quiting browser
	@After()
	public void firstafter(){
		webconnector.quitbrowser();
		
	}
	
	
	
	//clicking on  dvla start button

	@Given("^Click on start of Dvla page$")
	public void click_on_start_of_Dvla_page()  {
		homepage_method.click_on_Start_button();
	}

	//Entering reg number
	@Given("^Enter Registration number$")
	public void enter_Registration_number() throws BiffException, IOException {
		homepage_method.Enter_Reg_Number();
	}

	//clicking continue button
	@Given("^click continue to navigate to next page$")
	public void click_continue_to_navigate_to_next_page(){
		homepage_method.Click_continue();
	}

	//verify make and color
	@Then("^Verify make of the car$")
	public void verify_make_of_the_car()  {
		homepage_method.verifymake();
		}
	
	@Then("^Verify color of the car$")
	public void verify_color_of_the_car() throws IOException  {
		homepage_method.verifycolor();
		util.getscreenshot();
	}
	
	
	
}
