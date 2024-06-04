package io.section10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionTut {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //mouse hover
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        //#nav-link-accountList
        Actions action = new Actions(driver);
        WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

        //Enter in caps, keys action
        //action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();

        //double click
        //action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        //right click
        action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().contextClick().build().perform();

        //Right click
        //action.moveToElement(driver.findElement(By.id("name"))).contextClick().build().perform();
        //action.moveToElement(move).build().perform();
    }
}
