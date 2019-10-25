package model;

import java.time.LocalDateTime;

public class UpdateClock implements Runnable {
	
	Singleton mainClock;
	
	public UpdateClock(Singleton mainClock) {
		this.mainClock = mainClock;
	}
	
	@Override
	public void run() {
		while(true) {
			Singleton.getInstance().setTime(Singleton.getInstance().getSource().getTime());
		}
	}

}
