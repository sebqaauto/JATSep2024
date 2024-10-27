package javaReCap;

public class Honda {
	
	// Static members are class variables - declared at the class level
	public static String parentCompany = "Honda";
	static int counter = 0;

	//Instance Variables - declared at class Level 
	String carName;
	int yearOfManuf;
	String carColor; 
	int counter2 = 0;
	
	// There is always a default constructor inside the class implicitly 
	
	// Explicitly creating the constructor 
	public Honda() {
		System.out.println("The constructor and the object is created "+ ++counter);
	}
	
	public Honda(String carName, int year, String color) {
		//Local variables - carName, year, color
		int wheels = 4;
		this.carName = carName;
		this.yearOfManuf = year;
		this.carColor = color;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Honda city = new Honda();
		city.carName = "Honda City";
		city.yearOfManuf = 1996;
		city.carColor = "Black";
		System.out.println(counter);
		
		Honda civic = new Honda();
		civic.carName = "Honda Civic";
		civic.yearOfManuf = 2000;
		civic.carColor = "White";
		System.out.println(counter);
		
		Honda jazz = new Honda();
		jazz.carName = "Honda Jazz";
		jazz.yearOfManuf = 2004;
		jazz.carColor = "White";
		System.out.println(counter);
		
		Honda elevate = new Honda("Elevate", 2024, "Maroon");
	
		System.out.println(elevate.carName);
		
		System.out.println(civic.carName);
		System.out.println(civic.yearOfManuf);
		System.out.println(civic.carColor);
		System.out.println(city.counter);
		System.out.println(civic.counter);
		System.out.println(jazz.counter);
		

	}

}
