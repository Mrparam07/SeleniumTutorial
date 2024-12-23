package io.section6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LocPrc2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            doLogin(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        validateLogin(driver);
        doLogout(driver);
    }

    public static void doLogout(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
    }

    public static void validateLogin(WebDriver driver) {
        System.out.println("validating login");
//        String loggedInUserName = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
//        boolean var = loggedInUserName.contains("param");
//        Assert.assertTrue(var);
        String uName = "param";
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(), "Hello " + uName + ",");
    }

    public static void doLogin(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.partialLinkText(" your password?")).click();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(2)")).sendKeys("param");
        driver.findElement(By.xpath("//*[contains(@placeholder,'Emai')]")).sendKeys("param@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("348900");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div[class*='pwd-'] button:last-child")).click();
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
    }
    public static String getThePassword(WebDriver driver, String infoText) {
        //Please use temporary password 'rahulshettyacademy' to Login.
        return infoText.split("'")[1].split("'")[0];
    }
}
