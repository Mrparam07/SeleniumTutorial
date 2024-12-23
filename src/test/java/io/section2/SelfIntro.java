package io.section2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SelfIntro {
    public static void main(String[] args) {

        //invoking driver by setting the driver path
//        System.setProperty("webdriver.chrome.driver","{path}");

        //invoke driver automatically by selenium manager
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new EdgeDriver();
//        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.udemy.com/");
        driver.getCurrentUrl();
        driver.getTitle();
        driver.close();
        driver.quit();
    }
}