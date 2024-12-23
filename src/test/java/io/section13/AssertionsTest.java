package io.section13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class AssertionsTest {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> allLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert softAssert = new SoftAssert();

        for (WebElement link : allLinks) {
            String linkUrl = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(linkUrl).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();

            //Execution will fail as soon as if it find broken link
//            Assert.assertTrue(conn.getResponseCode() >= 400,
//                    "The link with text " + link.getText() + " is broken with status code::" + conn.getResponseCode());
            softAssert.assertFalse(conn.getResponseCode() >= 400,
                    "The link with text " + link.getText() + " is broken with status code::" + conn.getResponseCode());
        }
        softAssert.assertAll();
        driver.quit();
    }
}

