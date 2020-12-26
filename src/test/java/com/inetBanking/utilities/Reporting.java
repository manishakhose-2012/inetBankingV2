package com.inetBanking.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;





public class Reporting implements ITestListener {
	
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

 
    @Override
    public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report - " + timeStamp + ".html";		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output" + repName);
		htmlReporter.loadConfig(System.getProperty("user.dir") + "/extent-config.xml");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "manisha");
	
		htmlReporter.config().setDocumentTitle("InetBanking Test Project");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
    }
 
    @Override
    public void onFinish(ITestContext iTestContext) {
    	extent.flush();
    }
 
    @Override
    public void onTestStart(ITestResult iTestResult) {
    	//logger=extent.createTest(iTestResult.getName());
    	//logger.log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.GREEN));
        //System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
    }
 
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    	logger=extent.createTest(iTestResult.getName());
    	logger.log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.GREEN));
    
    }
 
    @Override
    public void onTestFailure(ITestResult iTestResult) {
    	
    	logger=extent.createTest(iTestResult.getName());
    	logger.log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.RED));
    
        //System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
 
        //Take base64Screenshot screenshot.
        String screnshotPath = System.getProperty("user=dir")+ "/Screenshots/" + iTestResult.getName() + ".png";
        File f = new File(screnshotPath);
        
        if(f.exists()) {
        	try {
        			logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(screnshotPath));
        	}catch(IOException e) {
        		e.printStackTrace();
        	}
        }
        
    }
 
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    	logger=extent.createTest(iTestResult.getName());
    	logger.log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.ORANGE));
    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


