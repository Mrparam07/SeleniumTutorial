package io.section10;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class Revision10 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        //Action Class
//        performAction(driver);

        //Handle Windows
//        handleWindows(driver);

        //Handle Frames
//        handleFrames(driver);

        //Nested Frame Assignment
        frameAssignment(driver);

    }

    private static void frameAssignment(WebDriver driver) {
        //print the text 'MIDDLE'
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Nested Frames")).click();

        //switch to the first frame
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
        //switch to its child frame
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));

        System.out.println(driver.findElement(By.id("content")).getText()); //get text "MIDDLE"

        //get the RIGHT text //TODO
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.cssSelector("body")).getText());

        //get the text of BOTTOM text
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.xpath("//body")).getText());
    }

    private static void handleFrames(WebDriver driver) {
        driver.get("https://jqueryui.com/droppable/");

        //count total iframe
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total frames in the application:: " + size);
        //switch to frame
//        driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        Actions actions = new Actions(driver);
        //drag and drop
//        actions.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).build().perform();
        actions.moveToElement(driver.findElement(By.id("draggable"))).clickAndHold().moveToElement(driver.findElement(By.id("droppable"))).release().build().perform();

        //switch to default content
        driver.switchTo().defaultContent();

    }

    private static void handleWindows(WebDriver driver) {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText:first-child")).click();

        //switch to child windows
        //directly
//        for(String windowName : driver.getWindowHandles()) {
//            driver.switchTo().window(windowName);
//        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);

        WebElement emailText = driver.findElement(By.cssSelector(".im-para.red"));
        System.out.println(emailText.getText());
        //Extract email from text
        String userEmail = extractEmail(emailText.getText());

        //again switch to parent window
        driver.switchTo().window(parentWindow);
        driver.findElement(By.id("username")).sendKeys(userEmail);
    }

    private static String extractEmail(String emailText) {
        // Split the string and find the word containing '@'
        String email = "";
        for (String word : emailText.split(" ")) {
            if (word.contains("@")) {
                email = word;
                break;
            }
        }
        //or method 2
//        return emailText.split("at ")[1].split(" ")[0];
        // Print the email
        System.out.println("Extracted Email: " + email);
        return email;
    }

    private static void performAction(WebDriver driver) {
        driver.get("https://www.amazon.in");

        Actions action = new Actions(driver);
        WebElement move = driver.findElement(By.id("nav-link-accountList"));
        //move to element
        action.moveToElement(move).build().perform();

        //move to search box and write in caps
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
//        action.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("param").build().perform();

        //select the written text by double click
        action.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("param").doubleClick().build().perform();

        //right click
        action.moveToElement(move).contextClick().build().perform();
    }
}
