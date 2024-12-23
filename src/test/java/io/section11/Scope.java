package io.section11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class    Scope {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver(); //globalDriver
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //count total number of link on the page //a
        System.out.println(driver.findElements(By.tagName("a")).size());

        //finds total number of links in footer
        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); //miniDriver //limited WebDriver
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //finds total number of links in 1st column
        WebElement tableDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        List<WebElement> firstCol = tableDriver.findElements(By.tagName("a"));
        System.out.println(firstCol.size());

        Actions actions = new Actions(driver);


        //open all the tabs
        for (int i = 1; i < firstCol.size(); i++) {
            String colLinkTable = Keys.chord(Keys.CONTROL, Keys.ENTER);
//            firstCol.get(i).sendKeys(colLinkTable);
            tableDriver.findElements(By.tagName("a")).get(i).sendKeys(colLinkTable);
            Thread.sleep(1000L);
        }

        //get the title of all the windows
        Set<String> win = driver.getWindowHandles();
        Iterator<String> it = win.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

//        driver.quit();
    }
}
