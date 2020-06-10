package TestngPackage;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import PageObjects.SigninPage;

//@Listeners(ListenersUtil.Listeners.class)


public class SigninTest extends webConnector{
	
	public SigninPage signin ; 
	public static final Logger log = Logger.getLogger(SigninTest.class.getName());
	
	  @BeforeMethod 
	  public void setUp() throws InterruptedException{ 
		signin = new SigninPage();
	  }
	 
		
	@Test(priority=1)
	public void signinTest() throws Throwable  {
		signin.signIn_page();
		log.info("Entering user name, password");
		signin.authenticate();
		log.info("Validate login");
		boolean flag = signin.verifySignoutLink(); 
		//Assert.assertTrue(flag);
		Assert.assertFalse(!flag);  //just wanted to use asertFalse
	}	
}  	
