package model;

import java.time.LocalDateTime;

public class UpdateClock implements Runnable {
	
	@Override
	public void run() {
		while(true) {
			Singleton.getInstance().setTime(LocalDateTime.now());
			System.out.println(Singleton.getInstance().getTime());
		}
	}

}
