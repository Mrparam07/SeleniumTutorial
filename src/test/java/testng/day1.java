package testng;

import org.testng.annotations.*;

public class day1 {

    @Test
    public void metOne() {
        System.out.println("day 1 one");
    }

    @Test
    public void metTwo() {
        System.out.println("day 1 two");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
    }
//    @AfterMethod
//    public void afterMethod() {
//        System.out.println("After method");
//    }
//
//    @BeforeClass
//    public void beforeClass() {
//        System.out.println("Before class");
//    }
//    @AfterClass
//    public void afterClass() {
//        System.out.println("After class");
//    }
}
