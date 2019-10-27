package tests;

import model.ClockSystem;

public class Test {

	public static void main(String[] args) {
		
		ClockSystem.getInstance();

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
			System.out.println(ClockSystem.getInstance().getTime());
		}
	}
}
