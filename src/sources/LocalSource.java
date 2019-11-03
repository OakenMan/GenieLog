package sources;

import java.time.LocalDateTime;

/**
 * Source locale, qui récupère l'heure système.
 */
public class LocalSource implements Source {

	@Override
	public LocalDateTime getTime() {
		return LocalDateTime.now();
	}

}
