package com.zahangirbd.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;  
import org.testng.annotations.AfterClass;  
import org.testng.annotations.BeforeClass;  
import org.testng.annotations.Test;  
  
public class TestingBotTest {  
    private WebDriver driver;  
  
    @BeforeClass  
    public void setUp() throws Exception {  
    	// Create a new instance of the Firefox driver    	 
        driver = new FirefoxDriver();
   
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   
        //Launch the Online Store Website    
    }  
  
    @Test  
    public void testSimple() throws Exception {  
        driver.get("http://testingbot.com/");  
        String searchHeader = driver.findElement(By.cssSelector("H1"))  
                .getText().toLowerCase();  
  
        Assert.assertTrue(searchHeader.contains("Online Selenium Testing"));  
    }  
  
    @AfterClass  
    public void tearDown() throws Exception {  
        driver.quit();  
    }  
    
}  
