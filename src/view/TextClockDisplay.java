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

public class TextClockDisplay extends JFrame implements ClockDisplay {

	private DateTimeFormatter format;
	
	private JLabel timeLabel;
	
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
	
	public void displayTime(LocalDateTime time) {
//		System.out.println(time.format(format));
		timeLabel.setText(time.format(format));
	}

	public void onChange(LocalDateTime time) {
		displayTime(time);
	}
}
