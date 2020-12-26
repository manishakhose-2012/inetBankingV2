package com.inetBanking.testCases;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	/*
	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL = readConfig.getApplicationURL();
	public String userName = readConfig.getUserName();
	public String password = readConfig.getpassword();
	*/
	
	/*CODE BEFORE WRITING CONFIG AND READCONFIG.JAVA*/
	public String baseURL = "http://www.demo.guru99.com/v4/index.php";
	public String userName = "mngr300647";
	public String password = "mypAdEr";
	
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeClass
	public void setup() {

		//System.setProperty("webdriver.chrome.driver", readConfig.getChromeDriver());
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		driver = new ChromeDriver();	
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
