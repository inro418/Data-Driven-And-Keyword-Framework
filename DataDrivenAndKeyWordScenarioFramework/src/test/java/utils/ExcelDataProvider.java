package utils;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	WebDriver driver;
	private static Logger logger = LogManager.getLogger();
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		
		// Set System property
		System.setProperty("webdriver.chrome.driver","C:\\Users\\koree\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
	}

	@Test(dataProvider = "test1data")
	public void test1(String Firstname, String Lastname, String Emailaddress) throws Exception {  
		System.out.println(Firstname + "  |  " + Lastname+" |" + Emailaddress);         

		driver = new ChromeDriver();
		logger.info("Open window");   
		
		driver.manage().deleteAllCookies();
		logger.info("Deleted cookies");
	
		driver.manage().window().maximize();
		logger.info("Maximixed the window");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		logger.info("Apply time");

		driver.get("http://app.hubspot.com/login"); 
		logger.info("Launch browser");

		Thread.sleep(3000);  
		WebElement Signup = driver.findElement(By.xpath("//*[@id='hs-login']/div[1]/a/i18n-string"));
		Signup.click();
		logger.info("Click Signup");

		driver.findElement(By.id("uid-firstName-5")).sendKeys(Firstname);   
		logger.info("Enter Firstname"); 
		
		driver.findElement(By.id("uid-lastName-6")).sendKeys(Lastname);  
		logger.info("Enter Lastname");     
		
		driver.findElement(By.id("uid-email-7")).sendKeys(Emailaddress);   
		Thread.sleep(3000);  
		logger.info("Enter Emailaddress");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click(); 
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='signup-app']/div/div/div[1]/div[2]/div/div/div/div/p[3]/button/i18n-string")).click();
		
		System.out.println(driver.getTitle()); 
		//Assert.assertEquals("Get started with HubSpot CRM", driver.getTitle());  
		
		driver.quit();
		logger.info("Close the browser");
	}
	
	@DataProvider(name = "test1data")
	public Object[][] getData() throws IOException {
		String excelPath = "C:\\Users\\koree\\Workspace\\DataDrivenAndKeyWordScenarioFramework\\excel2\\datadrivenandkeyword.xls.xlsx";  
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}

	public Object[][] testData(String excelPath, String SheetName) throws IOException {

		ExcelUtils excel = new ExcelUtils(excelPath, SheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object data[][] = new Object[rowCount - 1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {

				String cellData = excel.getCellDataString(i, j);
				System.out.print(cellData + " | ");
				data[i - 1][j] = cellData;
			}

			// System.out.println();
		}
		return data;

	}
}