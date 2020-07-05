package com.crm.base;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.util.WebListener;

public class TestBase {
public static WebDriver driver;
public static Properties prop;
public static EventFiringWebDriver e_driver;
public static WebListener weblistener;

public TestBase() throws IOException {
	 prop=new Properties();
	FileInputStream fis=new FileInputStream("src/main/java/com/crm/config/config.properties");
	prop.load(fis);
}

public static void initialization (String browser) {
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driverExecutable/chromedriverl.exe");
	    driver = new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.gecko.driver", "/src/test/resources/driverExecutable/geckodriver.exe");
	    driver = new FirefoxDriver();
		
	}
    e_driver =new EventFiringWebDriver(driver);
    weblistener = new WebListener();
    e_driver.register(weblistener);
    driver=e_driver;
    

	driver.get(prop.getProperty("URL"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
}


}
