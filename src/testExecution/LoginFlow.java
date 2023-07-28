package testExecution;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;



public class LoginFlow 
{
	WebDriver driver=null;
		
		@Test(priority = 1)
		public void launchBrowser()
		{
		//launch browser
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Support\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		
		//enter URL
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}
		
		@Test(priority = 2)
		public void login()
		{
		//enter username
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
				
		//enter password
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
				
		//click on Login
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		}
		
		@Test(priority = 3)
		public void mouseOver()
		{
		//mouse over to PIM
		Actions act=new Actions(driver);
		WebElement a= driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
			act.moveToElement(a).build().perform();
			a.click();
		}
		
		@Test(priority = 4)
		public void addEmp()
		{
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//add employees
			Xls_Reader reader=new Xls_Reader("D:\\Automation Support\\Workspace\\Assignment\\TestNG\\src\\com\\test\\data\\TestData.xlsx");
			
			String firstName1= reader.getCellData("Employees", "FirstName", 2);
			String lastname1= reader.getCellData("Employees", "LastName", 2);
			
			String firstName2= reader.getCellData("Employees", "FirstName", 3);
			String lastname2= reader.getCellData("Employees", "LastName", 3);
			
			String firstName3= reader.getCellData("Employees", "FirstName", 4);
			String lastname3= reader.getCellData("Employees", "LastName", 4);
			
			driver.findElement(By.xpath("(//*[@class='oxd-topbar-body-nav-tab-item'])[3]")).click();
			driver.findElement(By.xpath("//*[@name='firstName']")).sendKeys(firstName1);
			driver.findElement(By.xpath("//*[@name='lastName']")).sendKeys(lastname1);	
			WebDriverWait time1=new WebDriverWait(driver, 10);
			time1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='submit']")));
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			
			driver.findElement(By.xpath("(//*[@class='oxd-topbar-body-nav-tab-item'])[3]")).click();
			driver.findElement(By.xpath("//*[@name='firstName']")).sendKeys(firstName2);
			driver.findElement(By.xpath("//*[@name='lastName']")).sendKeys(lastname2);
			WebDriverWait time2=new WebDriverWait(driver, 10);
			time2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='submit']")));
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			
			driver.findElement(By.xpath("(//*[@class='oxd-topbar-body-nav-tab-item'])[3]")).click();
			driver.findElement(By.xpath("//*[@name='firstName']")).sendKeys(firstName3);
			driver.findElement(By.xpath("//*[@name='lastName']")).sendKeys(lastname3);
			WebDriverWait time3=new WebDriverWait(driver, 10);
			time3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='submit']")));
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			
			//employee list
			driver.findElement(By.xpath("(//*[@class='oxd-topbar-body-nav-tab-item'])[2]")).click();
		}
		
			@Test(priority = 5)
			public void verify()
			{	
			//scroll and verify	and print		
			WebElement till= driver.findElement(By.xpath("//*[@type='submit']"));		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",till);
			}
			@Test(priority = 6,dependsOnMethods = "verify")
			public void print()
			{
				Xls_Reader reader=new Xls_Reader("D:\\Automation Support\\Workspace\\Assignment\\TestNG\\src\\com\\test\\data\\TestData.xlsx");
				
				String firstName1= reader.getCellData("Employees", "FirstName", 2);
				String lastname1= reader.getCellData("Employees", "LastName", 2);
				
				String firstName2= reader.getCellData("Employees", "FirstName", 3);
				String lastname2= reader.getCellData("Employees", "LastName", 3);
				
				String firstName3= reader.getCellData("Employees", "FirstName", 4);
				String lastname3= reader.getCellData("Employees", "LastName", 4);
				
				
				System.out.println(firstName1+" "+lastname1);
				System.out.println(firstName2+" "+lastname2);
				System.out.println(firstName3+" "+lastname3);
			}
			@Test(priority = 7)
			public void logout() throws InterruptedException
			{
				Thread.sleep(2000);
			//logout from dashboard
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
			}
		

	
	
	
}

	
	
	
	

