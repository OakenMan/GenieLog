package model;

import java.time.LocalDateTime;

public final class Singleton {

	private static volatile Singleton instance = null;
	
	private LocalDateTime time;
	
	//-------------------------
	private Singleton() {
		super();
		new Thread(new UpdateClock()).start();
	}
	
	public final static Singleton getInstance() {
		if(Singleton.instance == null) {
			synchronized(Singleton.class) {
				Singleton.instance = new Singleton();
			}
		}
		return Singleton.instance;
	}
	//-------------------------
	
	public LocalDateTime getTime() {
		return time;
	}
	
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
}
