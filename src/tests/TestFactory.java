package tests;

import java.time.format.DateTimeFormatter;

import model.Singleton;
import view.TextClockDisplayFactory;

public class TestFactory {

	public static void main(String[] args) {
		
		Singleton.getInstance();
		try {
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println("Erreur, " + e);
		}
		
		TextClockDisplayFactory displayFactory = new TextClockDisplayFactory();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		displayFactory.createClock(format, TextClockDisplayFactory.REFRESH_RATE_SECONDS);
	}

}
