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

public class Cart {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath = "(//img[@alt='Cart'])[1]") private WebElement cartbutton;
	
	public Cart(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver , this);
	}
	public void qty()
	{
		cartbutton.click();
		List<WebElement> element = driver.findElements(By.xpath("(//div[@class='product-info'])"));
		for (int i = 1; i < element.size(); i++) {
			WebElement products = driver.findElement(By.xpath("(//div[@class='product-info'])['"+i+"']"));
			wait.until(ExpectedConditions.visibilityOf(products));
			System.out.println(products.getText());
		}
	}
}
