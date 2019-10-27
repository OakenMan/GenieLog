package tests;

import java.time.format.DateTimeFormatter;

import model.ClockSystem;
import sources.LocalSource;
import view.TextClockDisplayFactory;

public class TestFactory {

	public static void main(String[] args) {
		
		ClockSystem.getInstance().setSource(new LocalSource());
		
		TextClockDisplayFactory displayFactory = new TextClockDisplayFactory();
		
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("HH'h'mm");
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("hh:mm a ss's'");
		
		displayFactory.createClock(format1, TextClockDisplayFactory.REFRESH_RATE_SECONDS);
		
		displayFactory.createClock(format2, TextClockDisplayFactory.REFRESH_RATE_SECONDS);
	}
}
