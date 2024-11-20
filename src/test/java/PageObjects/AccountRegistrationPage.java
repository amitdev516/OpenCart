package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
public class AccountRegistrationPage extends BasePage 
{
	//constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelphone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPass;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtCnfPass;
	@FindBy(xpath="//input[@name='agree']") WebElement chkPolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	
	@FindBy(xpath="//p[normalize-space()='Congratulations! Your new account has been successfully created!']") WebElement successMsg;
	
	//action methods
	
	public void setFirstName(String firstName)
	{
		txtFirstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName)
	{
		txtLastName.sendKeys(lastName);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel)
	{
		txtTelphone.sendKeys(tel);
	}
	
	public void setPass(String pass)
	{
		txtPass.sendKeys(pass);
	}
	
	public void setCnfPass(String cnfPass)
	{
		txtCnfPass.sendKeys(cnfPass);
	}
	
	public void clickChkPolicy()
	{
		chkPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try {
			return successMsg.getText();
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
}
