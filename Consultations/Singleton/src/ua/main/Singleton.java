package ua.main;

public class Singleton {

	private static Singleton instance;
	
	private Singleton() {
		System.out.println("Constructor called");
	}

	public static synchronized Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
			System.out.println("Create new Singletone object");
		} else {
			System.out.println("Called existed Singletone object");
		}
		
		return instance;
	}
}
