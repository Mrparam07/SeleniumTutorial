package io.section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles(); //{"parent","child","subchild"}
        Iterator<String> it = windows.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);
//        String usernamePara = driver.findElement(By.xpath("//p[@class='im-para red']/strong/a")).getText();
        String usernamePara = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
        String userName = usernamePara.split("at")[1].split("with")[0].trim();
        System.out.println(userName);
        driver.switchTo().window(parent);
        driver.findElement(By.id("username")).sendKeys(userName);

        //switch to all window one by one
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }
}
