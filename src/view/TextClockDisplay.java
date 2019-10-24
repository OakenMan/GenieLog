package view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TextClockDisplay implements ClockDisplay {

	private DateTimeFormatter format;
	
	public TextClockDisplay(DateTimeFormatter format) {
		this.format = format;
	}
	
	public void displayTime(LocalDateTime time) {
		System.out.println(time.format(format));
	}

	public void onChange(LocalDateTime time) {
		displayTime(time);
	}
}
