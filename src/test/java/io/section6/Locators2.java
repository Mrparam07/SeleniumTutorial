package io.section6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String name = "param";
        String pwd = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("param");
        driver.findElement(By.name("inputPassword")).sendKeys(pwd);
        driver.findElement(By.className("submit")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());;
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        //Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+ name +",");
        System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),"Hello "+ name +",");
//        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.findElement(By.xpath("-//*[text()='Log Out']")).click(); //* -> for all tag
        System.out.println("Logged Out");
        driver.quit();

    }
    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String pwdText = driver.findElement(By.cssSelector("form p")).getText();
        //Please use temporary password 'rahulshettyacademy' to Login.
        String strArray[] = pwdText.split("'");
        //strArray[1] -> rahulshettyacademy' to Login.
        String pwd = strArray[1].split("'")[0];
        return pwd;
    }
}
