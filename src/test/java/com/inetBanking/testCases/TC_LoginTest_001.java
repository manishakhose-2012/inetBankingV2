package com.inetBanking.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	public static Thread thread;

	
	@Test
	public void loginTest() {
		
		driver.get(baseURL);
		thread = new Thread();
		try {
			thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("in the Login Test - Try catch");
			e.printStackTrace();
		}
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(userName);
		logger.info("Username entered");
		
		loginPage.setPassword(password);
		logger.info("Password entered");
		
		loginPage.btnClick();
		
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager Homepage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}else {
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
		
	}
	

}
