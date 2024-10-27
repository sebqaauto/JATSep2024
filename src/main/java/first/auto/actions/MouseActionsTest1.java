package first.auto.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActionsTest1 {
	
	// Launch the browser
		WebDriver driver = new FirefoxDriver();
		String mac = "Mac";
		String ipad = "iPad";
		
		public void launchApp() {
			driver.get("https://www.apple.com/iphone/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println("This a sample text "+mac+" - continues ");
		}
		
		public void performMouseActions() throws InterruptedException {
			// String variables can be added to the xpath expression, becomes useful to handle dynamic elements
			WebElement macElement = driver.findElement(By.xpath("//span[text()='"+mac+"']"));
			WebElement iPadElement = driver.findElement(By.xpath("//span[text()='"+ipad+"']"));
			WebElement watchElement = driver.findElement(By.xpath("//span[text()='Watch']"));
			WebElement secondBuy = driver.findElement(By.xpath("//div[@data-unit-id='iphone-16-pro']//a[text()='Buy']"));
			WebElement footer = driver.findElement(By.id("ac-globalfooter"));
			WebElement iphoneSection = driver.findElement(By.xpath("//div[@data-unit-id='iphone-16']"));
			WebElement textSection = driver.findElement(By.xpath("//h2[text()='Get to know iPhone.']"));
			Actions action = new Actions(driver);
			
			// movetoElement is used to move to an element or hover over in the current view port 
			action.moveToElement(macElement).build().perform();
			Thread.sleep(Duration.ofSeconds(5));
			action.moveToElement(iPadElement).click().build().perform();
		
			
		}

		public static void main(String[] args) throws InterruptedException {
		MouseActionsTest1 mouseActions = new MouseActionsTest1();
		
		mouseActions.launchApp();
		mouseActions.performMouseActions();
	}

}
