package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	
	public ReadConfig() {
		File src =new File("./config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
			
		} catch (Exception e) {
			System.out.println("Excepetion is " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	public String getApplicationURL() {
		String URL = prop.getProperty("baseURL");
		return URL;
		
	}
	
	public String getUserName() {
		String userName = prop.getProperty("username");
		return userName;
		
	}
	
	public String getpassword() {
		String password = prop.getProperty("password");
		return password;
		
	}
	
	public String getChromeDriver() {
		String chromeDriver = prop.getProperty("chromedriver");
		return chromeDriver;
		
	}

}
