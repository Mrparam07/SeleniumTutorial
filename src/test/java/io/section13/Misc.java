package io.section13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Misc {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        //manage() - maximize, delete cookies
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed("param");
//        driver.manage().addCookie("cookie");

        //how to logout session in sel - by deleting session cookie
        driver.manage().deleteCookieNamed("sessionName");

        driver.get("https://www.google.com");
    }
}
