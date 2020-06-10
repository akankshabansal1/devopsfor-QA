package TestngPackage;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.DeleteProductPage;

public class DeleteProductTest extends webConnector {
	
	public DeleteProductPage deleteproduct;
	public static final Logger log = Logger.getLogger(DeleteProductTest.class.getName());
	
	@BeforeMethod 
	  public void setUp() throws InterruptedException{
		  deleteproduct =  new DeleteProductPage();
	  }
	
	@Test
	public void deleteProduct() throws InterruptedException {
		 
		deleteproduct.clickCartIcon();
		log.info("Deleting item");
		logger.info("Deleting item");
		deleteproduct.selectItemToBeDeleted();
			
	}
	

}
