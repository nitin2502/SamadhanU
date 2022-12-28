package Masters;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserRegistration
{

	WebDriver d;


	@BeforeTest
	public void Beforetest() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		d=new ChromeDriver();
		String url ="http://demo.samadhanosmanabad.in/home";
		d.get(url);
		d.manage().window().maximize();
		System.out.println("Test running in Chrome");	

	}

	@Test(priority=1)
	public void login() throws Exception
	{  

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
	@Test(priority=2 ,dataProvider="TestData" )
	public void ADDuser(String nam,String nmr) throws Exception

	{ 
		d.findElement(By.xpath("//*[@id=\"sidebar\"]/div/perfect-scrollbar/div/div[1]/div/ul/li[6]/a/img")).click();
		Thread.sleep(1000);
		d.findElement(By.id("mat-select-6")).click();
		Thread.sleep(1000);
		d.findElement(By.id("mat-option-3")).click();
		Thread.sleep(1000);


		WebElement nm =d.findElement(By.id("mat-input-4"));
		nm.clear();
		nm.sendKeys(nam);
		Thread.sleep(1000);
		/*
		d.findElement(By.id("mat-select-8")).click();
		Thread.sleep(1000);
		WebElement dist=	d.findElement(By.xpath("//*[@id=\"mat-option-65\"]/span"));
		dist.click();
		Thread.sleep(1000);
		 */
		WebElement mn=d.findElement(By.id("mat-input-5"));
		mn.clear();
		mn.sendKeys(nmr);
		Thread.sleep(1000);

		WebElement ml=d.findElement(By.id("mat-input-6"));
		ml.clear();
		ml.sendKeys("ghorpadenitin145@gmail.com");
		Thread.sleep(1000);
		d.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		System.out.println("User Added Grieavance sucessfully ");
	}
	@DataProvider(name="TestData")
	public String[] []getData()
	{
		String[] [] s= {{" Kadam","9632587415"},{"Ghorpade","7418529632"},{"PAndit","8529638745"}};


		return s;
	}

	@AfterTest
	public void Teardown()

	{ 
		d.close();


	}	

}
