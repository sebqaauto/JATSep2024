package first.auto;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FBTestCookie {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");		

		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		// Get the title and url of the current window using the Browser method

		List<WebElement> cookie = driver.findElements(By.xpath("//div[@tabindex='0']//span[contains(text(),'Allow all cookies')]"));
		System.out.println("Before Manual interaction The number of elements are "+cookie.size());
		// Use WebElement methods to interact on the web elements of the page
		//List<WebElement> cookie = driver.findElements(By.xpath("//div[@tabindex='0']//span[contains(text(),'Allow all cookies')]"));
		Thread.sleep(Duration.ofSeconds(5));
		//driver.findElement(By.xpath("//div[@tabindex='0']//span[contains(text(),'Allow all cookies')]")).click();
		cookie = driver.findElements(By.xpath("//div[@tabindex='0']//span[contains(text(),'Allow all cookies')]"));
		System.out.println("After manual interaction The number of elements are "+cookie.size());
		if(cookie.size()>0) {
			cookie.get(0).click();
		}
		
		

	}

}
