package pages;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import base.Base;

public class Purchase extends Base
{
	By placebtn=By.id("checkout");
	By firstname=By.id("first-name");
	By lastname=By.id("last-name");
	By code=By.id("postal-code");
	By contin=By.id("continue");
	By finishbtn=By.id("finish");
	By confirm=By.id("checkout_complete_container");
	By ok=By.id("back-to-products");
	
//	code to open the place order form
	public void place_order()
	{
		driver.findElement(placebtn).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(firstname).sendKeys("tanvi");
		driver.findElement(lastname).sendKeys("sawant");
		driver.findElement(code).sendKeys("321");
		
		driver.findElement(contin).click();
		driver.findElement(finishbtn).click();
	}
	
//  code to confirm the purchase of the product
	public void purchase_confirm()
	{
		testlog = report.createTest("Purchase product Test");
		
		String str=driver.findElement(confirm).getText();
		testlog.log(Status.INFO, "Order confirmation details are: ");
		testlog.log(Status.INFO, str);
		takeScrenShot("Confirmation.png");
		driver.findElement(ok).click();
	}
	
}
