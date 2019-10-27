package view;

import java.time.format.DateTimeFormatter;

import model.ClockSystem;

/**
 * Permet de créer un "TextClockDisplay" avec un format et un taux de raffraichissement passés en paramètre
 * et de l'ajouter automatiquement en tant que listener dans la clockSystem avec le signal écouté correspondant.
 *
 * @see TextClockDisplay
 */
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
		
		ClockSystem.getInstance().addDisplay(clockDisplay, refreshRateString);
	}
}
