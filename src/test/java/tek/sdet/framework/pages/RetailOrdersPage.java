package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailOrdersPage extends BaseSetup {

	public RetailOrdersPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "(//p[@class='order__header-btn'])[1]")
	public WebElement firstOrderShowHideButton;

	@FindBy(xpath = "(//button[@id='cancelBtn'])[1]")
	public WebElement firstCancelTheOrderButton;

	@FindBy(xpath = "//select[@id='reasonInput']")
	public WebElement cancelReasonDropdown;

	@FindBy(css = "#orderSubmitBtn")
	public WebElement cancelReturnOrderSubmitButton;

	@FindBy(xpath = "//div[@class='cancel__confirm-message']")
	public WebElement cancelConfirmMessage;

	@FindBy(xpath = "(//button[@id='returnBtn'])[1]")
	public WebElement firstReturnItemsButton;

	@FindBy(css = "#reasonInput")
	public WebElement returnReasonDropdown;

	@FindBy(css = "#dropOffInput")
	public WebElement dropOffServiceDropdown;
	
	@FindBy(xpath = "//div[@class='return__confirm-message']")
	public WebElement returnConfirmMessage;
	
	
	@FindBy(xpath="(//button[@id='reviewBtn'])[1]")
	public WebElement firstReviewButton;
	
	@FindBy(css="#headlineInput")
	public WebElement headlineField;
	
	@FindBy(css="#descriptionInput")
	public WebElement reviewCommentField;
	
	@FindBy(css="#reviewSubmitBtn")
	public WebElement addYourReviewButton;
}
