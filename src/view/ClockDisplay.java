package view;

import java.time.LocalDateTime;

/**
 * Interface à implémenter pour chaque nouveau type d'affichage.
 */
public interface ClockDisplay {
	
	/**
	 * Cette méthode doit afficher l'heure passée en paramètre
	 */
	public void displayTime(LocalDateTime time);
	
	/**
	 * Cette méthode sera appelée en cas de notification du signal écouté
	 */
	public void onChange(LocalDateTime time);
}
