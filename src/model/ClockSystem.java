package model;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.HashMap;

import sources.LocalSource;
import sources.Source;
import view.ClockDisplay;

/**
 * Cette classe représente notre horloge centrale et unique.
 * Elle implémente le pattern du singleton, et ne peut donc être instanciée qu'une seule fois
 * Pour faire réference à cette classe, on utilisera donc toujours l'instruction suivante :
 * <code> ClockSystem.getInstance() </code>
 */
public final class ClockSystem {

	/**
	 * L'instance unique de ClockSystem
	 */
	private static volatile ClockSystem instance = null;

	/**
	 * La source de l'horloge
	 * @see Source
	 */
	private Source source = new LocalSource();
	
	/**
	 * Le temps actuel
	 */
	private LocalDateTime time = source.getTime();
	
	/**
	 * La liste des affichages liés à l'horloge, ainsi que leurs taux de rafraichissement respectifs
	 */
	private HashMap<ClockDisplay, RefreshRate> displays = new HashMap<ClockDisplay, RefreshRate>();

	/**
	 * Le constructeur de ClockSystem.
	 * Méthode privée car elle ne doit pas être appelée à l'exterieur de la classe
	 * Lance un thread avec la classe UpdateClock, qui met à jour le temps en fonction de la source
	 * @see UpdateClock
	 */
	private ClockSystem() {
		super();
		new Thread(new UpdateClock(this)).start();
		System.out.println("Clock started");
	}

	/**
	 * Retourne l'unique instance de ClockSystem
	 * @return l'instance unique de ClockSystem
	 */
	public final static ClockSystem getInstance() {
		// Si l'instance est null
		if(ClockSystem.instance == null) {
			// On la créé
			synchronized(ClockSystem.class) {
				System.out.println("Création du singleton clockSystem");
				ClockSystem.instance = new ClockSystem();
			}
		}
		return ClockSystem.instance;
	}

	/**
	 * Change la source
	 * @param source la nouvelle source
	 */
	public void setSource(Source source) {
		this.source = source;
	}
	
	/**
	 * Renvoie la source actuelle
	 * @return la source actuelle
	 */
	public Source getSource() {
		return source;
	}
	
	/**
	 * Ajoute un nouvel affichage
	 * @param clockDisplay l'affichage
	 * @param refreshRate sa fréquence de rafraichissement
	 */
	public void addDisplay(ClockDisplay clockDisplay, RefreshRate refreshRate) {
		displays.put(clockDisplay, refreshRate);
	}

	/**
	 * Supprime un affichage
	 * @param clockDisplay l'affichage
	 * @param refreshRate sa fréquence de rafraichissement
	 */
	public void removeDisplay(ClockDisplay clockDisplay, RefreshRate refreshRate) {
		displays.remove(clockDisplay, refreshRate);
	}

	/**
	 * Notifie les affichages d'un changement de temps
	 * @param event la fréquence de rafraichissement prise en compte
	 */
	public void notify (RefreshRate event) {
		// Pour chaque affichage
		for (ClockDisplay clockDisplay : displays.keySet()) {
			// On test si l'affichage écoute le signal "event"
			if (displays.get(clockDisplay).equals(event))
			{
				// Si oui, on appelle la méthode "onChange" de cet affichage
				Method method;
				try {
					method = clockDisplay.getClass().getMethod("onChange", LocalDateTime.class);
					method.invoke(clockDisplay, getTime());
				} 
				catch (Exception e) {
					System.err.println("Erreur : Impossible de notifier");
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Renvoie le temps actuel
	 * @return le temps actuel
	 */
	public LocalDateTime getTime() {
		return time;
	}

	/**
	 * Met à jour le temps de la ClockSystem
	 * @param time le nouveau temps
	 */
	public void setTime(LocalDateTime time) {
		LocalDateTime oldTime = this.time;
		this.time = time;
		if (oldTime.getNano() != time.getNano())
		{
			notify(RefreshRate.MILLISECONDS);
		}
		if (oldTime.getSecond() != time.getSecond())
		{
			notify(RefreshRate.SECONDS);
		}
		if (oldTime.getMinute() != time.getMinute())
		{
			notify(RefreshRate.MINUTES);
		}
		if (oldTime.getHour() != time.getHour())
		{
			notify(RefreshRate.HOURS);
		}
	}

}
