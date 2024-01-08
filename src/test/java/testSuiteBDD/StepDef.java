package testSuiteBDD;

import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Details;
import pages.Home1;
import pages.Purchase;

public class StepDef
{
	Home1 h=new Home1();
	Details d= new Details();
	Purchase p=new Purchase();
	Base b=new Base();
	
	@Given("^user has opened browser$")
    public void user_has_opened_browser() throws Throwable {
		h.openURL();
    }

    @Then("^validate home page$")
    public void validate_home_page() throws Throwable {
    	h.validate_hmpg();
    }
    
    @When("^user enter invalid username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enter_invalid_username_as_something_and_password_as_something(String username, String password) throws Throwable {
     h.invalid_login(username, password);
    }

    @Then("^login should be unsuccessful$")
    public void login_should_be_unsuccessful() throws Throwable {
     h.login_status();
    }
    
    @When("^user enter valid username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enter_valid_username_as_something_and_password_as_something(String username1, String password1) throws Throwable {
    	h.valid_login(username1, password1);
    }

    @Then("^login should be successful$")
    public void login_should_be_successful() throws Throwable {
    	h.login_status();
    }
    
    @Given("^user is on product page$")
    public void user_is_on_product_page() throws Throwable {
       h.validate_prodpg();
    }

    @Then("^read the product list$")
    public void read_the_product_list() throws Throwable {
       h.read_products();
    }
    
    @When("^user clicks on any product$")
    public void user_clicks_on_any_product() throws Throwable {
      d.product();
    }

    @Then("^read the product details$")
    public void read_the_product_details() throws Throwable {
      d.prod_details();
    }
    
    @When("^clicks on add to cart button$")
    public void clicks_on_add_to_cart_button() throws Throwable {
    	d.add_to_cartbtn();
    }

    @Then("^product is added to cart$")
    public void product_is_added_to_cart() throws Throwable {
    	d.cart_status();
    }
    
    @Given("^user is on the cart page$")
    public void user_is_on_the_cart_page() throws Throwable {
    	d.validate_cartpg();
    }

    @When("^user clicks on delete$")
    public void user_clicks_on_delete() throws Throwable {
    	d.delete_product();
    }

    @Then("^product is removed from the cart$")
    public void product_is_removed_from_the_cart() throws Throwable {
    	d.del_cart_status();
    }

    @When("^clicks on checkout button,enters required details & clicks on Finish button$")
    public void clicks_on_checkout_buttonenters_required_details_clicks_on_finish_button() throws Throwable {
    	p.place_order();
    }

    @Then("^confirmation details are displayed$")
    public void confirmation_details_are_displayed() throws Throwable {
    	p.purchase_confirm();
    }

}
