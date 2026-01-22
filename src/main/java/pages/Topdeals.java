package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Topdeals {
	
	@FindBy(xpath = "(//a[normalize-space()='Top Deals'])[1]") private WebElement topdealink;
	@FindBy(xpath = "(//a[@role='button'])[4]") private WebElement secondlink;
	@FindBy(id = "page-menu") private WebElement pagesize;
	By productRows = By.xpath("//tbody//tr//td[1]");
							   //tbody/tr/td[1]
	
	By pricerows = By.xpath("//tbody/tr//td[2]");
	@FindBy(xpath = "//th[@aria-label='Veg/fruit name: activate to sort column ascending']") private WebElement headername;
	@FindBy(xpath = "(//th[@aria-label='Price: activate to sort column ascending'])[1]") private WebElement priceheader;
	@FindBy(xpath = "//th[@aria-label='Discount price: activate to sort column ascending']") private WebElement discountprice;
	WebDriver driver;
	WebDriverWait wait;
	public Topdeals(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver , this);
	}
	
	public void pefrom()
	{
		String mainwidow = driver.getWindowHandle();
		topdealink.click();
		@Nullable
		String title = driver.getTitle();
		Set<String> allwindows = driver.getWindowHandles();
		
		for(String handle : allwindows)
		{
			if (!handle.equals(mainwidow)) {
			
				driver.switchTo().window(handle);
				wait.until(ExpectedConditions.elementToBeClickable(secondlink));
				secondlink.click();
				WebElement send = driver.findElement(By.id("search-field"));
				send.sendKeys("Potato");
				
				List<WebElement> names = driver.findElements((productRows));
				for(WebElement text : names)
				{
					WebElement name = text.findElement(By.xpath("//td[normalize-space()='Potato']"));
					
					System.out.println(name.getText());
					WebElement price = driver.findElement(By.xpath("//td[normalize-space()='Potato']/following-sibling::td[1]"));
					
					System.out.println(price.getText());
					WebElement discount = driver.findElement(By.xpath("//td[normalize-space()='Potato']/following-sibling::td[2]"));
					System.out.println(discount.getText());
				}
				driver.navigate().refresh();
				wait.until(ExpectedConditions.elementToBeClickable(pagesize));
				Select select = new Select(pagesize);
				select.selectByIndex(2);
				
				wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productRows, 16));
			}
		}
	}
	public List<String> sort()
	{
		headername.click();
		List<WebElement> names = driver.findElements((productRows));
		List<String> list = new ArrayList<>();
		for(WebElement text : names)
		{
			list.add(text.getText());
		}
		return list;
	}
	
	public List<Integer> sortbyprice()
	{
		wait.until(ExpectedConditions.elementToBeClickable(priceheader));
		priceheader.click();
		List <Integer>list = new ArrayList<>();
		List<WebElement> prices = driver.findElements((pricerows));
		for(WebElement text :prices)
		{
			list.add(Integer.parseInt(text.getText()));
		}
		return list;
		}
	
	public List<Integer> discountprice()
	{
		discountprice.click();
		List<WebElement> pricecolumn = driver.findElements(By.xpath("//tbody/tr//td[3]"));
		
		List<Integer> List = new ArrayList<>();
		for(WebElement disprice : pricecolumn)
		{
			List.add(Integer.parseInt(disprice.getText()));
		}
		return List;
	}
}
