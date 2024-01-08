package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base 
{
	 public static WebDriver driver;
	   public static ExtentHtmlReporter exthtml;
	   public static ExtentReports report;
	   public static ExtentTest testlog;
	   public static Properties prop;

//	   code to set up the browser
		@BeforeSuite
		public void setup()
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			    
			prop = new Properties();
			try
			{
				prop.load(new FileInputStream("src\\main\\java\\config\\config.properties"));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			exthtml = new ExtentHtmlReporter(prop.getProperty("reportloc"));
			report = new ExtentReports();
		 	report.attachReporter(exthtml);
		 	report.setSystemInfo("Host Name", "TestSystem"); 
		 	report.setSystemInfo("Environment", "Test Env");
		 	report.setSystemInfo("User Name", "Tanvi");
		 	   
		 	exthtml.config().setDocumentTitle("Jpetstore");
		 	exthtml.config().setReportName("Jpetstore Functional Testing");
		 	exthtml.config().setTestViewChartLocation(ChartLocation.TOP);
		 	exthtml.config().setTheme(Theme.STANDARD);
		}
		
//		code to take the screenshot of the page
		public void takeScrenShot(String image)
		{
			try 
			{	
				File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(f, new File(prop.getProperty("imageloc")+image));
				testlog.addScreenCaptureFromPath(prop.getProperty("imageloc")+image);
			} 
			catch (IOException e)
			{
			
				e.printStackTrace();
			}
			
		}
	
//		code to close the browser
		@AfterSuite
		   public void tearDown()
		   {
			   report.flush();            //save the report	  
			   driver.quit();
		   }

}
