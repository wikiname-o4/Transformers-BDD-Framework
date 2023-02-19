package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailSteps extends CommonUtility {

	private POMFactory factory = new POMFactory();

	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {

		String actualTitle = getTitle();
		String expectedTitle = "React App";
		Assert.assertEquals(expectedTitle, actualTitle);
		Assert.assertTrue(isElementDisplayed(factory.homePage().tekScoolLogo));
		logger.info("User is on retail website");
		logger.info("Actual title " + actualTitle + " Equals Expected Ttile " + expectedTitle);
	}

	@When("User search for {string} product")
	public void userSearchForProduct(String productValue) {
		sendText(factory.homePage().searchBar, productValue);
		click(factory.homePage().searchButton);
		logger.info("User searched for product " + productValue);
	}

	@Then("The product should be displayed")
	public void theProductShouldBeDisplayed() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().pokemonProductImage));
		logger.info("The product is displayed on the HomePage");
	}

	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().allIcon);
		logger.info("User clicked on All section");
	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> expectedSideBar = dataTable.asLists(String.class);

// Using List of WebElements for Assertion
		List<WebElement> actualSideBar = factory.homePage().sideBarElements;

		for (int i = 0; i < expectedSideBar.get(0).size(); i++) {
			Assert.assertEquals(actualSideBar.get(i).getText(), expectedSideBar.get(0).get(i));
			logger.info("expected " + actualSideBar.get(i).getText() + " is equal to actual "
					+ expectedSideBar.get(0).get(i));
		}

// Assertion of each element 1 by 1
//	    Assert.assertEquals(expectedSideBar.get(0).get(0), factory.homePage().electronicsSideBar.getText());
//	    logger.info("expected "+expectedSideBar.get(0).get(0) +" is equal to actual "+ factory.homePage().electronicsSideBar.getText());
//	    
//	    Assert.assertEquals(expectedSideBar.get(0).get(1), factory.homePage().computersSideBar.getText());
//	    logger.info("expected "+expectedSideBar.get(0).get(1) +" is equal to actual "+ factory.homePage().computersSideBar.getText());
//	    
//	    Assert.assertEquals(expectedSideBar.get(0).get(2), factory.homePage().smarthomeSideBar.getText());
//	    logger.info("expected "+expectedSideBar.get(0).get(2) +" is equal to actual "+ factory.homePage().smarthomeSideBar.getText());
//	    
//	    Assert.assertEquals(expectedSideBar.get(0).get(3), factory.homePage().sportsSideBar.getText());
//	    logger.info("expected "+expectedSideBar.get(0).get(3) +" is equal to actual "+ factory.homePage().sportsSideBar.getText());
//	    
//	    Assert.assertEquals(expectedSideBar.get(0).get(4), factory.homePage().automativeSideBar.getText());
//	    logger.info("expected "+expectedSideBar.get(0).get(4) +" is equal to actual "+ factory.homePage().automativeSideBar.getText());

	}

	@When("User on {string}")
	public void userOn(String department) {
		List<WebElement> sideBarOptions = factory.homePage().sideBarElements;
		for (WebElement option : sideBarOptions) {
// Temporary solution
			String el = option.getText();
			if (el.equals(department)) {
				click(option);
				try {
					logger.info("User clicked on " + el + " sidebar option");
				} catch (StaleElementReferenceException e) {

				}
				break;
			}
		}

	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> expectedDepartmentOptions = dataTable.asLists(String.class);
		List<WebElement> actualDepartmentOptions = factory.homePage().sideBarOptionElements;

		for (int i = 0; i < expectedDepartmentOptions.get(0).size(); i++) {
			for (WebElement dept : actualDepartmentOptions) {
				if (dept.getText().equals(expectedDepartmentOptions.get(0).get(i))) {
					Assert.assertTrue(isElementDisplayed(dept));
					logger.info("Department " + dept.getText() + " is present");
				}

			}
		}
	}

	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String category) {
		waitTillPresence(factory.homePage().allDepartmentDropDown);
		selectByVisibleText(factory.homePage().allDepartmentDropDown, category);
		logger.info("User changed the search category to " + category);

	}

	@When("User search for an item {string}")
	public void userSearchForAnItem(String itemValue) {
		sendText(factory.homePage().searchBar, itemValue);
		logger.info("User entered in the search bar an item value " + itemValue);
	}

	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.homePage().searchButton);
		logger.info("User clicked on search icon");
	}

	@When("User click on item")
	public void userClickOnItem() {
		click(factory.homePage().firstItemFound);
		logger.info("User clicked on found item");
	}

	@When("User select quantity {string}")
	public void userSelectQuantity(String quantity) {
		selectByValue(factory.homePage().quantityDropdown, quantity);
		logger.info("User selected the quantity " + quantity);
	}

	@When("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.homePage().addToCartButton);
		logger.info("User clicked on Add to Cart Button");

	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String cartIconQuantity) {
		Assert.assertEquals(factory.homePage().cartIconQuantity.getText(), cartIconQuantity);
		logger.info("The cart icon quantity changed to 2");
	}

	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.homePage().cartButton);
		logger.info("User clicked on cart button");
	}

	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.homePage().proceedToChekOutButton);
		logger.info("User clicked on Proceed to Checkout button");
	}

	@Then("User click Add a new address link for shipping address")
	public void userClickAddANewAddressLinkForShippingAddress() {
		click(factory.homePage().checkoutAddAddressButton);
		logger.info("User clicked on Add a new address button");
	}

	@Then("User click Add a Credit or Debit Card for Payment method")
	public void userClickAddACreditOrDebitCardForPaymentMethod() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitTillClickable(factory.homePage().checkoutAddCardButton);
		click(factory.homePage().checkoutAddCardButton);
		logger.info("User clicked on Add a Credit or Debit Card button");
	}

	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.homePage().placeYourOrderButton);
		logger.info("User clicked on Place Your Order Button");
	}

}
