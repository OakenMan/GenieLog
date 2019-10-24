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
			mainClock.setTime(LocalDateTime.now());
			//System.out.println(Singleton.getInstance().getTime());
		}
	}

}
