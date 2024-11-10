package first.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoFrameTest {
	
	public String baseUrl = "https://jqueryui.com/datepicker/";
	int day = 22;
	
WebDriver driver = new ChromeDriver();
	
	public void launchApp() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void switchToFrame() {
		WebElement frameElement = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameElement);
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//a[@data-date='" +day+ "']")).click();
		
	}

	public static void main(String[] args) {
		
		DemoFrameTest test = new DemoFrameTest();
		test.launchApp();
		test.switchToFrame();
	}

}
