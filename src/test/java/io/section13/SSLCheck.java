package io.section13;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;
import java.util.Map;

public class SSLCheck {
    public static void main(String[] args) {

        //link - https://developer.chrome.com/docs/chromedriver/capabilities
        //customize behaviour of the browsers
        //set proxy and extension
        //disable auto pop-up window
        //set download path

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
//        EdgeOptions op = new EdgeOptions();
//        op.setAcceptInsecureCerts(true);

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        options.setCapability("proxy",proxy);

        //download path
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
//        WebDriver driver = new EdgeDriver(op);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());


    }
}
