package basepackage;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import files.Files;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass implements Constant{
	protected WebDriver driver;
	@BeforeMethod
	@Parameters("browser")
	public void setup( String browser) throws IOException
	{
		Files fs = new Files();
		String url = fs.config(Config, "url");
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty(MSEDGEKey, MSEDGEDriverPath);
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
		driver.get(url);
	}
	
	public void teardown()
	{
		if (driver !=null) {
			driver.quit();
		}
	}
}
