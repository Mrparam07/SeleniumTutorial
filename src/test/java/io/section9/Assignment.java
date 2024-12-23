package io.section9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Assignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        loginUser(driver,"rahulshettyacademy", "learning");
        List<WebElement> addToCart = driver.findElements(By.xpath("//button[text()='Add ']"));
        addProduct(driver,addToCart);
        driver.quit();
    }

    private static void loginUser(WebDriver driver, String username, String pass) {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys(pass);
//        driver.findElement(By.xpath("//span[text()=' User']")).click();
        driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
        driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
        WebElement role = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select select = new Select(role);
        select.selectByVisibleText("Teacher");
        if(!driver.findElement(By.name("terms")).isSelected())
            driver.findElement(By.name("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
    }

    private static void addProduct(WebDriver driver, List<WebElement> products) {
        for(int i=0;i<products.size();i++){
            products.get(i).click();
        }
    }
}
