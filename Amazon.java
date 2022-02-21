package test2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://Amazon.in");
        System.out.println("on Amazon page");
        
          //Maximize window
      		driver.manage().window().maximize();
      	 //wait for browser to load - implicit
    		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    	
    		WebElement Searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
    		Searchbox.sendKeys("Iphone 12");
	
    		WebElement SearchBtn= driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
    		SearchBtn.click();
    		
    		List<WebElement> iphonename = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
    		List<WebElement> iphoneprice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
            System.out.println("search Results " + iphonename.size());
	
            for(int count=0;count<iphonename.size();count++)
	        { 
		    if(iphonename.get(count).getText().toLowerCase().contains("iphone 12"))
		   {
			System.out.println("Iphone Name: " + iphonename.get(count).getText() + "Iphone price : " + iphoneprice.get(count).getText() );
		   }
	       }
	driver.close();
	 }
}
