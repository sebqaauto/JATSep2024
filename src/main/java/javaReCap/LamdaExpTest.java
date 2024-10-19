package javaReCap;

import java.util.ArrayList;

//Functional Interface? - An interface which has only one abstract method is called functional interface
interface Calculator{
	//Variables - public, static and final(Constant) - by default
	int ramSize = 8;
	
	//Methods - public & abstract - by default 
	void doAddition(int a, int b, int c);
	
	//void doAddition2(int a, int b, int c);
}

// Only one public in a .java file 
public class LamdaExpTest {
	

	public static void main(String[] args) {
		//Lambda is used against for implementing functional interfaces, it is also known as anonymous function
		
		Calculator calculator = (int a, int b, int c) -> {
			int temp;
			temp = a+b+c;
			System.out.println(temp);
			System.out.println(temp*10);
		};
		
		calculator.doAddition(60, 50, 55);
		
		ArrayList<Integer> arrayInt = new ArrayList<>();
		arrayInt.add(10);
		arrayInt.add(20);
		arrayInt.add(30);
		arrayInt.add(40);
		arrayInt.add(50);
		arrayInt.add(10);
		arrayInt.forEach((num) -> {
			System.out.println(num);
			System.out.println(num*2);
			});
		
	System.out.println(Calculator.ramSize);
	//Calculator.ramSize = 12; - re assigning is not possible 

}
}

//Class can never be Private & Protected 
 class privateExample{
	//Access Modifiers for methods and variables - public private protected default 
	
	
}	

/* Abstract
 * Interface
 * Concrete - Non Abstract class
 * Final Class
 * Nested Class - Static
 * Singleton Class
 * POJO Class
 * */
