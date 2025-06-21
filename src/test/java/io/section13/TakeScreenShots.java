package io.section13;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenShots {
    public static void main(String[] args) throws IOException {

        //take full page ss
        takeFullPageSS();

        //take element ss
        takeElementSS();

    }

    private static void takeElementSS() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys("param");
        //take element ss
        File file = name.getScreenshotAs(OutputType.FILE); //'file' is object that needs to be converted into physical file
        FileUtils.copyFile(file, new File("D:\\TechAndLearn\\IdeaProjects\\SeleniumTutorial\\ss\\partialss.jpg")); //converts file object into physical file

    }

    private static void takeFullPageSS() throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //casting driver object to take ss method
        //FileUtils copy file from src to local machine
        //exception occur in c drive
        FileUtils.copyFile(src, new File("D:\\TechAndLearn\\IdeaProjects\\SeleniumTutorial\\ss\\ss.png"));
    }
}
