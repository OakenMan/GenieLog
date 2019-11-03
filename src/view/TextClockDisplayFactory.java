package view;

import java.time.format.DateTimeFormatter;

import model.ClockSystem;
import model.RefreshRate;

/**
 * Permet de créer un "TextClockDisplay" avec un format et un taux de raffraichissement passés en paramètre
 * et de l'ajouter automatiquement en tant que listener dans la clockSystem avec le signal écouté correspondant.
 *
 * @see TextClockDisplay
 */
public class TextClockDisplayFactory {

	public ClockDisplay createClock(DateTimeFormatter format, RefreshRate refreshRate) {
		// Créé un nouvel affichage avec le format correspondant
		ClockDisplay clockDisplay = new TextClockDisplay(format);
		
		// Met à jour l'heure sur l'affichage
		clockDisplay.displayTime(ClockSystem.getInstance().getTime());
		
		// Connecte l'affichage à la ClockSystem avec la fréquence de rafraichissement correspondante 
		ClockSystem.getInstance().addDisplay(clockDisplay, refreshRate);
		
		return clockDisplay;
	}
}
