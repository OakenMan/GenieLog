package view;

import java.time.LocalDateTime;

public interface ClockDisplay {
	
	public void displayTime(LocalDateTime time);
	public void onChange(LocalDateTime time);
}
