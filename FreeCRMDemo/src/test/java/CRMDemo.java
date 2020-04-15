import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRMDemo {


	
	WebDriver driver;
	
	
	
	  @BeforeMethod
	  public void setup() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("batchautomation");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@12345");
}
	
	
	  
	  @Test
	  public void GoogleTitleTest(){


			 List<WebElement> allLinks=driver.findElements(By.tagName("a"));
			 allLinks.addAll(driver.findElements(By.tagName("img")));
			 
			
			 System.out.println("Size of the active links and images----->" +allLinks.size());
			 
			 List<WebElement> activelinks=new ArrayList<WebElement>();
			 
			 
			 for(int i=0;i<allLinks.size();i++) {
				 if(allLinks.get(i).getAttribute("href")!=null) {
					 activelinks.add(allLinks.get(i));
				 }
			 }
			 
			 System.out.println("Size of the active links and images----->" +activelinks.size());
		 
		}


@AfterMethod
public void TearDown(){
	driver.quit();
 }
}
