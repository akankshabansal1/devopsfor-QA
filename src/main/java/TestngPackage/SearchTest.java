package TestngPackage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.log4j.Logger;

import PageObjects.SearchPage;


//@Listeners(ListenersUtil.Listeners.class)
public class SearchTest extends webConnector {
	
	public SearchPage searchpage;
	public static final Logger log = Logger.getLogger(SearchTest.class.getName());
	
	@BeforeMethod 
	  public void setUp() throws InterruptedException{ 
		  searchpage =  new SearchPage();
	  }
	
	@Test                                                  
	public void searchTest() throws InterruptedException, IOException { 
	log.info("Selecting Category");
	searchpage.selectCategory();
	searchpage.SearchProduct();
	log.info("select 1st item");
	searchpage.selectProduct();
	searchpage.addToCart();
	log.info("Verifying if item has been added to cart");
	boolean flag = searchpage.confirmCartItem();
	Assert.assertTrue(flag);
	
	}
	
	}


