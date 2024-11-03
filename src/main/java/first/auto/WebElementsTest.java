package first.auto;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElementsTest {
	// Radio buttons and check boxes 
	
public String baseUrl = "https://artoftesting.com/samplesiteforselenium";
	
	WebDriver driver = new ChromeDriver();
	
	public void launchApp() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		handleCookie();
	}
	
	public void interactWithRadioButton() {
		driver.findElement(By.id("female")).click();
	}
	
	public void interactWithCheckBox() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.className("Automation")).click();
	}
	
	public void handleDropDowns() throws InterruptedException {
		// Select is a class in Selenium that supports drop down interaction 
		// Methods supported by it are selectByValue(), selectByIndex(), selectByVisibleText().
		WebElement dropDown = driver.findElement(By.id("testingDropdown"));
		Select select = new Select(dropDown);
		select.selectByValue("Manual");
		Thread.sleep(4000);
		select.selectByVisibleText("Performance Testing");
		Thread.sleep(4000);
		//select.deselectByVisibleText("Performance Testing");
	}
	
	public void handleCookie() {
		long startingTime = System.currentTimeMillis();
		List<WebElement> cookie = driver.findElements(By.xpath("//div[@id='qc-cmp2-ui']//button/span[text()='AGREE']"));
		long endingTime = System.currentTimeMillis();
		System.out.println("The time it waited to find the cookie element is  "+(startingTime - endingTime));
		System.out.println("Inside the cookie block the size of the list is " + cookie.size());
		if(cookie.size()>0) {
			System.out.println("Inside the cookie block > If Condition ");
			cookie.get(0).click();
		}
	}
	

	public static void main(String[] args) throws InterruptedException {
		WebElementsTest object = new WebElementsTest();
		object.launchApp();
		object.interactWithRadioButton();
		object.interactWithCheckBox();
		object.handleDropDowns();

	}

}
