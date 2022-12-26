package Masters;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login
{

	WebDriver d;


	@BeforeTest
	public void Beforetest() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		d=new ChromeDriver();
		d.manage().window().maximize();
		Thread.sleep(2000);
		String url ="https://demo.samadhanosmanabad.in/login";
		d.get(url);
		System.out.println("Test  running in Chrome");	
		Thread.sleep(2000);

	}

	@Test(dataProvider="TestData")
	public void login(String user, String Pwd) throws Exception
	{ 

		WebElement un=d.findElement(By.xpath("//input[@formcontrolname='username']"));
		un.clear();
		un.sendKeys(user);
		Thread.sleep(1000);

		WebElement pw= d.findElement(By.xpath("//input[@placeholder='Password']")); 
		pw.clear();
		pw.sendKeys(Pwd);
		Thread.sleep(1000);
		WebElement vw=d.findElement(By.xpath("/html/body/app-root/app-web-layout/div/div/app-login/div/div/div/div[2]/form/div[2]/div[2]/mat-form-field/div/div[1]/div[4]/button/span[1]/span"));
		vw.click();

		String s=JOptionPane.showInputDialog("Enter Captcha"); 
		d.findElement(By.xpath("//input[@formcontrolname='captcha']")).sendKeys(s);
		Thread .sleep(1000);
		d.findElement(By.xpath("/html/body/app-root/app-web-layout/div/div/app-login/div/div/div/div[2]/form/div[2]/button")).click();
		Thread .sleep(2000);
		System.out.println("User Logged sucessfully ");

	} 
	@DataProvider(name="TestData")
	public String[] []getData()
	{
		String[] [] s= {{"AdMin20000","Sama@60000"},
				{"SDHAN55260","Sama@60989"},{"AdMin","Sama@65400"},{"9875588558","Sama@#$@400"},{"AdMin30000","Sama@65400"}};
				                                                         
		return s;
	  }
	@AfterTest
	public void Teardown()

	{ 
		d.close();


	}	

}
