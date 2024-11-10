package first.auto.actions;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseActionsDragAndDrop {
	
	public String baseUrl = "https://artoftesting.com/samplesiteforselenium";
	
	WebDriver driver = new ChromeDriver();
	
	public void launchApp() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		handleCookie();
	}
	
	public void doMouseActions() throws InterruptedException {
		WebElement source = driver.findElement(By.id("myImage"));
		WebElement destination = driver.findElement(By.id("targetDiv"));
		// This scrolling is optional 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", destination);
		// Drag and Drop 
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
		long startingTime = System.currentTimeMillis();
		Thread.sleep(5000);
		long endingTime = System.currentTimeMillis();
		System.out.println("The time it waited is "+(startingTime - endingTime));
		WebElement doubClickButton = driver.findElement(By.id("dblClkBtn"));
		action.doubleClick(doubClickButton).build().perform();
	}
	
	public void handleCookie() {
		long startingTime = System.currentTimeMillis();
		List<WebElement> cookie = driver.findElements(By.xpath("//div[@id='qc-cmp2-ui']//button/span[text()='AGREE']"));
		long endingTime = System.currentTimeMillis();
		System.out.println("The time it waited to find the cookie element is  "+(startingTime - endingTime));
		System.out.println("Inside the cookie block the size of the list is " + cookie.size());
		if(cookie.size()>0) {
			cookie.get(0).click();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
			
		MouseActionsDragAndDrop mouseAction = new MouseActionsDragAndDrop();
		mouseAction.launchApp();
		mouseAction.doMouseActions();
	}

}




//WebElement cookieBanner = driver.findElement(By.id("qc-cmp2-ui"));
//if(cookieBanner.isDisplayed()) {
//	WebElement cookieElement = driver.findElement(By.xpath("//div[@id='qc-cmp2-ui']//button/span[text()='AGREE']"));
//	if(cookieElement.isDisplayed()) {
//		cookieElement.click();
//	}
//}