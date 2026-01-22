package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Landing_Page {
	int value;
	//@FindBy(xpath = "//div[@class='products']//h4[@class='product-name']") private List<WebElement> productnames;
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath = "(//img[@alt='Cart'])[1]") private WebElement cartbutton;
	public Landing_Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver , this);
	}




	public void plus() {

	    List<WebElement> products = driver.findElements(By.xpath("//div[@class='product']"));

	    for (WebElement product : products) {

	        WebElement plus = product.findElement(
	            By.xpath(".//a[@class='increment' and normalize-space()='+']")
	        );

	        // increase quantity by 3
	        for (int i = 0; i < 3; i++) {
	            wait.until(ExpectedConditions.elementToBeClickable(plus));
	            plus.click();
	        }

	        WebElement addToCart = product.findElement(
	            By.xpath(".//button[normalize-space()='ADD TO CART']")
	        );
	        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
	        addToCart.click();
	    }
	}


}
