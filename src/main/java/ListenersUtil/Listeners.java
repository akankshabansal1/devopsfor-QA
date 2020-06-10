package ListenersUtil;



import java.io.IOException;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import TestngPackage.webConnector;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ExtentReport.ExtentManager;

public class Listeners extends webConnector implements ITestListener, IInvokedMethodListener {
	
	
    public void onTestFailure(ITestResult result) {
        log.info("Test Case Failed: " + result.getName());
        try {
        	webConnector.takeScreenshot(webConnector.driver);
        	System.out.println("inside logger");
			logger.log(Status.FAIL, "Testcase failed is : " + result.getName() , MediaEntityBuilder.createScreenCaptureFromPath(webConnector.targetLocation).build());
		} catch (IOException e) {
			log.info("An exception occured while taking screenshot " + e.getCause());
		}
        
    }

    // When Test case get Skipped, this method is called.
    public void onTestSkipped(ITestResult result) {
        log.info("Test Case Skiped: " + result.getName());
        try {
			logger.log(Status.SKIP, "The name of the testcase Skipped is : " + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(webConnector.targetLocation).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

 

    // When Test case get Started, this method is called.
    public void onTestStart(ITestResult result) {
        log.info("Test Case Started: " + result.getName());
        logger = report.createTest(result.getName());
        logger.log(Status.INFO, result.getName() + " test case started");
    }

 

    // When Test case get passed, this method is called.
    public void onTestSuccess(ITestResult result) {
        log.info("Test Case Passed: " + result.getName());
        logger.log(Status.PASS, "The name of the testcase passed is : " + result.getName());
    }

 

    public void onFinish(ITestContext arg0) {
        driver.quit();
        report.flush();
    }

 

    public void onStart(ITestContext arg0) {
    	report = ExtentManager.createInstance();
        try {
			initialize();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

 

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

 

    }

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}
}
 

    

 

    
	

