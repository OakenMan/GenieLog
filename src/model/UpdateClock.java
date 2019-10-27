package model;

public class UpdateClock implements Runnable {
	
	ClockSystem mainClock;
	
	public UpdateClock(ClockSystem mainClock) {
		this.mainClock = mainClock;
		try {
			Thread.sleep(2000);
			System.out.println("Thread lancé");
		}
		catch(Exception e)
		{
			System.out.println("Erreur, " + e);
		}
		
	}
	
	@Override
	public void run() {
		while(true) {
			ClockSystem.getInstance().setTime(ClockSystem.getInstance().getSource().getTime());
		}
	}

}
