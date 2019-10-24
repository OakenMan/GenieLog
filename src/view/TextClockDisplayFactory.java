package view;

import java.time.format.DateTimeFormatter;

import model.Singleton;

public class TextClockDisplayFactory {

	public static final int REFRESH_RATE_MILLISECONDS = 1;
	public static final int REFRESH_RATE_SECONDS = 2;
	public static final int REFRESH_RATE_MINUTES = 3;
	public static final int REFRESH_RATE_HOURS = 4;

	public void createClock(DateTimeFormatter format, int refreshRate) {
		String refreshRateString;
		switch (refreshRate) {
		case REFRESH_RATE_MILLISECONDS:
			refreshRateString = "onMillisecondChange";
			break;
		case REFRESH_RATE_SECONDS:
			refreshRateString = "onSecondChange";
			break;
		case REFRESH_RATE_MINUTES:
			refreshRateString = "onMinuteChange";
			break;
		case REFRESH_RATE_HOURS:
			refreshRateString = "onHourChange";
			break;
		default:
			refreshRateString = "onSecondChange";
		}
		
		ClockDisplay clockDisplay = new TextClockDisplay(format);
		
		Singleton.getInstance().addDisplay(clockDisplay, refreshRateString);
	}
}
