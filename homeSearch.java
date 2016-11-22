/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class homeSearch {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver(); //you can change this browser
    baseUrl = "http://sg.startupjobs.asia/sg";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testhomeSearch() throws Exception {
    // this will search jobs with keyword front end
    String result, words, result1, result2;
    String intern = "Internship";
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/form/div/div/input")).sendKeys("front end");
    Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/form/div/div/select[3]")));
    dropdown.selectByValue(intern);
    driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/form/div/div/button")).click();
    result = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div[1]/h1")).getText();
    words = "Search for frontend Internship jobs in Anywhere";
        if (result.equals(words)) {
            System.out.println("matched");
        } else {
            System.out.println("didn't match");
        }

    result1=driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a")).getText();
    result2=driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/a")).getText();
    if (result1.equals(result2)) {
        if (result2.equals(intern)){
            System.out.println("result matched "+intern);
        } else {
            System.out.println("didn't match");
        }
    }
    driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/span/strong/a")).click();

    //lanjutin sendiri maslut :D
   
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
