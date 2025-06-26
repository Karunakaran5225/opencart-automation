package com.opencart.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.opencart.actiondriver.Action;



public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeTest
	public void loadConfig() {
	    try {
	        prop = new Properties();
	        System.out.println("super constructor invoked");
	        FileInputStream ip = new FileInputStream(
	            System.getProperty("user.dir") + "\\Configuration\\config.properties"
	        );
	        prop.load(ip);
	        System.out.println("driver: " + driver);
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void launchApp() {
	    WebDriverManager.chromedriver().setup();
	    String browserName = prop.getProperty("browser");

	    if (browserName.contains("Chrome")) {
	        driver = new ChromeDriver();
	    } else if (browserName.contains("FireFox")) {
	        driver = new FirefoxDriver();
	    } else if (browserName.equalsIgnoreCase("edge")) {
	        WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
	    }

	    else {
	        throw new RuntimeException("Unsupported browser: " + browserName);
	    }
	    Action.implicitWait(driver, 10);
	    Action.pageLoadTimeout(driver, 30);
	    driver.get(prop.getProperty("url"));

	}



}
