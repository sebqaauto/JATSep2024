package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/?locale=en_GB");
		Dimension dimension = new Dimension(430, 932);
		//driver.manage().window().setSize(dimension);
		//driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> urls = driver.findElements(By.xpath("//a[contains(@href,'http')]"));
		System.out.println(urls.size());
		String specificUrl = urls.get(1).getAttribute("href");
		//driver.navigate().to(specificUrl);
		Thread.sleep(Duration.ofSeconds(5));
		//WebElement dropDown = driver.findElement(By.id("day"));
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(Duration.ofSeconds(5));
		
		boolean state = driver.findElement(By.xpath("//div[@class='placeholder' and contains(text(),'First name')]")).isDisplayed();
		
		System.out.println(state);
		state = driver.findElement(By.id("fullname_error_msg")).isDisplayed();
		System.out.println("State of error message "+state);
		
	}

}
