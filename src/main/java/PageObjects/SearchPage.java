package PageObjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import TestngPackage.webConnector;

public class SearchPage extends webConnector {
	WebDriver driver;
	WebDriverWait wait ;

	@FindBy(id="twotabsearchtextbox")
	WebElement searchinpt;
	
	@FindBy(id="add-to-cart-button")
	WebElement addtocart_btn;
	
	@FindBy(xpath="//select[@id='searchDropdownBox']")
	WebElement dropdown_menu;
	
	@FindBy(xpath="//i[@class='a-icon a-icon-alert']")
	WebElement confirm_icon;
	
	public static Logger log = Logger.getLogger(SearchPage.class.getName());
	
	public void selectCategory() throws InterruptedException {
		Select category = new Select(dropdown_menu);
        category.selectByValue("search-alias=aps");
		Thread.sleep(1000);
	}
	
	public void SearchProduct() throws InterruptedException, IOException  {
		selectCategory();
		HashMap<String,String> map = readfromExcel(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx");
		searchinpt.sendKeys(map.get("QuerySearch"));
		searchinpt.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
		
	public void selectProduct() throws InterruptedException {
		List<WebElement> links =driver.findElements(By.xpath("//div[@data-component-type='s-search-result']/div/span/div"));
		log.info("selecting first item");
		links.get(0).click();
        switchToNewTab();
        }

		
	  public void addToCart() {
		log.info("waiting for Add to cart button");
	  waitUntilFound("add-to-cart-button", 10);
	  addtocart_btn.click(); 
	  }
	  
	
	 public boolean confirmCartItem() {
      return confirm_icon.isDisplayed(); 
      }
	  
	
	public SearchPage() throws InterruptedException {
		driver = webConnector.driver;
		PageFactory.initElements(driver, this);	
	}	
}
