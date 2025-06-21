package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class day5 {

    @Test
    public void web() {
        System.out.println("web");
    }
    @Test(dependsOnMethods = {"ztest","web"})
    public void api() {
        System.out.println("api");
    }
    @Test(enabled = false)
    public void mobile() {
        System.out.println("mobile");
    }
    @Test(groups = {"Smoke"})
    public void mobileTwo() {
        System.out.println("mobile two");
    }
    @Test
    public void ztest() {
        System.out.println("z test");
    }

    //parameter
    @Parameters({"URL","Key"}) // it can contains multiple params
    @Test
    public void parameterCheck(String urlValue, String key) {
        System.out.println("parameterCheck One:: " + urlValue);
        System.out.println("parameterCheck Two:: " + key);
    }


    @Test(dataProvider = "dataProviders")
    public void dataProviderTest(String urlValue, String key) {
        System.out.println(urlValue +" :: " + key);
    }
    //check 3 times username and password
    @DataProvider
    public Object[][] dataProviders(){
        Object ob[][] = new Object[3][2];
        ob[0][0] = "firstURL";
        ob[0][1] = "firstValue";
        ob[1][0] = "SecondURL";
        ob[1][1] = "SecondKey";
        ob[2][0] = "ThirdURL";
        ob[2][1] = "ThirdKey";
        return ob;
    }

    @Test
    public void listenersTest() {
        System.out.println("This method is used to verify listeners");
        assertTrue(false, "Check if true");
    }
    @Test
    public void listenersTestTwo() {
        System.out.println("again This method is used to verify listeners");
//        assertTrue(false, "Check if true");
    }
}
