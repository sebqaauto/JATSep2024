package first.auto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonTest1 {

	public static void main(String[] args) {
		
		String searchTerm1 = "Samsung s23";
		String searchTerm2 = "iphone 16";
		String searchTerm3 = "motorolo ultraedge";
		
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(searchTerm3);
		driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
		boolean firstWideSerachresultArea = driver.findElement(By.xpath("//div[@data-cel-widget='search_result_1']")).isDisplayed();
		driver.findElement(By.xpath("//div[@data-cel-widget='search_result_1']")).click();
		driver.findElement(By.xpath("//div[@data-cel-widget='search_result_1']//div[contains(@class,'puis-list-col-left')]")).click();
		System.out.println(firstWideSerachresultArea);
	}

}
