package TestngPackage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.WishlistPage;

//@Listeners(ListenersUtil.Listeners.class)

public class WishlistTest extends webConnector {
	public WishlistPage wishlistpage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
	wishlistpage = new WishlistPage();
	}
	
	@Test
	public void wishlistTest() throws InterruptedException {
		wishlistpage.mouseHover();
		log.info("clicking on Wishlist link");
		wishlistpage.clickonWishlistLink();
		wishlistpage.inputWishlistName();
		wishlistpage.submitName();
	}
}
