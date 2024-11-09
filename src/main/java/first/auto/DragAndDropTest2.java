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
	
	public void doDragAndDropOnPhotoManagerTab() throws InterruptedException {
		Thread.sleep(4000);
		WebElement frameElement = driver.findElement(By.xpath("//div[@rel-title='Photo Manager']//iframe[contains(@class,'demo-frame')]"));
		driver.switchTo().frame(frameElement);
		WebElement source = driver.findElement(By.xpath("//img[contains(@alt,'High Tatras')]"));
		WebElement destination = driver.findElement(By.id("trash"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
		// Once all actions and validations are complete, switch back to the parent DOM or the default DOM 
		driver.switchTo().defaultContent();
	}
	
	public void doDragAndDropOnAcceptElementsTab() {
		driver.findElement(By.id("Accepted Elements")).click();
		WebElement secondFrame = driver.findElement(By.xpath("//div[@rel-title='Accepted Elements']//iframe[contains(@class,'demo-frame')]"));
		driver.switchTo().frame(secondFrame);
		// Once you switch to the iFrame, then the driver only looks for the element inside the iFrame
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
		driver.switchTo().defaultContent();
		
	}

	public static void main(String[] args) throws InterruptedException {
		DragAndDropTest2 ddTest = new DragAndDropTest2();
		ddTest.launchApp();
		ddTest.doDragAndDropOnPhotoManagerTab();
		ddTest.doDragAndDropOnAcceptElementsTab();
	}

}
