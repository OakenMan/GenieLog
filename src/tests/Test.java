package tests;

import model.Singleton;

public class Test {

	public static void main(String[] args) {
		
		Singleton.getInstance();

		try {
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println("Erreur, " + e);
		}
		
		while(true)
		{
			try {
				Thread.sleep(100);
			}
			catch(Exception e)
			{
				System.out.println("Erreur, " + e);
			}
			System.out.println(Singleton.getInstance().getTime());
		}
	}
}
