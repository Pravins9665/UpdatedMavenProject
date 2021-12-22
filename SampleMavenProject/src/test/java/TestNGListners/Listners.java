package TestNGListners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners implements ITestListener {

	// This method will execute before any test execution
	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName() + ": onStart method is started...");
	}

	// This method will execute before starting each test execution
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + ": New test started to execute");
	}

	// This method will execute after successfully passing each test execution
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + ": Method is successfully passed");
	}

	// This method will execute after each failed test execution
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + ": Method is Failed");
	}

	// This method will execute after each skipped test execution
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() + ": Method is Skipped");
	}

	// This method will execute when test method fails as whole but has passed
	// certain success percentage
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(result.getName() + ": Method is failed as whole but passed partailly");
	}

	// This method will execute after all text execution
	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName() + ": onFinish method is started...");

	}

}
