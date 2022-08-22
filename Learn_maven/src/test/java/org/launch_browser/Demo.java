package org.launch_browser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	public static void main(String[] args) {
		
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.flipkart.com/");
	WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
	search.sendKeys("iphone"+Keys.ENTER);
	WebElement ip = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]"));
	ip.click();
	
	Set<String> window = driver.getWindowHandles();
	System.out.println(window);
   
	List<String> wh=new ArrayList<>(window);
	driver.switchTo().window(wh.get(1));
	
	WebElement pincode = driver.findElement(By.xpath("//input[@placeholder='Enter Delivery Pincode']"));
	pincode.sendKeys("600001");
	WebElement addtocart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
	addtocart.click();
	WebElement buy = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']"));
	buy.click();
	
	

}
}