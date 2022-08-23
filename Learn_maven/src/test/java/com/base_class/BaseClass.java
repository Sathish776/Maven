package com.base_class;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
		
	static WebDriver driver;
	
	public static void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	}
	public  static void LaunchUrl(String url) {
		driver.get(url);
	}
	public static void GetText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}
	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	public static void GetCurrentUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	public static void Screnshot(String name) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File Dest=new File("C:\\Users\\Sathish\\git\\Maven\\Learn_maven\\Screenshot\\" +name+".png");
		FileUtils.copyFile(source, Dest);
		
	}
	public static void Back() {
		driver.navigate().back();
	}
	
	public static void Forward() {
		driver.navigate().forward();
	}
	public static void Refresh() {
		driver.navigate().refresh();
	}
	public static void Quit() {
		driver.quit();
	}
	public static void Maximize() {
		driver.manage().window().maximize();
	}
	public static void Close() {
		driver.close();
	}
	public static void Title() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	public static void PageSource() {
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);	
	}
	public static void WindowHandles(int ind) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wh=new ArrayList<>();
		driver.switchTo().window(wh.get(ind));
	}
	public static void windowHandlesprint() {
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
	}
	
     public static void Sendkeys(WebElement element,String val) {
    	 element.sendKeys(val);
    	 
     }
     public static void Click(WebElement element) {
    	 element.click();
     }
     public static void isDisplayed(WebElement element) {
    	 boolean displayed = element.isDisplayed();
    	 System.out.println(displayed);
     }
     public static void isEnabled(WebElement element) {
     boolean enabled = element.isEnabled();
     System.out.println(enabled);
     }
     public static void isSelected(WebElement element) {
    	 boolean selected = element.isSelected();
    	 System.out.println(selected);
     }
     
     public static void clear(WebElement element) {
    	 element.clear();
     }
     public static void DropdownByind(WebElement element,int ind) {
    	 Select s=new Select(element);
    	 s.selectByIndex(ind);
     }
     public static void DropdownByvisibletxt(WebElement element,String val) {
    	 Select s=new Select(element);
    	 s.selectByVisibleText(val);
     }
     public static void DropdownByvalue(WebElement element,String val) {
    	 Select s=new Select(element);
    	 s.selectByValue(val);
     }
     public static void GetOptions(WebElement element) {
    	 Select s=new Select(element);
    	 List<WebElement> options = s.getOptions();
    	 for (WebElement alloption : options) {
    		 String text = alloption.getText();
    		 System.out.println(text);
		}
     }
     public static void GetAllSelectedOPtions(WebElement element) {
    	 Select s =new Select(element);
    	 List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
    	 for (WebElement alloption : allSelectedOptions) {
    		 String text = alloption.getText();
    		 System.out.println(text);	
		}
     }
     public static void jsclick(WebElement element) {
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
    	 js.executeScript("arguments[0].click()",element);
     }
     public static void ScrollByElement(WebElement element) {
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
    	 js.executeScript("arguments[0].scrollIntoView()", element);
     }
     public static void ScrollUp(WebElement element) {
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
    	 js.executeScript("window.scrollBy(0,1000)");
     }
     public static void Wait() {
    	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
     }

    public static void DragandDrop(WebElement scr,WebElement dest) {
    	Actions action=new Actions(driver);
    	action.dragAndDrop(scr, dest).perform();
    }
    
    public static void MoveToElement(WebElement elemnt) {
    	Actions action=new Actions(driver);
    	action.moveToElement(elemnt).perform();
    }
	
	
	
	
	
	
	

}
