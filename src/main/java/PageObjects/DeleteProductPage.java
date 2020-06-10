package PageObjects;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestngPackage.webConnector;

public class DeleteProductPage {
	
	WebDriver driver;

	@FindBy(xpath="//span[@id='nav-cart-count']")
	WebElement cart;
	
	@FindBy(id="activeCartViewForm")
	WebElement shoppincartItems;

	public static Logger log = Logger.getLogger(DeleteProductPage.class.getName());
	
public void clickCartIcon() {
	cart.click();

}

public void selectItemToBeDeleted() {
	List<WebElement> items = shoppincartItems.findElements(By.xpath("//input[@value='Delete']"));
	log.info("Iterating through cart items");
	log.info("Selecting first item to get deleted");
	for(int i=0; i<items.size();) {
		items.get(0).click();
		break;
	}
 	
}

public DeleteProductPage() throws InterruptedException {
	driver = webConnector.driver;
	PageFactory.initElements(driver, this);	
}

}
