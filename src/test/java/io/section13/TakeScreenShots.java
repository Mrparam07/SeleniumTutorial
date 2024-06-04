package io.section13;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenShots {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //casting driver object to take ss method
        //FileUtils copy file from src to local machine
        //exception occur in c drive
        FileUtils.copyFile(src, new File("D:\\TechAndLearn\\IdeaProjects\\SeleniumTutorial\\ss\\ss.png"));

    }
}
