package model;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.HashMap;

import view.ClockDisplay;

public final class Singleton {

	private static volatile Singleton instance = null;

	private LocalDateTime time = LocalDateTime.now();
	private HashMap<ClockDisplay, String> displays = new HashMap<ClockDisplay, String>();

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

	public void addDisplay(ClockDisplay clockDisplay, String refreshRate) {
		displays.put(clockDisplay, refreshRate);
		System.out.println("On ajoute la clockDisplay " + clockDisplay + " à l'event " + refreshRate);
	}

	public void removeDisplay(ClockDisplay clockDisplay, String refreshRate) {
		displays.remove(clockDisplay, refreshRate);
	}

	public void notify (String event) {
		for (ClockDisplay clockDisplay : displays.keySet()) {
			//System.out.println("key: " + clockDisplay + " value: " + displays.get(clockDisplay));
			if (displays.get(clockDisplay).equals(event))
			{
				Method method;
				try {
					System.out.println("On notifie");
					method = clockDisplay.getClass().getMethod("onChange", LocalDateTime.class);
					method.invoke(clockDisplay, getTime());
				} 
				catch (Exception e) {
					System.out.println("Erreur, " + e);
				}
			}
		}
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		LocalDateTime oldTime = this.time;
		this.time = time;
		if (oldTime.getNano() != time.getNano())
		{
			notify("onMillisecondChange");
		}
		if (oldTime.getSecond() != time.getSecond())
		{
			notify("onSecondChange");
		}
		if (oldTime.getMinute() != time.getMinute())
		{
			notify("onMinuteChange");
		}
		if (oldTime.getHour() != time.getHour())
		{
			notify("onHourChange");
		}
	}

}
