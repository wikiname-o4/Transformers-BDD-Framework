package tek.sdet.framework.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailOrdersSteps extends CommonUtility {

	private POMFactory factory = new POMFactory();

	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(factory.homePage().ordersButton);
		logger.info("User clicked on Orders Button");
	}

	@When("User click on first order in list")
	public void userClickOnFirstOrderInList() {
// Select first "NOT CANCELLED" order
		for (int i = 0; i < factory.ordersPage().showHidebuttons.size(); i++) {
			if (factory.ordersPage().showHidebuttons.get(i).getText().equals("Show Details")) {
				click(factory.ordersPage().showHidebuttons.get(i));
			}
			turnOffImplicitWaits();
			if (factory.ordersPage().cancelTheOrderButtons.size() == 1) {
				break;
			}
		}
		turnOnImplicitWaits();

// Select first order

//		if (factory.ordersPage().firstOrderShowHideButton.getText().equals("Show Details")) {
//			click(factory.ordersPage().firstOrderShowHideButton);
//		}
		logger.info("User clicked on first order in list");

	}

	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		click(factory.ordersPage().firstCancelTheOrderButton);
		logger.info("User clicked on Cancel The Order Button");
	}

	@When("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String reasonValue) {
		selectByVisibleText(factory.ordersPage().cancelReasonDropdown, reasonValue);
		logger.info("User selected the reason " + reasonValue);
	}

	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.ordersPage().cancelReturnOrderSubmitButton);
		logger.info("User clicked on Cancel Order Button");
	}

	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String cancelMessageValue) {
		Assert.assertEquals(factory.ordersPage().cancelConfirmMessage.getText(), cancelMessageValue);
		logger.info("Cancellation message displayed: " + cancelMessageValue);
	}

	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(factory.ordersPage().firstReturnItemsButton);
		logger.info("User clicked on Return Items Button");
	}

	@When("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String returnReasonValue) {
		selectByVisibleText(factory.ordersPage().returnReasonDropdown, returnReasonValue);
		logger.info("User selected the return reason " + returnReasonValue);
	}

	@When("User select the drop off service {string}")
	public void userSelectTheDropOffService(String serviveValue) {
		selectByVisibleText(factory.ordersPage().dropOffServiceDropdown, serviveValue);
		logger.info("User selected the drop off service value " + serviveValue);
	}

	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(factory.ordersPage().cancelReturnOrderSubmitButton);
		logger.info("User clicked on Return Order Button");
	}

	@Then("a return message should be displayed {string}")
	public void aReturnMessageShouldBeDisplayed(String returnConfirmMessageValue) {
		Assert.assertEquals(factory.ordersPage().returnConfirmMessage.getText(), returnConfirmMessageValue);
		logger.info("Return confirmation message displayed " + returnConfirmMessageValue);
	}

	@When("User click on Review button")
	public void userClickOnReviewButton() {
		click(factory.ordersPage().firstReviewButton);
		logger.info("User clicked on Review Button");
	}

	@When("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String headlineValue, String commentValue) {
		sendText(factory.ordersPage().headlineField, headlineValue);
		sendText(factory.ordersPage().reviewCommentField, commentValue);
		logger.info("User entered headline and written review data");
	}

	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.ordersPage().addYourReviewButton);
		logger.info("User clicked on Add Your Review Button");
	}

}
