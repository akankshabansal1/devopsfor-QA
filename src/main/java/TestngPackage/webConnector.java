package TestngPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import ExtentReport.ExtentTestManager;


public class webConnector {
	
	public static ExtentTest logger;
	public static ExtentReports report;
	public static WebDriver driver=null;
	public static String outputFolderPath;
	public static Properties prop;
	public static String xpath;
	public static int time;
	public static String targetLocation = null;
	public static XSSFWorkbook workbook ;
	public static FileInputStream fis;
	public static XSSFSheet sheet1 ;
	public static XSSFSheet sheet2;
	
	/*
	 * public static XSSFWorkbook workbook; public static XSSFSheet worksheet;
	 */
	public static String testdata_file = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx";
	
	public static Logger log = Logger.getLogger(webConnector.class.getName());
	
	
	public static HashMap<String,String> readfromExcel(String location) throws IOException {
		
		try {
		 fis = new FileInputStream(location);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		workbook = new XSSFWorkbook(fis);
		 sheet1 =  workbook.getSheet("Sheet1");
		 sheet2 =  workbook.getSheet("Sheet2");
		
		//LinkedList<HashMap<String, String>> lstMap = new LinkedList<HashMap<String,String>>();
		
		
		HashMap<String,String> map = new HashMap<String, String>();
		
		Row headerRow = sheet1.getRow(0);
		
		String keyUserName = headerRow.getCell(0).getStringCellValue();
		String valueUserName = sheet1.getRow(1).getCell(0).getStringCellValue();
		
		map.put(keyUserName, valueUserName);
		
		String keyPassword = headerRow.getCell(1).getStringCellValue();
		String valuePassword = sheet1.getRow(1).getCell(1).getStringCellValue();
		
		map.put(keyPassword, valuePassword);
		
		String keySearch =sheet2.getRow(0).getCell(0).getStringCellValue();
		String valueSearch = sheet2.getRow(1).getCell(0).getStringCellValue();
		map.put(keySearch, valueSearch);
		
		System.out.println("MAP FOR EXCEL: "+ map);
		
		workbook.close();
		return map;
	}
    
	 
	public  webConnector() {
		
			try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\resources\\Configuration.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		public void initialize() throws InterruptedException {		
			String log4jConfPath =".\\src\\main\\resources\\log4j.properties" ;
	        PropertyConfigurator.configure(log4jConfPath);
			if (prop.getProperty("browser") == null) {
				System.out.println("Browser is NOT specified in Configuration file. Terminating process");
				System.exit(0);
			}
			if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				log.info("initializing chrome");
				driver = new ChromeDriver();
			}
			if (prop.getProperty("browser").equalsIgnoreCase("Firefox")) {				
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
				System.setProperty("webdriver.firefox.bin", prop.getProperty("firefox_path"));
				FirefoxOptions options = new FirefoxOptions();
				options.setCapability("marionette", true);
				log.info("initializing Firefox");
				driver = new FirefoxDriver(options);
			}
	
		PageFactory.initElements(driver, this);
		driver.get(prop.getProperty("url"));		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
}
		
	public static void waitUntilFound(String xpath, int time) {
		WebDriverWait waitFor = new WebDriverWait(driver,time);
		try {
			if(xpath != null) {
				waitFor.until(ExpectedConditions.visibilityOfElementLocated(By.id(xpath)));
		} else {
			log.info("Product is not availbale right now. Please try after some time");
		}
		} catch(Exception e) {
			log.info("exception caught");
			
	}
	}	
	
	
	public void wait(int time){
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitForPageToLoad(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i=0;
		
		while(i!=10){
		String state = (String)js.executeScript("return document.readyState;");
		System.out.println(state);

		if(state.equals("complete"))
			break;
		else
			wait(2);

		i++;
		}
		wait(2);// wait of 2 sec between page status and jquery
		// check for jquery status
		i=0;
		while(i!=10){
	
			Boolean result= (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active == 0;");
			System.out.println(result);
			if(result )
			 	break;
			else
				 wait(3);
			 i++;
				
			}
		
		}
	
	public void switchToNewTab() {
		Set<String> windows = driver.getWindowHandles();
		System.out.println("Total no of windows is-----" + windows.size());
		Iterator<String> it = windows.iterator();
		System.out.println(it.next()); //gets the window id
		windows = driver.getWindowHandles();
	System.out.println("Total no of windows is-----" + windows.size());
	it = windows.iterator();
	
	String mainWindow = it.next();
	String firsttab = it.next();
	driver.switchTo().window(firsttab);
	System.out.println(driver.getTitle());
	}
	
	
	public static void takeScreenshot(WebDriver driver) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
	    Date date = new Date();
	    String folderDatetime = dateFormat.format(date);
		targetLocation = System.getProperty("user.dir") + "\\FailedTCScreenshots\\FailedTCScreenShot" + folderDatetime + ".jpg";
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //import common IO.jar file
		File targetFile= new File(targetLocation);
		log.info("Screen shot file location - " + srcFile.getAbsolutePath());
		log.info("Target File location - " + targetFile.getAbsolutePath());
		
		try {
			
			FileUtils.copyFile(srcFile, targetFile);
		} catch(FileNotFoundException e) {
			log.info("File not found" + e.getMessage());
		}
	 catch (Exception e) {
		log.info("An exception occurred while taking screenshot " + e.getCause());
	
	}
	}
	
	
}
