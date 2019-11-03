package tests;

import java.time.format.DateTimeFormatter;

import model.ClockSystem;
import model.RefreshRate;
import sources.LocalSource;
import view.TextClockDisplayFactory;

/**
 * Classe fournie à titre l'exemple sur le fonctionnement de cette bibliothèque.
 */
public class Main {

	public static void main(String[] args) {
		
		// Instancie la ClockSystem et met à jour sa source
		ClockSystem.getInstance().setSource(new LocalSource());
		
		// Créé un TextClockDisplayFactory
		TextClockDisplayFactory displayFactory = new TextClockDisplayFactory();
		
		// Ajoute un premier affichage de format [13h37] qui se rafraichit toutes les minutes
		displayFactory.createClock(DateTimeFormatter.ofPattern("HH'h'mm"), RefreshRate.MINUTES);
		
		// Ajoute un second affichage de format [01:37 pm 42s] qui se rafraichit toutes les secondes
		displayFactory.createClock(DateTimeFormatter.ofPattern("hh:mm a ss's'"), RefreshRate.SECONDS);
	}
}
