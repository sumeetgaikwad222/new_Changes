package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Searchresult {
	@FindBy(xpath = "(//input[@placeholder='Search for Vegetables and Fruits'])[1]") private WebElement searchbox;
	
	private By pro = By.xpath( "//div[@class='product']");

	WebDriver driver;
	WebDriverWait wait;
	public Searchresult(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver , this);
	}
	
	public void search()
	{
		String[] productnames = {"Walnuts"};
		searchbox.sendKeys(productnames);
		WebElement pr = driver.findElement(pro);
		wait.until(ExpectedConditions.visibilityOf(pr));
		System.out.println("product name is "+ pr);
	}
}
