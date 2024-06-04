package io.section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameAssignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Nested Frames")).click();
//        driver.switchTo().frame(driver.findElement(By.xpath("//frame[1]")));
//        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
//        driver.switchTo().frame(driver.findElement(By.xpath("//frame[2]")));
//        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
    }
}
