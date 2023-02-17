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
	
	@FindBy(id ="personalUpdateBtn")
	public WebElement profileUpdateButton;
	
	@FindBy(xpath="//div[text()='Personal Information Updated Successfully']")
    public WebElement personalInfoUpdateSuccessMessage;
	
	@FindBy(id="previousPasswordInput")
	public WebElement profilePreviousPasswordField;
	
	@FindBy(xpath ="//input[@id='newPasswordInput']")
	public WebElement profileNewPasswordField;
	
	@FindBy(css ="#confirmPasswordInput")
	public WebElement profileNewPassConfimField;
	
	@FindBy(xpath="//button[@id='credentialsSubmitBtn']")
	public WebElement profileChangePasswordButton;
}
