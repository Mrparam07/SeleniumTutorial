package io.section15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class InvokeBrowsers {
    public static void main(String[] args) throws IOException {

        //Invoking Multiple Browsers
//        invokeMultipleTabsWindows();

        //take element ss/partial ss
        takePartialSS();

        //Get height and width
    }
    private static void takePartialSS() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //fill the name field with first course name available at other site ""
        driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        String parentWindowId = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");
        String courseName = driver.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]"))
                .get(1).getText();
        driver.switchTo().window(parentWindowId);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);

        //full ss
//        File fileFull = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //'file' is object that needs to be converted into physical file

        //take element ss
//        File file = name.getScreenshotAs(OutputType.FILE); //'file' is object that needs to be converted into physical file
//        FileUtils.copyFile(file, new File("D:\\TechAndLearn\\IdeaProjects\\SeleniumTutorial\\ss\\partialss.jpg")); //converts file object into physical file

        //get height and width of the web element
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
    }

    private static void invokeMultipleTabsWindows() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //fill the name field with first course name available at other site ""
        driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        String parentWindowId = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");
//        String name = driver.findElement(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/get-access-to-all-courses']:nth-last-child(1)")).getText();
        String courseName = driver.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]"))
                .get(1).getText();
//        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
////                .get(1).getText();
        driver.switchTo().window(parentWindowId);
        driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);

    }
}
