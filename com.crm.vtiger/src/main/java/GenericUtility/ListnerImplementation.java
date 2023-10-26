package GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener {
	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
	String methodname = result.getMethod().getMethodName();
	System.out.println(methodname+"testscriptExecution Started");
	test=reports.createTest(methodname);
	}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, methodname+"pass");
		System.out.println(methodname+"testscriptExecutionStatus Pass");	
	}

	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.FAIL,methodname+"fail");
		test.log(Status.INFO, result.getThrowable());
		System.out.println(methodname+"testscriptExecutionStatus Fail");
		
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		String screenshotName = jutil.getModifiedSysDate();
		
		
		try {
			String path = wutil.screenshot(BaseClass.sdriver, screenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP,methodname+"skipped");
		test.log(Status.INFO,result.getThrowable());
		System.out.println(methodname+"testscriptExecutionStatus Skipped");
	}

	public void onStart(ITestContext context) {
		System.out.println("suitelevel Execution started");
	//system configuration
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentRport\\Report-"+new JavaUtility().getModifiedSysDate()+".html");
	htmlreport.config().setDocumentTitle("Execution Report");
	htmlreport.config().setTheme(Theme.STANDARD);
	htmlreport.config().setReportName("vtiger Execution Report");
	
	//Report configuration
    reports=new ExtentReports();
	reports.attachReporter(htmlreport);
	reports.setSystemInfo("BaseUrl","http://localhost:8888/");
	reports.setSystemInfo("BasePlatform", "window");
	reports.setSystemInfo("Basebrowser","chrome");
	reports.setSystemInfo("ReporterName","Radhika");
	
	}
	

	public void onFinish(ITestContext context) {
		//To consolidate the report or to replace the old report with new report
		reports.flush();
		System.out.println("suitelevel Execution finished");
		
	}
	
	

}
