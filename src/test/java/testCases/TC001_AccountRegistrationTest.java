package testCases;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(dataProvider = "dpEmailMobile")
	public void verify_Account_Registration(String email, String mob)
	{
		try {
		logger.info("Starting Method - verify_Account_Registration");
		HomePage homepage = new HomePage(driver);
		homepage.clickMyAccount();
		homepage.clickRegister();
		
		AccountRegistrationPage accreg = new AccountRegistrationPage(driver);
		accreg.setFirstName("Amit");
		accreg.setLastName("Mandal");
		accreg.setEmail(email);
	    accreg.setTelephone(mob);
	    accreg.setPass("1234");
	    accreg.setCnfPass("1234");
	    accreg.clickChkPolicy();
	    accreg.clickContinue();
	    
	    String msg = accreg.getConfirmationMsg();
	    Assert.assertEquals(msg, "Congratulations! Your new account has been successfully created!");
	    
	   
		}
		catch(Exception ex)
		{
			logger.error("Test failed. Error details : "+ ex.getMessage());
			logger.debug("Debug msg..");
			Assert.fail();
		}
		 logger.info("Ending Method - verify_Account_Registration");
	}
	
	@DataProvider(name = "dpEmailMobile")
	public Object[][] getEmailAndMobileNo()
	{
		Object[][] arr = {
				{"boomboom@gmail.com","0011001100"},
				{"gandey@gmail.com","0011001199"},
				
		};
		//{"gandey@gmail.com","0011001188"},
		//{"digii@gmail.com","0011001177"}
		return arr;
	}
}
