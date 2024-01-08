package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;

import base.Base;

public class Details extends Base
{
	String str,str1,str2;
	int cnt,cnt1;
	By product=By.xpath("//div[@class='inventory_item_name']");
	By getdetails=By.xpath("//div[@class='inventory_details_desc_container']");
	By backbtn=By.id("back-to-products");
	By add_cartbtn1=By.id("add-to-cart-sauce-labs-backpack");
	By add_cartbtn2=By.id("add-to-cart-sauce-labs-bike-light");
	By cartpg=By.xpath("//span[@class='title']");
	By delete=By.id("remove-sauce-labs-backpack");
	By cartlink=By.xpath("//a[@class='shopping_cart_link']");
	
	public void product()
	{
		driver.findElement(product).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//	code to read the product description 
	public void prod_details()
	{
		testlog = report.createTest("Product details Test");
	
		String str=driver.findElement(getdetails).getText();
		testlog.log(Status.INFO, str);
		
		driver.findElement(backbtn).click();
	}
	
	
//	code to add product to the cart
	public void add_to_cartbtn()
	{
		driver.findElement(add_cartbtn1).click();
		
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        driver.findElement(add_cartbtn2).click();
   
	}
	
	
	public void validate_cartpg()
	{
		
		if(driver.findElement(cartpg).isDisplayed())
		{
			System.out.println("Cart page is displayed");
		}
		else
		{
			System.out.println("Cart page is not displayed");
		}
	}
	
//	code to check the status of the cart(if product are added or not)
	public void cart_status()
	{
		testlog = report.createTest("Add to cart Test");
	
		driver.findElement(cartlink).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		takeScrenShot("Cart.png");
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='cart_item']"));
		cnt=rows.size();
		if(cnt>=1)
		{
			testlog.log(Status.PASS, "Product is added in the cart");
		}
		else
		{
			testlog.log(Status.FAIL, "Product is not added in the cart");
		}
	}
	
//	code to validate the cart page
	public void validate_cart()
	{
		driver.findElement(cartlink).click();
	}
	
//	code to delete the product added in the cart
	public void delete_product()
	{
		driver.findElement(delete).click();
	}
	
//	code to check the status of cart once the product is deleted
	public void del_cart_status()
	{
		testlog = report.createTest("Delete from cart Test");

		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='cart_item']"));
		cnt1=rows.size();
		if(cnt1==1)
		{
			testlog.log(Status.PASS, "Product is deleted from the cart");
		}
		else
		{
			testlog.log(Status.FAIL, "Product is not deleted from the cart");
		}
	}
}
