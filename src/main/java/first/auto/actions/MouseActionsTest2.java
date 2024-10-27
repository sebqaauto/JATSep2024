package first.auto.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActionsTest2 {
	
	// Launch the browser
			WebDriver driver = new FirefoxDriver();
			String mac = "Mac";
			String ipad = "iPad";
			
			public void launchApp() {
				driver.get("https://www.amazon.com/Apple-iPhone-XR-Fully-Unlocked/dp/B07P6Y7954?th=1");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				System.out.println("This a sample text "+mac+" - continues ");
			}
			
			public void performMouseAction() {
				
			WebElement element= driver.findElement(By.xpath("//h3[text()=' Purchase options and add-ons ']"));
			WebElement Gb128Element = driver.findElement(By.xpath("//p[text()='128GB']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", Gb128Element);
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			
			}

	public static void main(String[] args) {
		
		MouseActionsTest2 mouseaction = new MouseActionsTest2();
		mouseaction.launchApp();
		mouseaction.performMouseAction();
		
	}

}
