package automation;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonAutomate {
	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ishank.dua\\ChromeDriver\\chromedriver.exe" );
		

	    // Create a new instance of the ChromeDriver
	 
	WebDriver driver = new ChromeDriver();
	String url = "https://www.amazon.in/";
	
    driver.get(url);
    driver.manage().window().maximize();
    
    
    WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
    searchBar.sendKeys("Apple 2022 MacBook Air Laptop with M2 chip: 34.46 cm (13.6-inch) Liquid Retina Display, 8GB RAM, 256GB SSD Storage, Backlit Keyboard, 1080p FaceTime HD Camera. Works with iPhone/iPad; Starlight​​​​​​​");
    searchBar.submit();

    // Wait for the search results page to load and select the desired product
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
   
    WebElement productLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".s-result-item .a-text-normal")));
    productLink.click();
 
    ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
  
    //switch to new tab
    driver.switchTo().window(newTb.get(1));
    System.out.println("Page title of new tab: " + driver.getTitle());
    
    WebElement buynow = driver.findElement(By.id("buy-now-button"));
    buynow.click();
    
    WebElement loginemail = driver.findElement(By.id("ap_email"));
    String email = "Enter Your Email Here";
   if(email == "") {
	   System.out.println("Email is empty. Kindly give the value in email variable");
   }else {
	   
	   loginemail.sendKeys(email);
	   WebElement continuenext = driver.findElement(By.id("continue"));
	   continuenext.click();
	   
	   WebElement passfield = driver.findElement(By.id("ap_password"));
	   passfield.sendKeys("Enter Your Password Here ");
	   
	   WebElement signin = driver.findElement(By.id("signInSubmit"));
	   signin.click();
	   
	   WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
	  
	   
	   
	   
//	   driver.quit();
   }
   
}
	}
