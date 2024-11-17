package first.auto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTest1 {
	
	public String baseUrl = "https://www.hyrtutorials.com/p/waits-demo.html";
	long startTime, endTime;

	WebDriver driver = new ChromeDriver();
	
	public void launchApp() {
		startTime = System.currentTimeMillis(); // 1000 ms is 1 second 
		driver.get(baseUrl); // Page Load is complete - 300 seconds 
		endTime = System.currentTimeMillis();
		System.out.println("The time taken for the page to load "+ (endTime - startTime) + " ms");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//p[text()='Consent']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6)); // Implicit wait should not be changed, then bring in explicit wait 
	}
	
	public void textBoxInteraction_1() {
		startTime = System.currentTimeMillis();
		driver.findElement(By.id("btn1")).click(); // By default findElement() will wait for 0ms;
		endTime = System.currentTimeMillis();
		System.out.println("The time taken for the findElement method to find is button -- "+ (endTime - startTime) + " ms");
		startTime = System.currentTimeMillis();
		driver.findElement(By.id("txt1")).sendKeys("First Text Box");
		endTime = System.currentTimeMillis();
		System.out.println("The time taken for the findElement method to find is -- "+ (endTime - startTime) + " ms");
	}
	
	public void textBoxInteraction_2() {
		startTime = System.currentTimeMillis();
		driver.findElement(By.id("btn2")).click();
		endTime = System.currentTimeMillis();
		System.out.println("The time taken for the findElement method to find is button -- "+ (endTime - startTime) + " ms");
		startTime = System.currentTimeMillis();
		//Explicit wait should be always greater than our ImplicitWait
		WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(12));
		wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt2")));// this visibility will happen every 500ms 
		
		driver.findElement(By.id("txt2")).sendKeys("Second Text Box");
		endTime = System.currentTimeMillis();
		System.out.println("The time taken for the findElement method to find is -- "+ (endTime - startTime) + " ms");
	}
	
	public void fluentWaitTest() {
		
		startTime = System.currentTimeMillis();
		driver.findElement(By.id("btn2")).click();
		endTime = System.currentTimeMillis();
		System.out.println("The time taken for the findElement method to find is button -- "+ (endTime - startTime) + " ms");
		startTime = System.currentTimeMillis();
		// Fluent Wait - Explicit Wait - it comes with polling frequency, and can ignore exception while it waits for the Expected conditions to appear 
		
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		fluentWait.withTimeout(Duration.ofSeconds(11)).pollingEvery(Duration.ofMillis(100)).ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt2")));
		
		driver.findElement(By.id("txt2")).sendKeys("Second Text Box");
		endTime = System.currentTimeMillis();
		System.out.println("The time taken for the findElement method to find is -- "+ (endTime - startTime) + " ms");
		
	}
	

	public static void main(String[] args) {
		
		WaitTest1 test = new WaitTest1();
		test.launchApp();
		test.textBoxInteraction_1();
		//test.textBoxInteraction_2();
		test.fluentWaitTest();

	}

}
