package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {

	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//*[@id='profileImage']")
	public WebElement profileImage;

	@FindBy(xpath = "//input[@id='nameInput']")
	public WebElement profileNameInputField;

	@FindBy(css = "#personalPhoneInput")
	public WebElement profilePhoneNumberField;

	@FindBy(id = "personalUpdateBtn")
	public WebElement profileUpdateButton;

	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement personalInfoUpdateSuccessMessage;

	@FindBy(id = "previousPasswordInput")
	public WebElement profilePreviousPasswordField;

	@FindBy(xpath = "//input[@id='newPasswordInput']")
	public WebElement profileNewPasswordField;

	@FindBy(css = "#confirmPasswordInput")
	public WebElement profileNewPassConfimField;

	@FindBy(xpath = "//button[@id='credentialsSubmitBtn']")
	public WebElement profileChangePasswordButton;

	@FindBy(xpath = "//div[text()='Password Updated Successfully']")
	public WebElement passwordUpdateSuccessMessage;

	@FindBy(xpath = "//p[contains(text(),'Add a payment method')]")
	public WebElement addPaymentLink;

	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberInput;

	@FindBy(css = "#nameOnCardInput")
	public WebElement nameOnCardInput;

	@FindBy(xpath = "//select[@id='expirationMonthInput']")
	public WebElement cardExpirationMonthInput;

	@FindBy(css = "#expirationYearInput")
	public WebElement cardExpirationYearInput;

	@FindBy(xpath = "//input[@id='securityCodeInput']")
	public WebElement cardSecurityCodeInput;

	@FindBy(css = "#paymentSubmitBtn")
	public WebElement addYourCardButton;

	@FindBy(xpath = "//div[text()='Payment Method added sucessfully']")
	public WebElement paymentAddedSuccesfullyMessage;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[last()]")
	public WebElement messageBar;

	@FindBy(xpath = "//div[contains(@class, 'false account__payment-item')][1]")
	public WebElement firstCardSelectButton;

	@FindBy(xpath = "//button[contains(@class, 'text-blue') and contains(text(), 'Edit')]")
	public WebElement editCardButton;

	@FindBy(xpath = "//button[contains(@class, 'text-blue') and contains(text(), 'remove')]")
	public WebElement removeCardButton;

	@FindBy(xpath = "//button[@id='paymentSubmitBtn']")
	public WebElement updateYourCardButton;

	@FindBy(xpath = "//p[contains(text(),'Add Address')]")
	public WebElement addAddressOption;

	@FindBy(xpath = "//select[@id='countryDropdown']")
	public WebElement newAddressSelectCountryDropdown;

	@FindBy(css = "#fullNameInput")
	public WebElement newAddressFullNameField;

	@FindBy(css = "#phoneNumberInput")
	public WebElement newAddressPhoneNumberField;

	@FindBy(css = "#streetInput")
	public WebElement newAddressStreetField;

	@FindBy(css = "#apartmentInput")
	public WebElement newAddressAptField;

	@FindBy(css = "#cityInput")
	public WebElement newAddressCityField;

	@FindBy(xpath = "//select[@class='account__address-new-dropdown' and @name='state']")
	public WebElement newAddressStateDropdown;

	@FindBy(xpath = "//input[@id='zipCodeInput']")
	public WebElement newAddressZipCodeField;

	@FindBy(xpath = "//button[@id='addressBtn']")
	public WebElement newAddressAddYourAddressButton;

	@FindBy(css = "#addressBtn")
	public WebElement updateYourAddressButton;

	@FindBy(xpath = "//div[@class='account__address-single'][1]")
	public WebElement addressesBox;

	@FindBy(xpath = "//div[@class='account__address-single'][last()]//button[@class='account__address-btn' and text()='Edit']")
	public WebElement editAddressButton;

	@FindBy(xpath = "//div[@class='account__address-single'][last()]//button[@class='account__address-btn' and text()='Remove']")
	public WebElement removeAddressButton;

}
