package PageObjects;



import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestngPackage.webConnector;

public class SigninPage extends webConnector {
	
	 WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath ="//a[@id='nav-link-accountList']")
	WebElement signin_link;
	
	@FindBy(id="ap_email")
	WebElement email_inpt;
	
	
	@FindBy(id="continue")
	WebElement next_btn;
	
	@FindBy(id="ap_password")
	WebElement password_inpt;
	
	@FindBy(id="signInSubmit")
	WebElement login_link;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement login_btn;
	
	@FindBy(xpath="//span[@class='a-list-item']")
	WebElement incorrectpass;
	
	
	public static final Logger log = Logger.getLogger(SigninPage.class.getName());
	
	List<String> data;
	
	public void signIn_page() {
		signin_link.click();
		}
	
	public boolean verifySignoutLink() {
		return login_link.isDisplayed();
	}
	
	public void authenticate() throws InterruptedException, IOException {
		HashMap<String,String> map = readfromExcel(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx");
		email_inpt.sendKeys(map.get("UserName"));
		next_btn.click();
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(password_inpt));
		password_inpt.sendKeys(map.get("Password"));
		login_btn.click();
		}
	
		
	public SigninPage() throws InterruptedException {
	driver = webConnector.driver;
	PageFactory.initElements(driver, this);	
	}
	

}

