import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
//        System.out.println("onTestStart");
//        System.out.println("execute when test start :: " + result.getStartMillis());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //ex - get the response time of total execution
        System.out.println("execute if test success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //ex - take ss when test failed
        System.out.println("execute if failed  :: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
