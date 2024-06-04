package io.section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
//        driver.switchTo().frame(1);
//        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
//        actions.doubleClick(draggable).clickAndHold(draggable).moveToElement(droppable).click().build().perform();
        actions.dragAndDrop(draggable,droppable).build().perform();
        driver.switchTo().defaultContent();

    }
}
