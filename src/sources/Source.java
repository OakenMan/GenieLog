package sources;

import java.time.LocalDateTime;

/**
 * Interface à implémenter pour chaque nouveau type de source.
 */
public interface Source {

	/**
	 * Cette méthode doit renvoyer l'heure
	 */
	public LocalDateTime getTime();
	
}
