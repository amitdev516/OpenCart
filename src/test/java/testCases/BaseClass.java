package testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		logger = LogManager.getLogger(this.getClass());
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	
	public String randomString()
	{
		return "";//RandomStringUtils.randomAlphabetic(5);
	}
	
	public String randomNumeric()
	{
		return "";//RandomStringUtils.randomNumeric(10);
	}
	
	public String randomAlphaNumeric()
	{
		String alpha = "";//RandomStringUtils.randomAlphabetic(5);
		String numeric = "";//RandomStringUtils.randomNumeric(5);
		return (alpha+"@"+numeric);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
