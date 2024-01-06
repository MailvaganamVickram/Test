package testproject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumScript {
	    public static void main (String args[]) {
	    	
	    	System.setProperty("webdriver.chrom.driver", "C:\\Selenium Driver\\ChromeDrivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://demoqa.com/browser-windows");
			
			driver.manage().window().maximize();	
			
			driver.findElement(By.xpath("//button[@id='windowButton']")).click();
			
			String parentwindow = driver.getWindowHandle();
			
			System.out.println("Parent window handle " + parentwindow);
			
			for (int i=0;i<3;i++ ) {
				
				driver.findElement(By.xpath("//button[@id='windowButton']")).click();
			}
			
		Set <String> windowhandles = driver.getWindowHandles();
		
		String lastwindow = "";
		
		for(String handle : windowhandles) {
			System.out.println("Window handles " + handle);
				
			driver.switchTo().window(handle);
			
			driver.get("https://www.google.lk/");
			
			driver.manage().window().maximize();
			
			
		}
		
		driver.switchTo().window(parentwindow);
		driver.close();
			
		driver.switchTo().window(lastwindow);
		
	     driver.quit();
		
			
			
	    }

}
