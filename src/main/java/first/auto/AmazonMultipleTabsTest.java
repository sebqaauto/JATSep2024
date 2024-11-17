package first.auto;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonMultipleTabsTest {
	
	public String baseUrl = "https://www.amazon.in/";
	public String baseUrl2 = "https://www.flipkart.com/";
	String parentWindow;
	String secondWindow;
	String thridWindow;
	Set<String> allWindowHandles;
	
	WebDriver driver = new ChromeDriver();
	
	public void launchApp() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void productSearch(String searchText) {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchText);
		driver.findElement(By.id("nav-search-submit-button")).click();
		//On clicking this element, it opens a new tab 
		driver.findElement(By.xpath("//div[@data-index='3']//*[@data-cy='image-container']//img")).click();
		String title = driver.getTitle();
		System.out.println("The driver is at page -- "+title);
	}
	
	//By default the drive points to the parent window
	public void getAllWindowHandles() {
		//To get the current window handle 
		parentWindow = driver.getWindowHandle();
		System.out.println("From the getWindowHandle method  -- "+parentWindow);
		//to get all the window handles opened by the browser 
		allWindowHandles = driver.getWindowHandles();
		//For Each - 1) Collection which I need to iterate 2) Temp Variable that matches the data type of the collection object
		for(String temp :allWindowHandles) {
			System.out.println("With the help of getWindowHandles method -- "+temp);
		}
		
	}

	
	public void switchToNewTab() {
		for(String temp :allWindowHandles) {
			// Parent - 2D4AE0EED4556ADA272B60A20483C7A1
			// NewTab - BBFA0E590F7C993CE87E14CDCB936A8A
			//Condition to check the temp should not be euqal to parentWindow
			if(!temp.equals(parentWindow)) {
				// instructing the driver to go to the non parent window
				driver.switchTo().window(temp);
				secondWindow = driver.getWindowHandle();
				System.out.println("From the if block "+temp);
				System.out.println("The current url "+driver.getCurrentUrl());
				System.out.println("The current title "+driver.getTitle());
			}
		}
		
	}
	
	public void openNewTab() {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.snapdeal.com/");
		System.out.println(driver.getTitle());
	}
	
	public void goToSecondWindow() {
		driver.switchTo().window(secondWindow);
		System.out.println("From the "+secondWindow+ " title is -- "+driver.getTitle());
		driver.close();
		driver.quit();
	}
	
	public void openNewWindow() {
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to(baseUrl2);
		thridWindow = driver.getWindowHandle();
		System.out.println("After opening new Window the title is --- "+driver.getTitle());
	}
	
	public void getPriceFromNewTab() {
		String price = driver.findElement(By.xpath("//*[@id='corePriceDisplay_desktop_feature_div']//*[@class='aok-offscreen']")).getText();
		System.out.println("Now the price of the product from the newly opened tab is -- "+price);
	}

	public static void main(String[] args) {
		AmazonMultipleTabsTest amz = new AmazonMultipleTabsTest();
		amz.launchApp();
		amz.productSearch("iPhone 16");
		amz.getAllWindowHandles();
		amz.switchToNewTab();
		amz.getPriceFromNewTab();
		amz.openNewWindow();
		amz.openNewTab();
		amz.getAllWindowHandles();
		amz.goToSecondWindow();
	}

}
