package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	

	WebDriver  driver;
	
	@Given("User should able to click the sign up button and go to the registration page")
	public void user_should_able_to_click_the_sign_up_button_and_go_to_the_registration_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PremkumarS\\eclipse-workspace\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@When("I enter the firstname as {string}")
	public void i_enter_the_firstname_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"login-block\"]/div/ul/li[1]/a")).click();
		driver.findElement(By.id("registration_firstname")).sendKeys(string);
	}
	
	@When("I enter the Lastname as {string}")
	public void i_enter_the_lastname_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("registration_lastname")).sendKeys(string);
	}
	@When("I enter the email as {string}")
	public void i_enter_the_email_as(String string) {
		driver.findElement(By.id("registration_email")).sendKeys(string);
	    
	}
	@When("I enter the username as {string}")
	public void i_enter_the_username_as(String string) {
	driver.findElement(By.id("username")).sendKeys(string);
	    
	}
	@When("I enter the password as {string}")
	public void i_enter_the_password_as(String string) {
	driver.findElement(By.id("pass1")).sendKeys(string);
	    
	}
	@When("I enter the Confirm Password {string}")
	public void i_enter_the_confirm_password(String string) {
	driver.findElement(By.id("pass2")).sendKeys(string);
	   
	}
	@When("I clicked the Register button")
	public void i_clicked_the_register_button() {
	driver.findElement(By.id("registration_submit")).click();
	  
	}
	@When("I should see the username as {string}")
	public void i_should_see_the_username_as(String string) {
		String expectedResult = "Dear Premkumar Shanmugam,";
		String actualResult = "";
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		actualResult = driver.findElement(By.xpath("//*[@id=\"cm-content\"]/div/div[2]")).getText();
		if (actualResult.contains(expectedResult)){
				 System.out.println("Registered succesfully!");
				 System.out.println(actualResult);
				 System.out.println("-----------------------------------------------------------");
				 } 
		else {
				 System.out.println("Not Registered");
				System.out.println(actualResult); 
				System.out.println("-----------------------------------------------------------");
		}
		
	  
	}

	@When("click on the profile icon with the registered id")
	public void click_on_the_profile_icon_with_the_registered_id() {
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[2]/a")).click();		  
	    
	}

	@When("user should click on the image on the profile option and compare the id")
	public void user_should_click_on_the_image_on_the_profile_option_and_compare_the_id() {
		
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[2]/ul/li[1]/div/a/p")).click(); 
		  String expectedEmail = "shan17@gmail.com"; 
		  String actualEmail = "";
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  actualEmail=driver.findElement(By.xpath("//*[@id=\"sn-avatar-one\"]/div/ul/li[2]/a/div")).getText(); 
		  if (actualEmail.contentEquals(expectedEmail)){
		  System.out.println("Test Passed!"); 
		  System.out.println(actualEmail); 
		  System.out.println("-----------------------------------------------------------");
		  } else {
		  System.out.println("Test Failed"); 
		  System.out.println(actualEmail); 
		  System.out.println("-----------------------------------------------------------");
		  }
	}
	@When("Navigate to homepage and click on compose email option")
	public void navigate_to_homepage_and_click_on_compose_email_option() {
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[1]/li[1]/a")).click();
		  driver.findElement(By.linkText("Compose")).click();
	}
	@When("write a message to another user")
	public void write_a_message_to_another_user() throws InterruptedException {
		 WebElement obj =driver.findElement(By.xpath("//*[@id=\"compose_message\"]/fieldset/div[1]/div[1]/span/span[1]/span/ul/li/input ")); 
		 obj.sendKeys("admin"); 
		  Thread.sleep(3000);
		  obj.sendKeys(Keys.ENTER);
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"compose_message_title\"] ")).sendKeys("Test1"); 
		  Thread.sleep(3000); 
		  driver.switchTo().frame(0);
		  driver.findElement(By.xpath("/html/body")).sendKeys("Testing");
		  driver.switchTo().defaultContent();
		  driver.findElement(By.xpath("//*[@id=\"compose_message_compose\"]")).click();
	  
	}
	@Then("Verify whether the message has sent to another user")
	public void verify_whether_the_message_has_sent_to_another_user() {
		
		String expectedResult1 = "The message has been sent to";
		  String actualResult1 = ""; 
		  actualResult1 =driver.findElement(By.xpath("//*[@id=\"cm-content\"]/div/div[2]/div/div[1]")).getText(); 
		  if (actualResult1.contains(expectedResult1))
		  {
		  System.out.println("Mail sent sucesfully!"); 
		  System.out.println(actualResult1);
		  System.out.println("-----------------------------------------------------------");
		  } else {
		  System.out.println("Mail not sent"); 
		  System.out.println(actualResult1);
		  System.out.println("-----------------------------------------------------------");
		  }
		 
		  driver.close();
	  
	}


}
