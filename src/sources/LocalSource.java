package sources;

import java.time.LocalDateTime;

public class LocalSource implements Source {

	@Override
	public LocalDateTime getTime() {
		return LocalDateTime.now();
	}

}
