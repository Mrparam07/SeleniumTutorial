package io.section13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //to check fault links
        //1 - collect all url using selenium
        //2 - java method to call the url and get you status code
        //3 - if status > 400 then broken url

        //$('a[href="soapui"]')
        //a[href*='soapui']
//        String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
//        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
//        con.setRequestMethod("HEAD");
//        con.connect();
//        int statusCode = con.getResponseCode();
//        System.out.println(statusCode);

        List<String> brokenLinks = new ArrayList<>();
        List<String> workingLinks = new ArrayList<>();
        //for all the links
        List<WebElement> allLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert softAssert = new SoftAssert();

        for(WebElement link : allLinks){
            String linkUrl = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(linkUrl).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            if(conn.getResponseCode() >= 400){
                brokenLinks.add(link.getText());
                System.out.println("The link with Text "+link.getText()+" is broken with code::"+conn.getResponseCode());
            }
            else
                workingLinks.add(link.getText());
        }

        //way to print all the links

        for(String bl : brokenLinks)
            System.out.println(bl);

        Iterator<String> it = workingLinks.iterator();
        while(it.hasNext()){
            String link = it.next();
            System.out.println(it.next());
        }
    }
}
