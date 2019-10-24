package tests;

import model.Singleton;

public class Test {

	public static void main(String[] args) {
		
		Singleton.getInstance();
		
//		try {
//		Thread.sleep(1000);
//	} catch (InterruptedException e) {
//		e.printStackTrace();
//	}
		
		System.out.println(Singleton.getInstance().getTime());
		System.out.println(Singleton.getInstance().getTime());
		System.out.println(Singleton.getInstance().getTime());
		System.out.println(Singleton.getInstance().getTime());
		System.out.println(Singleton.getInstance().getTime());

	}

}
