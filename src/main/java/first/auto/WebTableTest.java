package first.auto;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebTableTest {
	
	public String baseUrl = "https://www.dezlearn.com/webtable-example/";
	public String standardUser = "John"; // Choose standard
	public String premiumUser = "Chris"; // Choose premium 
	public String commentOnUser = "Alvin";
	public String []PremiumUsers = {"Tim", "Mayur", "Alvin"};
	public String []StandardUsers = new String[5];
	public ArrayList<String> users = new ArrayList<>();
	public String hatchBackUser = "Alvin";
	
	// Array is of fixed size & ArrayList it grows dynamically 
	
	WebDriver driver = new ChromeDriver();
	
	public void launchApp() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void takeTableCount() {
		List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr"));
		List<WebElement> tableColumns = driver.findElements(By.xpath("//table/tbody/tr[7]/td"));
		System.out.println("The number of rows and columns are "+tableRows.size()+"  --  " +tableColumns.size());
		System.out.println("The number of entries are "+ tableRows.size()*tableColumns.size());
	}
	
	public void getAllNames() {
	List<WebElement> nameElements = driver.findElements(By.xpath("//tbody/tr/td[1]"));
	for(int i=0; i<=nameElements.size()-1; i++) {
		System.out.println(nameElements.get(i).getText());
	}
	// For Each Loop - Which data collection should I iterate - nameElement; - What is the type of the data collection - WebElement
	// temp variable of the data collection type 
	System.out.println("From the For each loop --");
	for (WebElement elementName : nameElements) {
		System.out.println(elementName.getText());
	}
	}
	
	public void getAllEmails() {
		List<WebElement> emailElements = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		for(int i=0; i<=emailElements.size()-1; i++) {
			System.out.println(emailElements.get(i).getText());
		}
		// For Each Loop - Which data collection should I iterate - nameElement; - What is the type of the data collection - WebElement
		// temp variable of the data collection type 
		System.out.println("From the For each loop --");
		for (WebElement element : emailElements) {
			System.out.println(element.getText());
		}
	}
	
	public void clickStandardChecks() {
		List<WebElement> standardCheckElements = driver.findElements(By.xpath("//tbody/tr/td[3]/input"));
		// For Each Loop - Which data collection should I iterate - nameElement; - What is the type of the data collection - WebElement
		// temp variable of the data collection type 
		System.out.println("From the For each loop --");
		for (WebElement element : standardCheckElements) {
			element.click();
		}
	}
	
	public void clickPremiumChecks() {
		List<WebElement> premiumCheckElements = driver.findElements(By.xpath("//tbody/tr/td[4]/input"));
		// For Each Loop - Which data collection should I iterate - nameElement; - What is the type of the data collection - WebElement; temp variable of the data collection type 
		System.out.println("From the For each loop --"+ " Nothing ");
		for (WebElement element : premiumCheckElements) {
			element.click();
		}	
	}
	
	public void clickSpecificStandardCheck() {
		WebElement standardCheckBox = driver.findElement(By.xpath("//td[contains(text(),'"+standardUser+"')]/parent::tr/td[3]/input"));
		standardCheckBox.click();
	}
	
	public void clickSpecificPremiumCheck() {
		WebElement premiumCheckBox = driver.findElement(By.xpath("//td[contains(text(),'"+premiumUser+"')]/parent::tr/td[4]/input"));
		premiumCheckBox.click();
	}
	
	public void doCommentForUserName() {
		WebElement standardCheckBox = driver.findElement(By.xpath("//td[contains(text(),'"+commentOnUser+"')]/following-sibling::td[5]/input"));
		standardCheckBox.sendKeys("Hey" +commentOnUser +" How are you ????");
	}

	public void clickPremiumUsersCheck() {
		for (String user : PremiumUsers) {
			WebElement premiumCheckBox = driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/parent::tr/td[4]/input"));
			premiumCheckBox.click();
		}
	}
	
	public void selectHatchBackUser() {
		
		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'"+hatchBackUser+"')]/following-sibling::td[4]/select"));
		Select select = new Select(element);
		select.selectByValue("Hatchback");
		
	}

	public static void main(String[] args) {
		WebTableTest webTable = new WebTableTest();
		webTable.launchApp();
		webTable.takeTableCount();
		//webTable.getAllNames();
		//webTable.getAllEmails();
		//webTable.clickStandardChecks();
		//webTable.clickPremiumChecks();
		webTable.clickSpecificStandardCheck();
		webTable.clickSpecificPremiumCheck();
		webTable.doCommentForUserName();
		webTable.clickPremiumUsersCheck();
		webTable.selectHatchBackUser();

	}

}
