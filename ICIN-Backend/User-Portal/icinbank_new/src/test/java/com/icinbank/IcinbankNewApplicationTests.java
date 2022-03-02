package com.icinbank;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IcinbankNewApplicationTests {

	@Test
	public void TestCase1() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:4200/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[1]/input")).sendKeys("admin");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/input")).sendKeys("admin1234");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[3]/button")).click();
		
		try 
		{
			WebDriverWait wait=new WebDriverWait(driver, 14);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("http://localhost:4200/home")));
			System.out.println("Login Successfull");

//			driver.findElement(By.xpath("/html/body/app-root/nav/ul/li[5]/div/a[2]")).click();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-login/div/form/h3")));
//			System.out.println("Signed Out");
		}
		catch(Exception e) 
		{
			System.out.println("Error in browser!!\nPlease have a look");
		}
		
	    Thread.sleep(2000);  
	    driver.quit();
	}

}
