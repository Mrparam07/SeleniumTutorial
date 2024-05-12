package io.section6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        //implicit wait - provide implicit wait time for each step
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("param");
        driver.findElement(By.className("submit")).click();
        //failing due to time out issue
        //driver.wait(2000);

        //xPath and cssSelector
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        //console - $('p.error')
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("param");
        //console - $x('//input[@placeholder="Name"]')
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("param@gmail.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("param@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("7061159407");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); //reg exp
        Assert.assertEquals("You are successfully logged in.",driver.findElement(By.xpath("//p[normalize-space()='You are successfully logged in.']")).getText());

        //Locators Two
        
    }
}
