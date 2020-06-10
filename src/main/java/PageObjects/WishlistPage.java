package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestngPackage.webConnector;

public class WishlistPage extends webConnector {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//a[@id='nav-link-accountList']")
	WebElement hellouser_link;
	
	@FindBy(xpath ="//span[contains(text(),'Create a Wish List')]")
	WebElement createWishlist_link;
	
	@FindBy(xpath="//input[@id='WLNEW_list_name']")
	WebElement wishlistName_inpt;
	
	@FindBy(xpath="//span[@id='WLNEW_create']//input[@class='a-button-input a-declarative']")
	WebElement createList_btn;

public void mouseHover() {
	Actions act = new Actions(driver);
	act.moveToElement(hellouser_link).build().perform();

}

public void clickonWishlistLink() {
		createWishlist_link.click();		
}

public void inputWishlistName() {
	wishlistName_inpt.sendKeys("Aka's wishlist");

}

public void submitName() {
	createList_btn.click();
}


public WishlistPage() throws InterruptedException {
	driver = webConnector.driver;
	PageFactory.initElements(driver,this);
			
	}
}