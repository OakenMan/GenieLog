package tests;

import java.time.format.DateTimeFormatter;

import model.Singleton;
import sources.LocalSource;
import view.TextClockDisplayFactory;

public class TestFactory {

	public static void main(String[] args) {
		
		Singleton.getInstance().setSource(new LocalSource());
		
		try {
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println("Erreur, " + e);
		}
		
		TextClockDisplayFactory displayFactory = new TextClockDisplayFactory();
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("HH'h'mm");
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("hh:mm a ss's'");
		
		displayFactory.createClock(format1, TextClockDisplayFactory.REFRESH_RATE_SECONDS);
		
		displayFactory.createClock(format2, TextClockDisplayFactory.REFRESH_RATE_SECONDS);
	}

}
