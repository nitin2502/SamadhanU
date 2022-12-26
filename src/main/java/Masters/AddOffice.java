package Masters;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddOffice
{
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver d;

	@BeforeSuite
	public void setup()

	{  
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	@BeforeTest
	public void Beforetest() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		d=new ChromeDriver();
		String url ="http://demo.samadhanosmanabad.in/home";
		d.get(url);
		d.manage().window().maximize();
		System.out.println("Test  running in Chrome");	
		d.findElement(By.xpath("/html/body/app-root/app-web-layout/div[1]/div/input")).click();
		Thread.sleep(2000);
		
	}

	@Test(priority=1)
	public void login() throws Exception
	{   ExtentTest test = extent.createTest("Test 1", "Login");

	d.findElement(By.xpath("//button[@tabindex='0'][1]")).click();
	Thread.sleep(1000);
	d.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("WeWea61739");
	Thread.sleep(1000);
	d.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Sama@12345");
	Thread.sleep(1000);

	String s=JOptionPane.showInputDialog("Enter Captcha"); 
	d.findElement(By.xpath("//input[@formcontrolname='captcha']")).sendKeys(s);
	Thread .sleep(1000);
	d.findElement(By.xpath("/html/body/app-root/app-web-layout/div/div/app-login/div/div/div/div[2]/form/div[2]/button")).click();
	Thread .sleep(2000);
	System.out.println("User Logged sucessfully ");

	test.pass("Chrome Browser opened");
	test.log(Status.INFO, "Passed Successfully");
	test.info(" User Logged sucessfully");
	// log with snapshot
	test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	// test with snapshot
	test.addScreenCaptureFromPath("screenshot.png");
	} 
	@Test(priority=2)
	public void AddOffice() throws Exception

	{  ExtentTest test = extent.createTest("Test 2", "Office Details");
	
	d.findElement(By.xpath("//*[@id=\"sidebar\"]/div/perfect-scrollbar/div/div[1]/div/ul/li[3]/a/img")).click();
	Thread.sleep(1000);
	d.findElement(By.id("mat-select-2")).click();
	Thread.sleep(1000);
	d.findElement(By.id("mat-option-23")).click();
	Thread.sleep(1000);
	
	d.findElement(By.xpath("//input[@maxlength='200']")).sendKeys("Forest Department Maharashtra");
	Thread.sleep(1000);
	d.findElement(By.id("mat-input-5")).sendKeys("वन विभाग महाराष्ट्र");
	Thread.sleep(1000);
	
	d.findElement(By.id("mat-input-6")).sendKeys("Pune, Maharashtra, India 411044");
	Thread.sleep(1000);
	
	d.findElement(By.id("mat-input-7")).sendKeys("Forest1234@gmail.com");
	Thread.sleep(1000);
	
	d.findElement(By.id("mat-input-8")).sendKeys("Nodal Officer");
	Thread.sleep(1000);

	d.findElement(By.id("mat-input-9")).sendKeys("02532587412");
	Thread.sleep(1000);
	
	
	d.findElement(By.xpath("//button[@type='submit'][1]")).click();
	Thread.sleep(1000);
	
	System.out.println("User Added Department sucessfully ");

	test.pass("Chrome Browser opened");
	test.log(Status.INFO, "Passed Successfully");
	test.info(" User Filled claim Details sucessfully");
	// log with snapshot
	test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

	// test with snapshot
	test.addScreenCaptureFromPath("screenshot.png");

	}
	@Test(priority=3)
	public void Editdepartment() throws Exception

	{  ExtentTest test = extent.createTest("Test 3", "Area Details");
      
	d.findElement(By.xpath("/html/body/app-root/app-partial-layout/div/main/div[1]/div/div[2]/app-department-master/div/div/div[1]/table/tbody/tr[1]/td[3]/div/button/span[1]/span")).click();
	Thread.sleep(1000);
	d.findElement(By.xpath("//input[@maxlength='50']")).clear();
	Thread.sleep(1000);
	d.findElement(By.xpath("//input[@maxlength='50']")).sendKeys("Farming");
	Thread.sleep(1000);
	d.findElement(By.id("mat-input-4")).clear();
	Thread.sleep(1000);
	d.findElement(By.id("mat-input-4")).sendKeys("शेती");
	Thread.sleep(1000);
	d.findElement(By.xpath("//button[@type='submit'][1]")).click();
	Thread.sleep(1000);
	System.out.println("Record updated sucessfully ");
	test.pass("Chrome Browser opened");
	test.log(Status.INFO, "Passed Successfully");
	test.info(" Area details filled ");
	// log with snapshot
	test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

	// test with snapshot
	test.addScreenCaptureFromPath("screenshot.png");

	}
	@Test(priority=4)
	public void Deletedepartment() throws Exception
	{ExtentTest test = extent.createTest("Test 4", "deleting added department ");
		
	d.findElement(By.id("mat-checkbox-12")).click();
	Thread.sleep(1000);
	d.findElement(By.xpath("/html/body/app-root/app-partial-layout/div/main/div[1]/div/div[2]/app-department-master/div/div/div[1]/table/thead/tr/th[3]/button/span[1]/span")).click();
	Thread.sleep(1000);
	d.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-confirmation/div/div/div/div/div[2]/div[2]/div/button[2]/span[1]")).click();
	Thread.sleep(1000);
		
	System.out.println("Department deleted sucessfully ");
	test.pass("Chrome Browser opened");
	test.log(Status.INFO, "Passed Successfully");

	// log with snapshot
	test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

	// test with snapshot
	test.addScreenCaptureFromPath("screenshot.png");

	}
	
	
	
	@AfterSuite
	public void Teardown()

	{ extent.flush();
	   // d.close();
	
	
	}	
	
}
