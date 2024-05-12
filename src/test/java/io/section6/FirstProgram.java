package io.section6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstProgram {
    public static void main(String[] args) {
        /*
        Invoke Browser
        Chrome - methods get
        Safari - methods
        Edge - methods
        Method will be same
        WebDriver Interface for all the Class containing method blueprint/skeleton
        WebDriver + class method -> ChromeDriver driver = new ChromeDriver()
        restrict driver to focus only in the WebDriver methods so that only webdriver method can be implemented and
        other browser driver also can use those methods and avoid creating their own method
        restrict any specific browser to use only the WebDriver Methods
         */
//      Manually
//        System.setProperty("webdriver.chrome.driver","D:\\TechAndLearn\\IdeaProjects\\SeleniumTutorial\\driver\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//      Selenium Manager automatically download the appropriate browser
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();  //quit the driver
        //driver.close(); //close current window
    }
}
