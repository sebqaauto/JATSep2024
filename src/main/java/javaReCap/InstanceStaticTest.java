package javaReCap;

public class InstanceStaticTest {
	
	//Static variables are associated with the class - it is shared among all the objects - but there is only one copy of it 
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

	public static void main(String[] args) {
		
		new InstanceStaticTest();
		InstanceStaticTest student1 = new InstanceStaticTest("Dhoni", "WKT", 07);
		InstanceStaticTest student2 = new InstanceStaticTest("Rohit", "Opening Batsman", 45);
		InstanceStaticTest student3 = new InstanceStaticTest("Virat", "Opening Batsman", 18);
		
		System.out.println(student1.StudentName);
		System.out.println(student2.StudentName);
		System.out.println(student3.StudentName);
		System.out.println(student1.StudentName);
		System.out.println(CollegeName);
		System.out.println(student1.CollegeName);
		student1.CollegeName = "IPL Version 2";
		System.out.println(student3.CollegeName);
		System.out.println(CollegeName);
		
		
		
	}

}
