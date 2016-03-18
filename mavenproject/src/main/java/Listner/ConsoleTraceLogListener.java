package Listner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.IClass;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.org.Suite.RegressionSuite.RegressionTestBase;
import com.org.framework.Screenshot.ScreenShots;
import com.org.framework.Util.PropertyUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;

public class ConsoleTraceLogListener extends TestListenerAdapter implements ISuiteListener { 

	private static final Logger logger = LoggerFactory.getLogger(ConsoleTraceLogListener.class);
	
	public static WebDriver driver;
	private ExtentReports extent;
	ExtentTest Report;
	public Properties prop =new Properties();

	public static final String DUMP_LOG_CONF_TRUE = "true";
	public static final String DUMP_LOG_CONF = System.getProperty("dumpLogConf", DUMP_LOG_CONF_TRUE);
	 String time;
	 IClass testClaz = null;
	 boolean appendRow = false;
	public ConsoleTraceLogListener() {
		super();
		// This gets instantiated before tests run, output which logback config loaded
		//setupLogFileConf();
		if (DUMP_LOG_CONF_TRUE.equals(DUMP_LOG_CONF)) {
			System.out.println("DUMP_LOG_CONF=" + DUMP_LOG_CONF);
			LoggerContext loggerContext = ((ch.qos.logback.classic.Logger)logger).getLoggerContext();
			URL mainURL = ConfigurationWatchListUtil.getMainWatchURL(loggerContext);
			// in case no logback config loaded
			System.out.println(mainURL);  
			logger.info("Logback used '{}' as the configuration file.", mainURL);
		}
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		logger.info("Test Succeeded: {}.{}({})", 
				tr.getTestClass().getName(),
				tr.getName(), 
				tr.getParameters() == null || tr.getParameters().length == 0 ? "" : Arrays.toString(tr.getParameters()));
		addToExtentReport(tr, LogStatus.PASS);
		
	}

	
	private void addToExtentReport(ITestResult tr, LogStatus status) {
		Report = extent.startTest(tr.getMethod().getMethodName());
		Report.setStartedTime(getTime(tr.getStartMillis()));
		Report.setEndedTime(getTime(tr.getEndMillis()));
		for (String group : tr.getMethod().getGroups())
			Report.assignCategory(group);
		if (tr.getThrowable() != null) {
			Report.log(status, tr.getThrowable());
			Report.log(status, "Screencast below: " + Report.addScreenCapture(ScreenShots.createScreenshot(RegressionTestBase.driver, tr.getName())));
		}	
		else {
			Report.log(status, status.toString().toLowerCase() + "ed");
		}
		extent.endTest(Report);
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		logger.info("Test Failed: {}.{}({}) with exception: {} {}", 
				tr.getTestClass().getName(),
				tr.getName(), 
				tr.getParameters() == null || tr.getParameters().length == 0 ? "" : Arrays.toString(tr.getParameters()), 
				tr.getThrowable() == null ? "" : tr.getThrowable().getMessage(),
				tr.getThrowable() == null ? "" : ExceptionUtils.getStackTrace(tr.getThrowable()));
		addToExtentReport(tr, LogStatus.FAIL);
				
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		logger.info("Test Skipped: {}.{}({})", 
				tr.getTestClass().getName(),
				tr.getName(), 
				tr.getParameters() == null || tr.getParameters().length == 0 ? "" : Arrays.toString(tr.getParameters()));
		addToExtentReport(tr, LogStatus.SKIP);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
		super.onTestFailedButWithinSuccessPercentage(tr);
		logger.info("Test Failed But Within Success Percentage: {}.{}({}) with exception: {} {}", 
				tr.getTestClass().getName(),
				tr.getName(), 
				tr.getParameters() == null || tr.getParameters().length == 0 ? "" : Arrays.toString(tr.getParameters()), 
				tr.getThrowable() == null ? "" : tr.getThrowable().getMessage(),
				tr.getThrowable() == null ? "" : ExceptionUtils.getStackTrace(tr.getThrowable()));
	}

	@Override
	public void onStart(ITestContext testContext) {
		super.onStart(testContext);
		logger.info("Starting.");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
		logger.info("Finished");
	}

	@Override
	public void onTestStart(ITestResult result) {
	//	logTimer = new LogTimer();
		super.onTestStart(result);
		setTestClass(result);
		logger.info("Starting Test: {}.{}({})", 
				result.getTestClass().getName(),
				result.getName(), 
				result.getParameters() == null || result.getParameters().length == 0 ? "" : Arrays.toString(result.getParameters()));
		
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();  
		
	}



	@Override
	public void onConfigurationFailure(ITestResult itr) {
		super.onConfigurationFailure(itr);
		logger.info("Configuration Failed: {} {}.{} for test {}.{} with exception {}: {})", 
				getAnnotationsSimpleStr(itr.getMethod().getConstructorOrMethod().getMethod().getAnnotations()), 
				itr.getMethod().getRealClass().getName(),
				itr.getName(), 
				itr.getTestClass().getName(),
				itr.getTestContext().getName(),
				itr.getThrowable() == null ? "" : itr.getThrowable().getMessage(),
				itr.getThrowable() == null ? "" : ExceptionUtils.getStackTrace(itr.getThrowable()));
	}
	
	private String getAnnotationsSimpleStr(Annotation[] annotations) {
		String[] names = new String[annotations.length];
		for (int i = 0; i < annotations.length; i++) { 
			names[i] = annotations[i].annotationType().getName();
		}
		return Arrays.toString(names);
	}

	@Override
	public void beforeConfiguration(ITestResult tr) {
		try{
			Thread.sleep(2000);
		}catch(Exception ex) {
		  
		}
		super.beforeConfiguration(tr);
		
		setTestClass(tr);
		logger.info("Starting Configuration type {} {}.{}({}) for test {}.{}", 
				getAnnotationsSimpleStr(tr.getMethod().getConstructorOrMethod().getMethod().getAnnotations()), 
				tr.getMethod().getRealClass().getName(),
				tr.getName(),
				tr.getParameters() == null || tr.getParameters().length == 0 ? "" : Arrays.toString(tr.getParameters()),
				tr.getTestClass().getName(),
				tr.getTestContext().getName()
				);		
	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {
		super.onConfigurationSkip(itr);
		logger.info("Skipping Configuration type {} {}.{}({}) for test {}.{}", 
				getAnnotationsSimpleStr(itr.getMethod().getConstructorOrMethod().getMethod().getAnnotations()), 
				itr.getMethod().getRealClass().getName(),
				itr.getName(),
				itr.getParameters() == null || itr.getParameters().length == 0 ? "" : Arrays.toString(itr.getParameters()),
				itr.getTestClass().getName(),
				itr.getTestContext().getName()
				);
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {
		super.onConfigurationSuccess(itr);
		logger.info("Configuration Succeeded type {} {}.{}({}) for test {}.{}", 
				getAnnotationsSimpleStr(itr.getMethod().getConstructorOrMethod().getMethod().getAnnotations()), 
				itr.getMethod().getRealClass().getName(),
				itr.getName(),
				itr.getParameters() == null || itr.getParameters().length == 0 ? "" : Arrays.toString(itr.getParameters()),
				itr.getTestClass().getName(),
				itr.getTestContext().getName()
				);
	}
	

	
	public void setTestClass(ITestResult result){
		appendRow = false;
		if(result != null && testClaz != null){
			if(!result.getTestClass().getRealClass().getSimpleName().equals(testClaz.getRealClass().getSimpleName())){
				appendRow = true;
			}
		}
		testClaz = result.getTestClass();
	}



	public void onStart(ISuite suite) {
		
		System.out.println("Config utill>>>>>>>>>>"+PropertyUtil.getConfigProps().getProperty("ReportPath"));
		extent=new ExtentReports(PropertyUtil.getConfigProps().getProperty("ReportPath"));
	}



	public void onFinish(ISuite suite) {
		extent.flush();
		extent.close();
	}

}
