package com.cerverae.calidad.funcional;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class TestGoogle {
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

//	  @Test
//	  public void testUntitledTestCase() throws Exception {
//	    driver.get("https://www.google.com");
//	    driver.findElement(By.name("q")).clear();
//	    driver.findElement(By.name("q")).sendKeys("covid");
//	    driver.findElement(By.id("tsf")).submit();
//	    driver.findElement(By.xpath("//div[@id='kp-wp-tab-overview']/div[5]/div[2]/div/div/div/div/div/div/div/a/h3/span")).click();
//	    assertEquals("Preguntas y respuestas sobre la enfermedad por coronavirus (COVID-19)", driver.getTitle());
//	  }
	  
	  @Test
	  public void testECookiesLoginFail() throws Exception {
		  driver.get("https://www.ecookies.app");
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys("estebancervera@hotmail.com");
		    driver.findElement(By.name("password")).click();
		    driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys("123");
		    driver.findElement(By.xpath("//div[3]/button")).click();
	    assertEquals("No existe ningun usuario con ese email y contraseña", driver.findElement(By.xpath("/html/body/div/div/div/div")).getText());
	  }

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