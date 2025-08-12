package com.opencart.base;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.opencart.actiondriver.Action;

public class BaseClass {
	public static Properties prop;
//	public static WebDriver driver;

//	Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	@BeforeSuite(groups= {"Smoke","Sanity","Regression"})
	public void beforeSuite() {
		DOMConfigurator.configure("log4j.xml");
	}

	public static WebDriver getDriver() {
//		Get Driver from threadLocalmap
		return driver.get();
	}

	@BeforeTest(groups= {"Smoke","Sanity","Regression"})
	public void loadConfig() {
		try {
			prop = new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
			System.out.println("driver: " + driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void launchApp(String browserName) {
		WebDriverManager.chromedriver().setup();
//		String browserName = prop.getProperty("browser");

		if (browserName.contains("Chrome")) {
//			driver = new ChromeDriver();
//			Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.contains("FireFox")) {
//			driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			// driver = new EdgeDriver();
			driver.set(new EdgeDriver());
		} else {
			throw new RuntimeException("Unsupported browser: " + browserName);
		}
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeout(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));

	}

}
