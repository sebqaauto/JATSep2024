package first.auto;
import java.util.ArrayList;
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
		//for(int i=0; i<Hyperlinks.size(); i++) {
	//	System.out.println(Hyperlinks.get(i));
		//}
		//For each 
		for (WebElement webElement : Hyperlinks) {
			System.out.println(webElement);
		}
		
		ArrayList<String> Urls = new ArrayList<String>();
		String temp;
		for (WebElement element : Hyperlinks) {
			temp = element.getAttribute("href");
			Urls.add(temp);
		}
		
		for (String string : Urls) {
			System.out.println(string);
		}
		
		String lastUrl = Urls.get(Urls.size()-1);
		
		driver.navigate().to(lastUrl);

		
		
		//driver.navigate().to("");
		

	}

}
// Get all the hyperlinks from the FB page - navigate to the last hyperlink on the FB page?