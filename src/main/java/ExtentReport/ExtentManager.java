package ExtentReport;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {
	
	private static ExtentReports extent;
     
    public ExtentReporter htmlReporter;
    public static String outputFolderPath;   
    public static DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
    public static Date date = new Date();
    public static String folderDatetime=dateFormat.format(date);
	
    public static ExtentReports createInstance() {
        if (extent == null) {
        	File newFolder = new File(System.getProperty("user.dir") + "\\CurrentTestResult");
        	newFolder.mkdir();
            outputFolderPath = newFolder.getPath();
          // String path = System.getProperty("user.dir") + "\\target\\ExtentReport\\ExtentReport.html";
           File path = new File(outputFolderPath + "\\" + "ExtentReport" + ".html");
           // String extentConfig = "C:\\Users\\akankshabansal\\eclipse-workspace\\codeamazon\\src\\main\\resources\\extent-config.xml";
          //  String extentConfig = System.getProperty("user.dir") + "\\src\\main\\resources\\extent-config.xml";
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
			/*
			 * extent = new ExtentReports(); extent.setSystemInfo("OS", "Windows");
			 * extent.setSystemInfo("Host Name", "Akanksha");
			 * extent.setSystemInfo("Environment", "Demo"); extent.setSystemInfo("UserName",
			 * "Akanksha");
			 */
            extent = new ExtentReports();
            reporter.config().setTestViewChartLocation(ChartLocation.TOP);
    		reporter.config().setChartVisibilityOnOpen(true);
    		reporter.config().setTheme(Theme.STANDARD);
    		reporter.config().setDocumentTitle("ExtentReport" + ".html");
    		reporter.config().setEncoding("utf-8");
    		reporter.config().setReportName("ExtentReport" + ".html");
           // reporter.loadConfig(extentConfig);
            extent.attachReporter(reporter);
        }
        return extent;
    }
    
    }