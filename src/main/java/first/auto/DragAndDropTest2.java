package first.auto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest2 {
	
	public String baseUrl = "https://www.globalsqa.com/demo-site/draganddrop/";
	
	WebDriver driver = new ChromeDriver();
	
	public void launchApp() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class='fc-dialog-container']//button/p[text()='Consent']")).click();
	}
	
	public void doDragAndDrop() throws InterruptedException {
		Thread.sleep(4000);
		WebElement frameElement = driver.findElement(By.xpath("//div[@rel-title='Photo Manager']//iframe[contains(@class,'demo-frame')]"));
		driver.switchTo().frame(frameElement);
		WebElement source = driver.findElement(By.xpath("//img[contains(@alt,'High Tatras')]"));
		WebElement destination = driver.findElement(By.id("trash"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		DragAndDropTest2 ddTest = new DragAndDropTest2();
		ddTest.launchApp();
		ddTest.doDragAndDrop();

	}

}
