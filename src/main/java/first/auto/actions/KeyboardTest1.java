package first.auto.actions;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardTest1 {
	// Launch the browser
	WebDriver driver = new FirefoxDriver();
	
	public void launchApp() {
		driver.get("https://www.facebook.com/");
		handleCookie();
		//driver.findElement(By.id("email")).sendKeys("test@test.com");
	}
	
	public void doKeyboardActions() {
		//Pass the driver object to the action object, so it can perform mouse/keyboard actions on the current browser
		Actions action = new Actions(driver);
		WebElement emailElement = driver.findElement(By.id("email"));
		WebElement loginButton = driver.findElement(By.name("login"));
		
		//Using actions class mouse event we are moving to the element and performing a click 
		action.moveToElement(emailElement).click();
		
		//Keys is an Enum which consists of all keyboard keys
		action.keyDown(Keys.SHIFT).sendKeys("test@test.com").keyUp(Keys.SHIFT).build().perform();
		action.sendKeys(Keys.TAB).sendKeys("password").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void handleCookie() {
		// This is a safe way to handle an element - when you are not sure if that element would appear or not
		List<WebElement> cookie = driver.findElements(By.xpath("//div[@tabindex='0']//span[contains(text(),'Allow all cookies')]"));
		if(cookie.size()>0) {
			cookie.get(0).click();
		}
	}

	public static void main(String[] args) {
		KeyboardTest1 keyBoard = new KeyboardTest1();
		keyBoard.launchApp();
		keyBoard.doKeyboardActions();
	}

}
