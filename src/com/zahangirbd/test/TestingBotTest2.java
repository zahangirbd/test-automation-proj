package com.zahangirbd.test;

import java.net.URL;

import org.openqa.selenium.By;  
import org.openqa.selenium.Platform;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.remote.DesiredCapabilities;  
import org.openqa.selenium.remote.RemoteWebDriver;  
import org.testng.Assert;  
import org.testng.annotations.AfterClass;  
import org.testng.annotations.BeforeClass;  
import org.testng.annotations.Test;  
  
public class TestingBotTest2 {  
    private WebDriver driver;  
  
    @BeforeClass  
    public void setUp() throws Exception {      	
        DesiredCapabilities capabillities = DesiredCapabilities.firefox();  
        capabillities.setCapability("version", "12");  
        capabillities.setCapability("platform", Platform.WINDOWS);  
        capabillities.setCapability("name", "Testing Selenium 2");  
  
        driver = new RemoteWebDriver(  
                new URL("http://7bd201fdf682a8b0a4dee03852657e98:5b94ebff8295d27db0aa1a9d215949e2@hub.testingbot.com:4444/wd/hub"),capabillities);  
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
