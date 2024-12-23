package io.section6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LocatorsPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("rahul");
        driver.findElement(By.className("signInBtn")).click();
        String str = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(str);
        driver.findElement(By.partialLinkText(" your password?")).click();

        //fill forget pass data

//        input[placeholder*='Nam']
//        //input[contains(@placeholder,'Nam')]
//        //*[contains(@placeholder,'Nam')]
        driver.findElement(By.cssSelector("input[type='text']:nth-child(2)")).sendKeys("param");
        driver.findElement(By.xpath("//*[contains(@placeholder,'Emai')]")).sendKeys("param@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("348900");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div[class*='pwd-'] button:last-child")).click();
//        driver.findElement(By.xpath("//div[contains(@class,'pwd-')]/button[2]")).click();

        //get the password
        String infoText = driver.findElement(By.cssSelector("form p")).getText();
        System.out.println(infoText);
        String pass = getThePassword(driver, infoText);
        //back to login
        driver.findElement(By.xpath("//div[contains(@class,'pwd-')]/button[1]")).click();
        driver.findElement(By.id("inputUsername")).sendKeys("param");
        driver.findElement(By.name("inputPassword")).sendKeys(pass);
        Thread.sleep(1000);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.className("signInBtn")).click();

        //logged In
        String loggedInUserName = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
        boolean var = loggedInUserName.contains("param");
        Assert.assertTrue(var);
    }
    private static String getThePassword(WebDriver driver, String infoText) {
        //Please use temporary password 'rahulshettyacademy' to Login.
        return infoText.split("'")[1].split("'")[0];
    }
}

/*
import java.time.Duration;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;





public class Locators {



public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

//implicit wait - 2 seconds time out


System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");

WebDriver driver = new ChromeDriver();

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

driver.get("https://rahulshettyacademy.com/locatorspractice/");

driver.findElement(By.id("inputUsername")).sendKeys("rahul");

driver.findElement(By.name("inputPassword")).sendKeys("hello123");

driver.findElement(By.className("signInBtn")).click();

System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

driver.findElement(By.linkText("Forgot your password?")).click();

Thread.sleep(1000);//

driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");

driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

System.out.println(driver.findElement(By.cssSelector("form p")).getText());

driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

Thread.sleep(1000);

driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

driver.findElement(By.id("chkboxOne")).click();

driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();





}



}
 */
