package first.auto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerTest1 {
	
	String baseUrl = "https://www.globalsqa.com/demo-site/datepicker/#Simple%20Date%20Picker";

	
	WebDriver driver = new ChromeDriver();
	
	public void launchApp() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class='fc-dialog-container']//button/p[text()='Consent']")).click();
	}
	
	public void swithToSimpleDatePikcer() {
		WebElement frameElement = driver.findElement(By.xpath("//*[@rel-title='Simple Date Picker']//iframe"));
		driver.switchTo().frame(frameElement);
		driver.findElement(By.id("datepicker")).click();
		//driver.findElement(By.id("datepicker")).sendKeys("11/09/2024");
	}
	
	public void interactWithSimpleDatePicker(int day, String month, String year) {
		String currentMonth; // November
		String currentYear; // 2024
		currentMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		currentYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		int counter=1;
		while(!currentMonth.equals(month) || !currentYear.equals(year)){ // when currentMonth & month are matching it returns true - when not matching returns false 
			System.out.println("Inside the do-While for the "+counter++ +" time");
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			currentMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
			currentYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		} 
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
	}

	public static void main(String[] args) {
		DatePickerTest1 test = new DatePickerTest1();
		test.launchApp();
		test.swithToSimpleDatePikcer();
		test.interactWithSimpleDatePicker(26, "January", "2026");

	}

}




//if(currentMonth.equals(month)) {
//	// desired month is already there 
//}
//else {
//	driver.findElement(By.xpath("//span[text()='Next']")).click();
//}
