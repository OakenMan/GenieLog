package model;

import java.time.LocalDateTime;

public final class Singleton {

	private static volatile Singleton instance = null;
	
	private LocalDateTime time;
	
	//-------------------------
	private Singleton() {
		super();
		new Thread(new UpdateClock(this)).start();
		System.out.println("Clock started");
	}
	
	public final static Singleton getInstance() {
		if(Singleton.instance == null) {
			synchronized(Singleton.class) {
				System.out.println("Création du singleton");
				Singleton.instance = new Singleton();
			}
		}
		return Singleton.instance;
	}
	//-------------------------
	
	public LocalDateTime getTime() {
		return time;
	}
	
	public void setTime(LocalDateTime t) {
		this.time = t;
		//System.out.println("t = "+t+", time="+getTime());
	}
	
}
