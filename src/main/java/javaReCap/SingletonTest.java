package javaReCap;

public class SingletonTest {
	
	private static SingletonTest singletonTestInstance = null;
	
	
	
	public static SingletonTest getInstance() {
		if(singletonTestInstance == null) {
			singletonTestInstance = new SingletonTest();
		}
		return singletonTestInstance;
	}

	public static void main(String[] args) {
		
		SingletonTest singletonTestInstance1 = getInstance();
		SingletonTest singletonTestInstance2 = getInstance();
		SingletonTest singletonTestInstance3 = getInstance();
		
		System.out.println(singletonTestInstance1+ " "+singletonTestInstance2+ " "+singletonTestInstance3);
	}

}
