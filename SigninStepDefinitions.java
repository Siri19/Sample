package stepDefinitionFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.GherkinKeyword;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber_Methods.BaseUtil;
import cucumber_Methods.Login_PageFactory;

public class SigninStepDefinitions extends BaseUtil 
{
	public BaseUtil base;
	public SigninStepDefinitions(BaseUtil base) {
		this.base=base;
		
	}

	// WebDriver driver;
	 @Given("^chrome browser is launched$")
	 public void browser_is_launched() throws Throwable
	 {
		 stepDef.createNode(new GherkinKeyword("Given"), "chrome browser is launched");

	 	/*System.setProperty("webdriver.chrome.driver","/home/siri/Documents/Selenium/chromedriver");
	 	driver = new ChromeDriver();*/

	 }

	 @When("^enter Login url$")
	 public void enter_Login_site() throws Throwable 
	 {
		 stepDef.createNode(new GherkinKeyword("When"), "enter Login url");
	 	driver.get("http://tvishasystems.com/webdemo/timedynamo_testing/public/");
	 	driver.manage().window().maximize();
	 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	Login_PageFactory obj=new Login_PageFactory(driver);
	 	obj.loginlink_ClickAction();
	        
	 }
	 //Regular expressions can use \"([^\"]*)\"
	 //Can use \"(.*)\"
	 @Then("^enter \"([^\\\"]*)\" And enter \"(.*)\"$")
	 public void enter_User_name_and_enter_Password(String userName, String password) throws Throwable {
      stepDef.createNode(new GherkinKeyword("Then"),"enter"+userName+"Password is "+password);
		 Login_PageFactory obj=new Login_PageFactory(driver);
	 	obj.login1(userName	,password);
	 	//driver.close();
	 }


	 @Then("^click sign in button$")
	 public void click_sign_in_button() throws Throwable {
		 stepDef.createNode(new GherkinKeyword("Then"),"click sign in button");
	   //  driver.findElement(By.id("bG9naW5CdG4")).click();
	    
	 }
}
