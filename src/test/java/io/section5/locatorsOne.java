package io.section5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class locatorsOne {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("rahul");
        driver.findElement(By.className("signInBtn")).click();
//        Thread.sleep(1000);
        String str = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(str);
        driver.findElement(By.partialLinkText(" your password?")).click();
        Thread.sleep(1000);

        //cssSelector
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("param");

        //xpath
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("mail@gmail.com");

        driver.findElement(By.cssSelector("input[placeholder='Name']")).clear();
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("param");

//        driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("7061159407");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("348900");
//        driver.findElement(By.className("reset-pwd-btn")).click();
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
//        driver.findElement(By.className("reset-pwd-btn")).click();

        String infoText = driver.findElement(By.cssSelector("form p")).getText();
        System.out.println(infoText);
//        driver.close();
    }
}
