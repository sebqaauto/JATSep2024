package javaReCap;

public class StringComparsion {
	
	int rollNo = 10; //primitive - rollNo is not an Object 
	String userName1 = "Kamala Harris"; // non-Primitive - userName1 is an Object of String 
	String userName2 = new String("Kamala Harris");// non-Primitive - userName2 is an Object of String 
	String userName3 = "Kamala Harris"; // userName1's memory location is shared with userName3
	public void compareStrings() {
		//memory location
		if(userName1 == userName2) {
			System.out.println("The strings are equal");
		}
		else {
			System.out.println("The strings are not equal");
		}
		// Compare the values of the String 
		if(userName1.equals(userName2)) {
			System.out.println("The strings are equal from the equals method");
		}
		
		if(userName1 == userName3) {
			System.out.println("The strings are equal from the second If");
		}
		else {
			System.out.println("The strings are not equal from the second If");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringComparsion obj = new StringComparsion();
		obj.compareStrings();
	}

}
