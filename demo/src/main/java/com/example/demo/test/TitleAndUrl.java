package com.example.demo.test;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class TitleAndUrl {

    public static void main(String[] args) throws InterruptedException {
    	

    	    // Optional. If not specified, WebDriver searches the PATH for chromedriver.
    	
    	 	String path=System.getProperty("user.dir");
    	 	WebDriver driver=null;
    	    try {
    	    	File f=new File(path+"\\chromedriver1.exe");
    	    	System.err.println();
    	    	System.setProperty("webdriver.chrome.driver", f.getPath());
    	    	driver = new ChromeDriver();
    	    	System.out.println("***********11***********");
			} catch (Exception e) {
				try {
	    	    	File f=new File(path+"\\chromedriver2.exe");
	    	    	System.err.println();
//	    	    System.setProperty("webdriver.chrome.driver", "E:\\soft_test\\demo\\chromedriver.exe");
	    	    	System.setProperty("webdriver.chrome.driver", f.getPath());
	    	    	driver = new ChromeDriver();
					System.out.println("***********22***********");
				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
    	    
    	    driver.get("http://localhost:8080/test/index");
    	    
    	    System.out.println("maximize browser");
    	    driver.manage().window().maximize();
            
       	    WebElement searchBox = driver.findElement(By.id("s_state"));
    	    Actions action = new Actions(driver);
    	    action.moveToElement(searchBox).perform();
    	    action.click().perform();
    	    Thread.sleep(1000);
        
            driver.findElement(By.id("Sale")).click();
            Thread.sleep(1000);
            
            driver.findElement(By.id("SalesLineItem")).click();
            Thread.sleep(1000);
            
            driver.findElement(By.id("CashPayment")).click();
            Thread.sleep(1000);
            
            driver.findElement(By.id("CardPayment")).click();
            Thread.sleep(1000);

            driver.findElement(By.id("s_function")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("makeNewSale")).click();
            Thread.sleep(1000);
          
    	    driver.switchTo().frame(driver.findElement(By.id("iframeMain")));
            
    	    driver.findElement(By.id("start_button")).click();
            Thread.sleep(2000);
            
            driver.switchTo().alert().accept(); //点击alert确定
            Thread.sleep(1000);
            
    	    driver.switchTo().defaultContent();

    	    driver.findElement(By.id("enterItem")).click();
            Thread.sleep(1000);
            
            driver.switchTo().frame(driver.findElement(By.id("iframeMain")));
            
   
            driver.findElement(By.id("barcode")).sendKeys("1");
            Thread.sleep(1000);
           
            driver.findElement(By.id("quantity")).sendKeys("10");
            Thread.sleep(1000);
            
            driver.findElement(By.id("submit")).click();
            Thread.sleep(1000);
            
            driver.switchTo().alert().accept(); //点击alert确定
            
            driver.findElement(By.id("barcode")).clear();
            driver.findElement(By.id("barcode")).sendKeys("2");
            Thread.sleep(1000);
            
            driver.findElement(By.id("quantity")).clear();
            driver.findElement(By.id("quantity")).sendKeys("5");
            Thread.sleep(1000);
            
            driver.findElement(By.id("submit")).click();
            Thread.sleep(1000);
            
            driver.switchTo().alert().accept(); //点击alert确定
            
            driver.switchTo().defaultContent();
            
            driver.findElement(By.id("s_state")).click();;
    	    Thread.sleep(1000);
            
          driver.findElement(By.id("Sale")).click();
          Thread.sleep(2000);
          
          driver.findElement(By.id("SalesLineItem")).click();
          Thread.sleep(2000);
          
          driver.findElement(By.id("CashPayment")).click();
          Thread.sleep(2000);
          
          driver.findElement(By.id("CardPayment")).click();
          Thread.sleep(2000);
    	    
          driver.findElement(By.id("s_function")).click();
          Thread.sleep(1000);
          
          driver.findElement(By.id("endSale")).click();
          Thread.sleep(1000);
    	    
          driver.switchTo().frame(driver.findElement(By.id("iframeMain")));
          
          driver.findElement(By.id("end")).click();
          Thread.sleep(1000);
          
          driver.switchTo().alert().accept(); //点击alert确定
          Thread.sleep(1000);
          
          driver.switchTo().defaultContent();
          
          driver.findElement(By.id("makeCashPayment")).click();
          Thread.sleep(1000);
          
          driver.switchTo().frame(driver.findElement(By.id("iframeMain")));
          driver.findElement(By.id("amount")).sendKeys("400");
          Thread.sleep(1000);
          
          driver.findElement(By.id("submit")).click();
          Thread.sleep(1000);
          
          driver.switchTo().alert().accept(); //点击alert确定
          Thread.sleep(1000);
          driver.switchTo().alert().accept(); //点击alert确定
          Thread.sleep(1000);
          
          driver.switchTo().defaultContent();
          
          driver.findElement(By.id("s_state")).click();;
  	   Thread.sleep(1000);
          
        driver.findElement(By.id("Sale")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("SalesLineItem")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("CashPayment")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("CardPayment")).click();
        Thread.sleep(2000);

            
            
            
            
            System.out.printf("title of current page is %s\n", driver.getTitle());
            System.out.printf("url of current page is %s\n", driver.getCurrentUrl());
            
            
            System.out.println("browser will be close");
            driver.quit();    
   }

}