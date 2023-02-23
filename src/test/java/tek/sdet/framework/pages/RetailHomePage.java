package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup {

	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	// syntax for finding UI elements and storing them in POM classes
	// @FindBy(locatortype = "value)
	// public WebElement nameOfElement

	@FindBy(xpath = "//a[text()='TEKSCHOOL']")
	public WebElement tekScoolLogo;

	@FindBy(id = "search")
	public WebElement allDepartmentDropDown;

	@FindBy(css = "#searchInput")
	public WebElement searchBar;

	@FindBy(xpath = "//button[@id='searchBtn']")
	public WebElement searchButton;

	@FindBy(linkText = "Sign in")
	public WebElement signInButton;

	@FindBy(id = "cartBtn")
	public WebElement cartButton;

	@FindBy(css = "#orderLink")
	public WebElement ordersButton;

	@FindBy(xpath = "//img[contains(@alt, 'Pokemon')]")
	public WebElement pokemonProductImage;

	@FindBy(xpath = "//a[text()='Account']")
	public WebElement accountOption;

	@FindBy(id = "hamburgerBtn")
	public WebElement allIcon;

	@FindBy(xpath = "//div[@class='sidebar_content-item']/span")
	public List<WebElement> sideBarElements;

	@FindBy(xpath = "//div[@class='sidebar_content-item']/span")
	public List<WebElement> sideBarOptionElements;

	@FindBy(xpath = "//span[text()='Electronics']")
	public WebElement electronicsSideBar;

	@FindBy(xpath = "//span[text()='Computers']")
	public WebElement computersSideBar;

	@FindBy(xpath = "//span[text()='Smart Home']")
	public WebElement smarthomeSideBar;

	@FindBy(xpath = "//span[text()='Sports']")
	public WebElement sportsSideBar;

	@FindBy(xpath = "//span[text()='Automative']")
	public WebElement automativeSideBar;

	@FindBy(xpath = "//div[@class='products__layout'][1]")
	public WebElement firstItemFound;

	@FindBy(xpath = "//select[@class='product__select']")
	public WebElement quantityDropdown;

	@FindBy(css = "#addToCartBtn")
	public WebElement addToCartButton;

	@FindBy(css = "#cartQuantity")
	public WebElement cartIconQuantity;

	@FindBy(css = "#proceedBtn")
	public WebElement proceedToChekOutButton;

	@FindBy(css = "#addAddressBtn")
	public WebElement checkoutAddAddressButton;

	@FindBy(css = "#addPaymentBtn")
	public WebElement checkoutAddCardButton;

	@FindBy(xpath = "//button[@id='placeOrderBtn']")
	public WebElement placeYourOrderButton;
}
