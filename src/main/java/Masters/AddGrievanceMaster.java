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

public class AddGrievanceMaster
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

	} 
	@Test(priority=2)
	public void ADDGRIEVANCE() throws Exception

	{ 
	d.findElement(By.xpath("//*[@id=\"sidebar\"]/div/perfect-scrollbar/div/div[1]/div/ul/li[4]/a/img")).click();
	Thread.sleep(1000);
	d.findElement(By.id("mat-select-2")).click();
	Thread.sleep(1000);
	d.findElement(By.id("mat-option-29")).click();
	Thread.sleep(1000);
	d.findElement(By.id("mat-input-4")).sendKeys("Water Related");
	Thread.sleep(1000);
	d.findElement(By.id("mat-input-5")).sendKeys("पाण्याशी निगडीत");
	Thread.sleep(1000);
	d.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(1000);
	System.out.println("User Added Grieavance sucessfully ");


	}
	@Test(priority=3)
	public void Editdepartment() throws Exception

	{  
      
	d.findElement(By.xpath("/html/body/app-root/app-partial-layout/div/main/div[1]/div/div[2]/app-grievance-master/div/div/div[1]/div/table/tbody/tr[1]/td[4]/button/span[1]/span")).click();
	Thread.sleep(1000);
	d.findElement(By.id("mat-input-4")).clear();
	Thread.sleep(1000);
	d.findElement(By.id("mat-input-4")).sendKeys("Farming");
	Thread.sleep(1000);
	d.findElement(By.id("mat-input-5")).clear();
	Thread.sleep(1000);
	d.findElement(By.id("mat-input-5")).sendKeys("शेती");
	Thread.sleep(1000);
	d.findElement(By.xpath("//button[@type='submit'][1]")).click();
	Thread.sleep(1000);
	System.out.println("Record updated sucessfully ");
	
	}
	@Test(priority=4)
	public void Deletedepartment() throws Exception
	{
	d.findElement(By.id("mat-checkbox-32")).click();
	Thread.sleep(1000);
	d.findElement(By.xpath("/html/body/app-root/app-partial-layout/div/main/div[1]/div/div[2]/app-grievance-master/div/div/div[1]/div/table/thead/tr/th[4]/button/span[1]/span")).click();
	Thread.sleep(1000);
	d.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-confirmation/div/div/div/div/div[2]/div[2]/div/button[2]/span[1]")).click();
	Thread.sleep(3000);
		
	System.out.println("Grievance deleted sucessfully ");
	
	}
	
	@AfterSuite
	public void Teardown()

	{ extent.flush();
	   d.close();
	
	
	}	
	
}
