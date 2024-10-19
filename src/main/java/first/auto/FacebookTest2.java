package first.auto;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookTest2 {

	public static void main(String[] args) {
		// Launch the browser
		WebDriver driver = new FirefoxDriver();
		
		String []fbpageInfo = new String[3];
		String []twpageInfo = new String[3];
		
		// Launch the Web site
		driver.get("https://www.facebook.com/");
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		// Get the title and url of the current window 
		String title = driver.getTitle();
		fbpageInfo[0] = driver.getTitle();
		String url = driver.getCurrentUrl();
		fbpageInfo[1] = driver.getCurrentUrl();
		driver.navigate().to("https://www.facebook.com/biz/directory/");
		twpageInfo[0] = driver.getTitle();
		twpageInfo[1] = driver.getCurrentUrl();
		System.out.println("The title & url of facebook is "+fbpageInfo[0]+ " "+fbpageInfo[1]);
		System.out.println("The title & url of Twitter is "+twpageInfo[0]+ " "+ twpageInfo[1]);
		
		// Navigate using the Browser methods 
		driver.navigate().back();
		//driver.navigate().forward();

		// Use WebElement methods to interact on the web elements of the page
		driver.findElement(By.xpath("//div[@tabindex='0']//span[contains(text(),'Allow all cookies')]")).click();
		WebElement createNewButton = driver.findElement(By.linkText("Create new account"));
		System.out.println(createNewButton);
		createNewButton.click();
		//Check if the element is displayed on the page - visible on the page?
		driver.findElement(By.xpath("//div[@tabindex='0']//span[contains(text(),'Allow all cookies')]")).click();
		WebElement firstName = driver.findElement(By.name("firstname"));
		boolean firstNameStatus = firstName.isDisplayed();
		if(firstNameStatus) {
			System.out.println("firstName  is displayed on the webpage page becase the variable firstNameStatus returned the value:: "+firstNameStatus);
		}
		boolean errorState = driver.findElement(By.id("fullname_error_msg")).isDisplayed();
		if(errorState) {
			System.out.println("errorState  is displayed on the webpage page becase the variable errorState returned the value:: "+errorState);
		}
		else {
			System.out.println("errorState  is not displayed on the webpage page becase the variable errorState returned the value:: "+errorState);
		}
		
		// Check for active fields/buttons using isEnabled method
		boolean firstNameEnabled= firstName.isEnabled();
		if(firstNameEnabled) {
			firstName.sendKeys("Test12Test");
		}
		
		// Check for radio boxes, check boxes if they are selected using isSelected method
		WebElement maleRadionButton = driver.findElement(By.xpath("//input[@value='2' and @id='sex']"));
		boolean maleRadioStatus = maleRadionButton.isSelected();
		System.out.println("Status of male radio button enablment is before clicking "+maleRadioStatus);
		if(maleRadionButton.isEnabled()) {
			maleRadionButton.click();
			maleRadioStatus = maleRadionButton.isSelected();
			System.out.println("Status of male radio button enablment is after clicking "+maleRadioStatus);
		}
		
		// To check/get the value of css attributes use getCssValue method
		String buttonColor= driver.findElement(By.name("websubmit")).getCssValue("background-color");
		System.out.println(buttonColor);
		
		// To check/get the value of Dom attributes use getAttribute method
		String hrefValue= driver.findElement(By.linkText("Already have an account?")).getAttribute("href");
		System.out.println(hrefValue);
		
		// To get the location of an web element on the page in terms of co-ordinates use getLocation method
		Point coordinates = maleRadionButton.getLocation();
		System.out.println(coordinates.getX()+"   "+coordinates.getY());
		Dimension dimension = driver.findElement(By.name("websubmit")).getSize();
		System.out.println(dimension.getHeight()+ " "+ dimension.getWidth());
	}

}
