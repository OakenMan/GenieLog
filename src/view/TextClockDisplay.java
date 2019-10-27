package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * Display prenant la forme d'une fenêtre graphique affichant l'heure avec un simple label selon un format précis.
 */
public class TextClockDisplay extends JFrame implements ClockDisplay {

	/**
	 * Le format selon lequel afficher l'heure.
	 */
	private DateTimeFormatter format;
	
	private JLabel timeLabel;
	
	/**
	 * Initialise la fenêtre graphique ainsi que le format à utiliser pour afficher l'heure.
	 * @param format Le format utilisé pour afficher l'heure.
	 */
	public TextClockDisplay(DateTimeFormatter format) {
		this.format = format;
		
		setTitle("TextClockDisplay");
		setSize(600,300);
		setMinimumSize(new Dimension(600, 300));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(true);

		setLayout(new BorderLayout());
		
		timeLabel = new JLabel("", SwingConstants.CENTER);
		timeLabel.setFont(new java.awt.Font(Font.SANS_SERIF, Font.PLAIN, 25));
		add(timeLabel, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	/**
	 * Affiche l'heure passée en paramètre
	 */
	public void displayTime(LocalDateTime time) {
		timeLabel.setText(time.format(format));
	}

	/**
	 * Fonction à appeler en cas de notification du signal écouté.
	 */
	public void onChange(LocalDateTime time) {
		displayTime(time);
	}
}
