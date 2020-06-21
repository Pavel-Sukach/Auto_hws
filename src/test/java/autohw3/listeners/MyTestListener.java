package autohw3.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test case with name " + result.getName() + " started!");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case with name " + result.getName() + " success!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case with name " + result.getName() + " failed!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test case with name " + result.getName() + " skipped!");
    }
}
