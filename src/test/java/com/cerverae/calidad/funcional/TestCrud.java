package com.cerverae.calidad.funcional;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class TestCrud {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		  
		System.setProperty("webdriver.chrome.driver", "/Users/estebancervera/Documents/Calidad/chromedriver");
	    driver = new ChromeDriver();
	    baseUrl = "https://www.google.com";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  //exito
	  @Test
	  public void testAddUser() throws Exception {
		  	driver.get("https://mern-crud.herokuapp.com");
		  	driver.findElement(By.xpath("/html/body/div/div/div[2]/button")).click();
		    driver.findElement(By.name("name")).clear();
		    driver.findElement(By.name("name")).sendKeys("TEST");
		    driver.findElement(By.name("email")).click();
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys("12323@gmail.com");
		    driver.findElement(By.name("age")).click();
		    
		    driver.findElement(By.name("age")).clear();
		    driver.findElement(By.name("age")).sendKeys("10");
		   // driver.findElement(By.name("gender")).click();
		   
		    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
		    driver.findElement(By.xpath("//div[2]/div/div[2]/div")).click();
		    
		    driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click();
		    
		    String text =  driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p")).getText();
		    String text2 =  driver.findElement(By.xpath(" /html/body/div[2]/div/div[2]/form/div[5]/div/p")).getText();
		   
	   // assertEquals("Successfully added!",text);
	    assertEquals("That email is already taken.",text2);
	  }

	  
	  //error email ya usado
	  
	  
	  
	  
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}