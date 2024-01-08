package pages;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import base.Base;

public class Home1 extends Base
{
//	page object model
	String str;
	By hmpg =By.xpath("//div[@class='login_logo']");
	By vloginuser=By.id("user-name");
	By vloginpass=By.id("password");
	By loginbtn=By.id("login-button");
	By error=By.xpath("//h3[@data-test='error']");
	By prodpg=By.xpath("//span[@class='title']");
	By getlist=By.xpath("//div[@class='inventory_item_name']");
	By cartlink=By.linkText("Cart");
	By placebtn=By.xpath("//button[text()='Place Order']");

	
//	code to open the URL of the website 
	public void openURL()
	{
		driver.get(prop.getProperty("url"));
		try 
		{
			Thread.sleep(2000);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
//	code to validate the home page of the website
	public void validate_hmpg()
	{
		if(driver.findElement(hmpg).isDisplayed())
		{
			System.out.println("User is on home page");
		}
		else
		{
			System.out.println("User is not on home page");
		}
	}
	
	
//	code to enter the invalid details in login form	
	public void invalid_login(String username, String password) throws AWTException
	{
		driver.findElement(vloginuser).sendKeys(username);
		driver.findElement(vloginpass).sendKeys(password);
		driver.findElement(loginbtn).click();
		
        str=driver.findElement(error).getText();
   
        driver.findElement(vloginuser).clear();
        driver.findElement(vloginpass).clear();
	}
	
//	code to check the login form status	
	public void login_status()
	{
		testlog = report.createTest("Login Test (Valid & Invalid)");
		
		if(str.contains("Username and password do not match any user in this service"))
		{
			testlog.log(Status.FAIL, "Entered invalid details-Login unsuccessful");
		}
		else
		{
			testlog.log(Status.PASS, "Entered valid details-Login successful");
		}
		
	}
	
//	code to enter the valid details in login form	
	public void valid_login(String username1, String password1) throws AWTException
	{
		driver.findElement(vloginuser).sendKeys(username1);
		driver.findElement(vloginpass).clear();
		driver.findElement(vloginpass).sendKeys(password1);
		driver.findElement(loginbtn).click();
		str="";
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		takeScrenShot("ValidLogin.png");
	}
	
	
	public void validate_prodpg()
	{
		if(driver.findElement(prodpg).isDisplayed())
		{
			System.out.println("User is on product page");
		}
		else
		{
			System.out.println("User is not on product page");
		}
	}
	
//	code to read the list of products from the selected category
	public void read_products() throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\TASAWANT\\eclipse-workspace\\swaglabs\\File.xlsx");  
		XSSFWorkbook wb=new XSSFWorkbook(file); 
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		testlog = report.createTest("Read Products Test");
		
		List<WebElement> list=driver.findElements(getlist);
		 Row row;
		 
		 for(int r=0;r<list.size();r++)       
		 {
			 	testlog.log(Status.INFO, list.get(r).getText());
			 	row=ws.createRow(r);
			    str=list.get(r).getText();
			    row.createCell(0).setCellValue(r+1);
			    row.createCell(1).setCellValue(str);
			  
		 } 
		 FileOutputStream fout=new FileOutputStream("C:\\Users\\TASAWANT\\eclipse-workspace\\swaglabs\\File.xlsx");
			wb.write(fout);
			wb.close();
			
	}
	

}
