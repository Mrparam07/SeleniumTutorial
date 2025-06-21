package io.section13;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.net.ssl.HttpsURLConnection;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;

import static org.openqa.selenium.remote.http.Route.options;

public class Revision13 {
    public static void main(String[] args) throws IOException {

        //course Revision
//        courseRevision();

        //options useCase
//        browserOptions();

        //manage useCase
//        manage();

        //cookie
//        handleCookie();

        //Take Screenshot
//        takeScreenshot();

        //broken Links
//        brokenLinks();

        //Find all broken Links
        allBrokenLinks();
    }

    private static void allBrokenLinks() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //find all the broken url/links present in the webPage

        List<String> brokenList = new ArrayList<>();

        SoftAssert softAssert = new SoftAssert();
//        List<WebElement> links = driver.findElements(By.tagName("a"));
        List<WebElement> links = driver.findElements(By.cssSelector("#gf-BIG a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD");
            con.connect();
            //store all broken links
            if(con.getResponseCode() > 400) {
                brokenList.add(link.getText());
            }

            //assert all broken links
            softAssert.assertFalse(con.getResponseCode() > 400, "Link Broken ::" + link.getText());
//            softAssert.assertTrue(con.getResponseCode() < 400, "Link Broken ::" + link.getText());
        }
        Iterator<String> it = brokenList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
//            String link = it.next();
//            System.out.println(link);
        }
        softAssert.assertAll();

    }

    private static void brokenLinks() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //find if the url/link is broken
        WebElement link = driver.findElement(By.xpath("//a[contains(text(),'SoapUI')]"));
//        System.out.println(driver.findElement(By.cssSelector("*[href*='appiumselenium']")).getAttribute("href"));
//        System.out.println(driver.findElement(By.xpath("//*[contains(@href,'appiumselenium')]")).getAttribute("href"));
        String url = link.getAttribute("href");
        System.out.println(url);
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("HEAD");
        con.connect();
        int code = con.getResponseCode();
        System.out.println(code);

    }

    private static void takeScreenshot() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //casting driver object to take ss method
        //FileUtils copy file from src to local machine
//        FileUtils.copyFile(src, new File("C:\\ss.png")); //exception occur in c drive : Access Denied we cannot write directly into c drive
        String ss = "param";
        FileUtils.copyFile(src, new File("D:\\TechAndLearn\\IdeaProjects\\SeleniumTutorial\\ss\\" + ss + ".png"));
    }

    private static void handleCookie() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        //manage() - maximize, delete cookies
        driver.get("https://www.instagram.com/?hl=en");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("");
        driver.findElement(By.xpath("//div[.='Log in']")).click();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().deleteCookieNamed("param");
//        driver.manage().addCookie("cookie");

        //get all the cookies present in the site
//        System.out.println("Cookies present on the site:");
//        for (Cookie cookie : driver.manage().getCookies()) {
//            System.out.println("Name: " + cookie.getName());
//            System.out.println("Value: " + cookie.getValue());
//            System.out.println("Domain: " + cookie.getDomain());
//            System.out.println("Path: " + cookie.getPath());
//            System.out.println("Expiry: " + cookie.getExpiry());
//            System.out.println("Is Secure: " + cookie.isSecure());
//            System.out.println("-----------------------------------");
//        }
        //get only sessionId cookie details
        try {
            // Retrieve the 'sessionid' cookie
            Cookie sessionCookie = driver.manage().getCookieNamed("sessionid");

            // Print the 'sessionid' cookie details
            if (sessionCookie != null) {
                System.out.println("Session ID Cookie Details:");
                System.out.println("Name: " + sessionCookie.getName());
                System.out.println("Value: " + sessionCookie.getValue());
                System.out.println("Domain: " + sessionCookie.getDomain());
                System.out.println("Path: " + sessionCookie.getPath());
                System.out.println("Expiry: " + sessionCookie.getExpiry());
                System.out.println("Is Secure: " + sessionCookie.isSecure());
            } else {
                System.out.println("No 'sessionid' cookie found.");
            }
        } finally {
            // Close the browser
            System.out.println("out");
        }

        //how to logout session in sel - by deleting session cookie
//        driver.manage().deleteCookieNamed("sessionId");

        driver.findElement(By.xpath("//span[text()='Home']")).click();

    }

    private static void courseRevision() {
        ChromeOptions options = new ChromeOptions();
        //https://developer.chrome.com/docs/chromedriver/capabilities
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());

        //download path
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);

        //how to logout session in sel - by deleting session cookie
        driver.manage().deleteCookieNamed("sessionName");

    }

    private static void browserOptions() {
        ChromeOptions options = new ChromeOptions();

        //1. Headless Testing
//        options.addArguments("--headless");  // Run Chrome in headless mode
//        options.addArguments("--disable-gpu");  // Disable GPU rendering
//        WebDriver driver = new ChromeDriver(options);
//        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //2. Disabling Notifications
//        options.addArguments("--disable-notifications");
        //method 2
        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));
//        WebDriver driver = new ChromeDriver(options);
//        driver.get("https://www.spicejet.com/");

        //3. Incognito Mode
//        options.addArguments("--incognito");  // Enable incognito mode
//        WebDriver driver = new ChromeDriver(options);
//        driver.get("https://www.spicejet.com/");

        //4. Custom Window Size
//        options.addArguments("window-size=1200,800");  // Set window size
//        // or maximize the window
//        options.addArguments("--start-maximized");  // Start the browser maximized
//        WebDriver driver = new ChromeDriver(options);

        //5. Disabling Extensions
//        options.addArguments("--disable-extensions");  // Disable extensions
//        WebDriver driver = new ChromeDriver(options);

        //6. Setting Proxy
//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy("proxy-address:port");
//        options.setProxy(proxy);
//        WebDriver driver = new ChromeDriver(options);

        //7. Running in Kiosk Mode
//        options.addArguments("--kiosk");  // Enable kiosk mode
//        WebDriver driver = new ChromeDriver(options);

        //8. Adding User-Agent
//        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
//        WebDriver driver = new ChromeDriver(options);

        //9. Disabling Automation Flags
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});  // Remove automation message
//        WebDriver driver = new ChromeDriver(options);

        //10. Adding Experimental Options
//        options.setExperimentalOption("prefs", Map.of("credentials_enable_service", false, "profile.password_manager_enabled", false));
//        WebDriver driver = new ChromeDriver(options);

        //11. Loading a Specific Chrome Profile
//        options.addArguments("user-data-dir=/path/to/profile");  // Use a specific profile
//        WebDriver driver = new ChromeDriver(options);

        //12. Running in Debugging Mode
//        options.setExperimentalOption("debuggerAddress", "localhost:9222");  // Attach to an existing debugging session
//        WebDriver driver = new ChromeDriver(options);

        //13. Disabling Sandbox
//        options.addArguments("--no-sandbox");  // Disable sandbox mode
//        WebDriver driver = new ChromeDriver(options);

        //14. Running in Mobile Emulation Mode
//        Map<String, String> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceName", "iPhone X");  // Simulate an iPhone X
//        options.setExperimentalOption("mobileEmulation", mobileEmulation);
//        WebDriver driver = new ChromeDriver(options);

        //15. Setting a Custom Download Directory
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("download.default_directory", "/path/to/download/directory");  // Set custom download directory
//        options.setExperimentalOption("prefs", prefs);
//        WebDriver driver = new ChromeDriver(options);

        //16. Silent Mode
//        options.addArguments("--log-level=3");  // Set log level to "ERROR"
//        WebDriver driver = new ChromeDriver(options);

        //17. Running in a Specific Language
//        options.addArguments("--lang=es");  // Set browser language to Spanish
//        WebDriver driver = new ChromeDriver(options);

        //18. Avoiding Browser Info Popups
        options.addArguments("disable-infobars");  // Disable "Chrome is being controlled" infobar
        WebDriver driver = new ChromeDriver(options);


        driver.get("https://www.spicejet.com/");

    }

    private static void manage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/");
        //1. Managing Timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // Wait up to 10 seconds for elements to appear
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));  // Wait up to 30 seconds for a page to load
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));  // Wait up to 15 seconds for JavaScript execution


        //2. Managing Cookies
        Cookie cookie = new Cookie("sessionToken", "abc123");
        driver.manage().addCookie(cookie);  // Add a cookie to the session

        //Get a Specific Cookie
        Cookie sessionCookie = driver.manage().getCookieNamed("sessionToken");
        System.out.println("Cookie Value: " + sessionCookie.getValue());

        driver.manage().deleteAllCookies();  // Clear all cookies

        //3. Managing Browser Window
        driver.manage().window().maximize();  // Maximize the window
        driver.manage().window().setSize(new Dimension(1024, 768));  // Set browser size
        driver.manage().window().getSize();
        driver.manage().window().minimize();  // Minimize the browser window
//        driver.manage().window().setPosition();
        Point position = driver.manage().window().getPosition();
        System.out.println("Window Position: " + position);
        driver.manage().window().fullscreen();  // Enter fullscreen mode

        //4. Managing Logs (Advanced Use Case)
        //to retrieve browser logs,This is particularly useful for debugging, Use Cases: Analyze browser console logs during test failures, Debug JavaScript errors
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry log : logs) {
            System.out.println(log.getMessage());
        }

    }
}
