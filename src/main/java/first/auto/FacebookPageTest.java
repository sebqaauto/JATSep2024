package first.auto;
import java.util.List;
//java.lang
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookPageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
	
		List<WebElement> Hyperlinks = driver.findElements(By.xpath("//a[contains(@href,'http')]"));
		int numberOfHyperlinks = Hyperlinks.size();
		System.out.println("The number of hyperlinks on the webpage are "+numberOfHyperlinks);
		WebElement element = Hyperlinks.get(numberOfHyperlinks-1);

		
		
		//driver.navigate().to("");
		

	}

}
