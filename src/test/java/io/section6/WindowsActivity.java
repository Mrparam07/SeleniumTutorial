package io.section6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsActivity {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().window().fullscreen();

        //maximize vs full screen
        driver.get("https://www.google.com");
        driver.navigate().to("otherUrl");
        driver.navigate().back();
        driver.navigate().forward();
    }
}
