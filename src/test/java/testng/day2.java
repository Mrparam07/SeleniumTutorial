package testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {

//    @AfterSuite
//    public void funThree() {
//        System.out.println("after suite");
//    }
//
//    @AfterTest
//    public void funOne() {
//        System.out.println("after day 2 one");
//    }

    @Test(groups = {"Smoke"})
    public void funTwo() {
        System.out.println("day 2 two");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("askhjlakd");
    }
}
