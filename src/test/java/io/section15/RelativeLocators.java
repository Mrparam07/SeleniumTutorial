package io.section15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
    public static void main(String[] args) {

        //Relative Locators
        relativeLocators();

    }

    private static void relativeLocators() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //above
        WebElement nameInput = driver.findElement(By.name("name"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameInput)).getText());

        //below
        WebElement dateOfBirth = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click(); //selecting next input button due to flex

        //left
//        WebElement checkBoxTxt = driver.findElement(By.cssSelector("label[class*='form-check-label']"));
        WebElement checkBoxTxt = driver.findElement(By.xpath("//label[contains(text(),'Check me out if you Love')]"));
        driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxTxt)).click();

        //right
        WebElement inlineRadio1 = driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(inlineRadio1)).getText());


    }
}
