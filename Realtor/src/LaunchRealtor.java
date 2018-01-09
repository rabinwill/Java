// To watch video of script execution, please visit: https://youtu.be/E1yG-KayJ8g
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.Keys;

public class LaunchRealtor {
	public static void main (String[] args)
	{
	//Chrome Driver Location. Using Google Chrome Browser for this test. 
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rabin.David\\AppData\\Local\\Programs\\Python\\Python35\\driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	//1. Navigating to realtor.com
    driver.get("https://www.realtor.com/");
    try {
    	//sleeping for 4 seconds for the page to finish loading 
    	Thread.sleep(4000);  }
    
    catch(InterruptedException ex) {
    	Thread.currentThread().interrupt();		 }
    
    //Finding search box by id name to enter city, state
    WebElement search = driver.findElement(By.id("searchBox"));
    //2 & 3. Entering "Morgantown, WV" followed by \n which triggers Enter
    search.sendKeys("Morgantown, WV\n");
    
    try {
    	//sleeping for 7 seconds for the page to finish loading in search results. 
    	Thread.sleep(7000);  }
    
    catch(InterruptedException ex) {
    	Thread.currentThread().interrupt();		}
    
    //Finding Span by XPath which has the search result count for the number of listings. 
    String fulltext = driver.findElement(By.xpath("//div[@id=\"srp-sort-count-wrap\"]/span")).getText();
    
    //Splitting the text by space to separate and get number "n"
    String[] parts = fulltext.split(" ");
    //Converting String to Int to compare n>0
    int n = Integer.parseInt(parts[0]);
    //Printing the number of listings available.
    System.out.println(n+" Listings Available");
    //4. Checking to see number N is greater than 0
    if (n>0) {
    	//If N is greater than 0 then PASS
    	System.out.println("PASS: Listings are greater than 0");
    } else {
    	//Else N less than or equal to 0 then FAIL
    	System.out.println("FAIL: Listings are NOT greater than 0");
    }
    //Quitting Chrome Driver
    driver.quit();
	}
}
