package io.section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandleAssignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
//        driver.findElement(By.xpath("//li/a[text()='Multiple Windows']")).click();
//        driver.findElement(By.cssSelector("a[href$='/windows']")).click();
//        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Multiple Windows')]")).click();
        driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
        driver.switchTo().window(parent);
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());



    }
}
