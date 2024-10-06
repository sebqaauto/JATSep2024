package test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		String []fbpageInfo = new String[3];
		String []twpageInfo = new String[3];
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		fbpageInfo[0] = driver.getTitle();
		String url = driver.getCurrentUrl();
		fbpageInfo[1] = driver.getCurrentUrl();
		driver.navigate().to("https://www.facebook.com/biz/directory/");
		twpageInfo[0] = driver.getTitle();
		twpageInfo[1] = driver.getCurrentUrl();
		System.out.println("The title & url of facebook is "+fbpageInfo[0]+ " "+fbpageInfo[1]);
		System.out.println("The title & url of Twitter is "+twpageInfo[0]+ " "+ twpageInfo[1]);
		driver.navigate().back();
		//driver.navigate().forward();
		//driver.quit();
		driver.findElement(By.xpath("//div[@tabindex='0']//span[contains(text(),'Allow all cookies')]")).click();
		WebElement createNewButton = driver.findElement(By.linkText("Create new account"));
		System.out.println(createNewButton);
		createNewButton.click();
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
		//Check for active fields
		boolean firstNameEnabled= firstName.isEnabled();
		if(firstNameEnabled) {
			firstName.sendKeys("Test12Test");
		}
		WebElement maleRadionButton = driver.findElement(By.xpath("//input[@value='2' and @id='sex']"));
		boolean maleRadioStatus = maleRadionButton.isSelected();
		System.out.println("Status of male radio button enablment is before clicking "+maleRadioStatus);
		if(maleRadionButton.isEnabled()) {
			maleRadionButton.click();
			maleRadioStatus = maleRadionButton.isSelected();
			System.out.println("Status of male radio button enablment is after clicking "+maleRadioStatus);
		}
		
		String buttonColor= driver.findElement(By.name("websubmit")).getCssValue("background-color");
		System.out.println(buttonColor);
		String hrefValue= driver.findElement(By.linkText("Already have an account?")).getAttribute("href");
		System.out.println(hrefValue);
		Point coordinates = maleRadionButton.getLocation();
		System.out.println(coordinates.getX()+"   "+coordinates.getY());
		Dimension dimension = driver.findElement(By.name("websubmit")).getSize();
		
		System.out.println(dimension.getHeight()+ " "+ dimension.getWidth());
	}

}
