package first.auto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertHandlingTest {
	
	String baseUrl = "https://demoqa.com/alerts";
	WebDriver driver = new ChromeDriver();
	
	public void launchApp() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void addressSimpleAlert() throws InterruptedException {
		driver.findElement(By.id("alertButton")).click();
		//When an alert happen - should address it 
		Thread.sleep(4000);
		System.out.println("From Simple Alert "+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	public void addressConfirmAlert() throws InterruptedException {
		WebElement element = driver.findElement(By.id("confirmButton"));
		// JavaScriptExecutor will execute the commands in terms of Javascript, it is native to the browser and will works well.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		element.click();
		System.out.println("From Confirm Alert "+driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
	}
	
	public void addressPromptAlert() {
		driver.findElement(By.id("promtButton")).click();
		System.out.println("From Prompt Alert "+driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("TestUser@001");
		driver.switchTo().alert().accept();
	}

	public static void main(String[] args) throws InterruptedException {
	
		AlertHandlingTest alertTest = new AlertHandlingTest();
		alertTest.launchApp();
		alertTest.addressSimpleAlert();
		alertTest.addressConfirmAlert();
		alertTest.addressPromptAlert();

	}

}
