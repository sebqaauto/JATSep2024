package test;

import java.util.Scanner;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public interface DemoTest {
	
	public static void main(String arg[]) {
		//DemoTest demo = new DemoTest();
	}
	
	public default void addtion() {
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		int a;
		String str;
		
		WebDriver driver = new ChromeDriver();
		
		DemoTest demo;
	}

}

//Which is the top most class in Java?
//What is the default pacakage in Java? - java.lang 
// Find all the hyperlinks on the webPage through Selenium Java 
// 1) Get all the hyperlinks - findElements()
// 2) Get the count of hyperlinks
// 3) Navigate to the last hyperlink 



