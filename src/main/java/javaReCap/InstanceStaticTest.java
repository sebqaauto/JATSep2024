package javaReCap;

public class InstanceStaticTest {
	static {
		System.out.println("Hi from the static block 3");
	}
	// Static variables are associated with the class - 
	// It is shared among all the objects - but there is only one copy of it 
	// They don't any object or instances to be used 
	// The keyword static doesn't need the help of object 0r instance
	public static String CollegeName;
	public static String ChairMan;
	
	public InstanceStaticTest() {
		CollegeName = "IPL";
		ChairMan = "Jay Shah";
	}
	
	//Instance variables - Object will take a copy of it 
	public String StudentName;
	public String Dept;
	public int rollNo;
	
	public InstanceStaticTest(String studentName, String Dept, int rollNo) {
		this.StudentName = studentName;
		this.Dept = Dept;
		this.rollNo = rollNo;
	}
	
	public static void doSomethingHere() {
		System.out.println("Hi from the doSomethingHere block ");
		
	}
	
	public void doSomethingDifferent() {
		System.out.println("Hi from the doSomethingDifferent block ");
		doSomethingHere();
	}
	
	public static void main(String[] args) {
		//doSomethingDifferent();
		doSomethingHere();
		new InstanceStaticTest();
		InstanceStaticTest student1 = new InstanceStaticTest("Dhoni", "WKT", 07);
		InstanceStaticTest student2 = new InstanceStaticTest("Rohit", "Opening Batsman", 45);
		InstanceStaticTest student3 = new InstanceStaticTest("Virat", "Opening Batsman", 18);
		
		System.out.println(student1.StudentName);
		System.out.println(student2.StudentName);
		System.out.println(student3.StudentName);
		System.out.println(student1.StudentName);
		System.out.println(CollegeName);
		System.out.println(CollegeName);
		InstanceStaticTest.CollegeName = "IPL Version 2";
		System.out.println(student3.CollegeName);
		System.out.println(CollegeName);
		
	}
	
	static {
		System.out.println("Hi from the static block 1");
	}
	static {
		System.out.println("Hi from the static block 2 ");
	}
	
}
