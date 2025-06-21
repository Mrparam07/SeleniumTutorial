package testng;

import org.testng.annotations.*;

public class day4 {

    @Parameters({"URL"})
    @Test
    public void met4One(String urlValue) {
        System.out.println("day 4 one");
        System.out.println(urlValue);
    }

//    @BeforeTest
//    public void met4Two() {
//        System.out.println("before day 4 two");
//    }
//    @BeforeSuite
//    public void met4Three() {
//        System.out.println("before suite");
//    }
}
