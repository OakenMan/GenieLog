package sources;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

/**
 * Source qui récupère l'heure sur le serveur 'time-a.nist.gov'.
 * ATTENTION : à cause des limitations de requêtes imposées par le serveur, cette source ne donne l'heure que toutes les 5 secondes
 * Les affichages liés doivent donc avoir des fréquences de rafraichissement supérieurs à cette valeur.
 */
public class ServerSource implements Source {

	private TimeInfo timeInfo;
	
	@Override
	public LocalDateTime getTime() {
		String TIME_SERVER = "time-a.nist.gov";   
		NTPUDPClient timeClient = new NTPUDPClient();
		InetAddress inetAddress;
		
		// Se connecte au serveur et récupère l'heure
		try {
			inetAddress = InetAddress.getByName(TIME_SERVER);
			timeInfo = timeClient.getTime(inetAddress);
		} catch (UnknownHostException e) {
			e.printStackTrace();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long serverTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
		
		LocalDateTime time = LocalDateTime.ofEpochSecond(serverTime/1000, 0, ZoneOffset.UTC);
		
		// Fait une pause de 5s pour ne pas inonder le serveur de requête et se faire bloquer par celui-ci
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return time;
	}

}
