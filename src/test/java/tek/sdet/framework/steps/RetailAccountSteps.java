package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailAccountSteps extends CommonUtility {
	

	private POMFactory factory = new POMFactory();
	


	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.homePage().accountOption);
		logger.info("User clicked on Account option");
	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String nameValue, String phoneValue) {
		clearTextUsingSendKeys(factory.accountPage().profileNameInputField);
		sendText(factory.accountPage().profileNameInputField, nameValue);
		clearTextUsingSendKeys(factory.accountPage().profilePhoneNumberField);
		sendText(factory.accountPage().profilePhoneNumberField, phoneValue);
		logger.info("User updated name to " + nameValue + " and phone number to " + phoneValue);
	}

	@When("User click on Update Button")
	public void userClickOnUpdateButton() {
		click(factory.accountPage().profileUpdateButton);
		logger.info("User clicked on Update Button");
	}

	@Then("User profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.accountPage().personalInfoUpdateSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().personalInfoUpdateSuccessMessage));
		logger.info("Profile information updated succesfully");
	}

	@When("User enter below information")
	public void userEnterBelowInformation(DataTable dataTable) {
		List<Map<String, String>> passwordInformation = dataTable.asMaps(String.class, String.class);

		sendText(factory.accountPage().profilePreviousPasswordField,
				passwordInformation.get(0).get("previousPassword"));
		sendText(factory.accountPage().profileNewPasswordField, passwordInformation.get(0).get("newPassword"));
		sendText(factory.accountPage().profileNewPassConfimField, passwordInformation.get(0).get("confirmPassword"));
		
		logger.info("User entered old password '" + passwordInformation.get(0).get("previousPassword")
				+ "' and new password '" + passwordInformation.get(0).get("newPassword") + "' and confirm password '"
				+ passwordInformation.get(0).get("confirmPassword"));

	}

	@When("User click on Change Password button")
	public void userClickOnChangePasswordButton() {
		click(factory.accountPage().profileChangePasswordButton);
		logger.info("User clicked on " + factory.accountPage().profileChangePasswordButton.getText());
	}

//	Old Version
//	@Then("a message should be displayed {string}")
//	public void aMessageShouldBeDisplayed(String messageValue) {
//		waitTillPresence(factory.accountPage().passwordUpdateSuccessMessage);
//		Assert.assertTrue(isElementDisplayed(factory.accountPage().passwordUpdateSuccessMessage));
//		logger.info("profile password updated succesfully");
//	}

//New Version - multi functional	
	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String messageValue) {
		waitTillPresence(factory.accountPage().messageBar);
		Assert.assertEquals(messageValue, factory.accountPage().messageBar.getText());
		logger.info(messageValue);
	}

	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.accountPage().addPaymentLink);
		logger.info("User clicked on Add a payment method link");
	}

	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> creditCardInformation = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().cardNumberInput, creditCardInformation.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOnCardInput, creditCardInformation.get(0).get("nameOnCard"));
		selectByValue(factory.accountPage().cardExpirationMonthInput,
				creditCardInformation.get(0).get("expirationMonth"));
		selectByValue(factory.accountPage().cardExpirationYearInput,
				creditCardInformation.get(0).get("expirationYear"));
		sendText(factory.accountPage().cardSecurityCodeInput, creditCardInformation.get(0).get("securityCode"));
		logger.info("User filled up the credit card information");
	}

	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.accountPage().addYourCardButton);
		logger.info("User clicked on Add Your card button");
	}

	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.accountPage().firstCardSelectButton);
		logger.info("User selected first card from the list");
		click(factory.accountPage().editCardButton);
		logger.info("User clicked on Edit button");
	}

	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> cardUpdateInformation = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(factory.accountPage().cardNumberInput);
		sendText(factory.accountPage().cardNumberInput, cardUpdateInformation.get(0).get("cardNumber"));
		clearTextUsingSendKeys(factory.accountPage().nameOnCardInput);
		sendText(factory.accountPage().nameOnCardInput, cardUpdateInformation.get(0).get("nameOnCard"));
		selectByValue(factory.accountPage().cardExpirationMonthInput,
				cardUpdateInformation.get(0).get("expirationMonth"));
		selectByValue(factory.accountPage().cardExpirationYearInput,
				cardUpdateInformation.get(0).get("expirationYear"));
		clearTextUsingSendKeys(factory.accountPage().cardSecurityCodeInput);
		sendText(factory.accountPage().cardSecurityCodeInput, cardUpdateInformation.get(0).get("securityCode"));
		logger.info("User filled up the credit card information");

	}

	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.accountPage().updateYourCardButton);
		logger.info("User Clicked on Update Your Card button");
	}

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.accountPage().firstCardSelectButton);
		logger.info("User selected first card from the list");
		click(factory.accountPage().removeCardButton);
		logger.info("User clicked on remove button");
	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {

//////////////////////////    Temporary solution
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
/////////////////////////
		Assert.assertTrue(isElementDisplayed(factory.accountPage().cardNumberInput));
		logger.info("Card removed successfully");
	}

	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.accountPage().addAddressOption);
		logger.info("User clicked on Add Address option");
	}

	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> newAddressData = dataTable.asMaps(String.class, String.class);
		waitTillPresence(factory.accountPage().newAddressPopup);
		selectByValue(factory.accountPage().newAddressSelectCountryDropdown, newAddressData.get(0).get("country"));
		clearTextUsingSendKeys(factory.accountPage().newAddressFullNameField);
		sendText(factory.accountPage().newAddressFullNameField, newAddressData.get(0).get("fullName"));
		clearTextUsingSendKeys(factory.accountPage().newAddressPhoneNumberField);
		sendText(factory.accountPage().newAddressPhoneNumberField, newAddressData.get(0).get("phoneNumber"));
		clearTextUsingSendKeys(factory.accountPage().newAddressStreetField);
		sendText(factory.accountPage().newAddressStreetField, newAddressData.get(0).get("streetAddress"));
		clearTextUsingSendKeys(factory.accountPage().newAddressAptField);
		sendText(factory.accountPage().newAddressAptField, newAddressData.get(0).get("apt"));
		clearTextUsingSendKeys(factory.accountPage().newAddressCityField);
		sendText(factory.accountPage().newAddressCityField, newAddressData.get(0).get("city"));
		selectByValue(factory.accountPage().newAddressStateDropdown, newAddressData.get(0).get("state"));
		clearTextUsingSendKeys(factory.accountPage().newAddressZipCodeField);
		sendText(factory.accountPage().newAddressZipCodeField, newAddressData.get(0).get("zipCode"));
		logger.info("User entered new address information");

	}
	

	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.accountPage().newAddressAddYourAddressButton);
		logger.info("User clicked on Add Your Address button");
	}

	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(factory.accountPage().editAddressButton);
		logger.info("User clicked on Edit button for last address in list");
	}

	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(factory.accountPage().updateYourAddressButton);
		logger.info("User clicked on Update Your Address button");
	}
	
	
	public static int addressesCount;

	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		addressesCount=factory.accountPage().addressBoxes.size();
		click(factory.accountPage().removeAddressButton);
		logger.info("User clicked on Remove button on the last address field");
	}

	
//////////////////////////  Temporary solution 
	
	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		turnOffImplicitWaits();
		Assert.assertEquals(factory.accountPage().addressBoxes.size(), addressesCount-1);
		turnOnImplicitWaits();
		logger.info("Address detail succesfully removed");
		
	}
	

}
