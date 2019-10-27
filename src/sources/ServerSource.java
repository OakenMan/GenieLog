package sources;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

public class ServerSource implements Source {

	private TimeInfo timeInfo;
	
	/**
	 * PROBLEME : comme on appelle getTime() dans une boucle while, le serv nous bloque immediatement
	 * solution, mettre un Thread.sleep(5000) à la fin de getTime()  --->  marche pas...
	 */
	
	@Override
	public LocalDateTime getTime() {
		System.out.println("Source started");
		String TIME_SERVER = "time-a.nist.gov";   
		NTPUDPClient timeClient = new NTPUDPClient();
		InetAddress inetAddress;
		
		try {
			inetAddress = InetAddress.getByName(TIME_SERVER);
			timeInfo = timeClient.getTime(inetAddress);
			System.out.println("Time recovered from server");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
		LocalDateTime time = LocalDateTime.now();
		System.out.println(returnTime);
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return time;
	}

}
