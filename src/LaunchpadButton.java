// Copyright GM.

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class LaunchpadButton extends JButton {
	static ImageIcon yellow = new ImageIcon(LaunchpadButton.class.getResource("img/yellow.png"));
	static ImageIcon red = new ImageIcon(LaunchpadButton.class.getResource("img/red.png"));
	static ImageIcon green = new ImageIcon(LaunchpadButton.class.getResource("img/green.png"));
	
	static ImageIcon yellowL = new ImageIcon(LaunchpadButton.class.getResource("img/yellowL.png"));
	static ImageIcon redL = new ImageIcon(LaunchpadButton.class.getResource("img/redL.png"));
	static ImageIcon greenL = new ImageIcon(LaunchpadButton.class.getResource("img/greenL.png"));
	
	ImageIcon[] colors = new ImageIcon[]{yellow, red, green};
	ImageIcon[] colorsL = new ImageIcon[]{yellowL, redL, greenL};
	static ImageIcon released = new ImageIcon(LaunchpadButton.class.getResource("img/notPressed.png"));
	private ScheduledExecutorService timer;
	private Runnable lightsOn;
	private Runnable lightsOff;
	
	private int delay = 75;

	
	public LaunchpadButton(String title, ImageIcon background) {
		super(title, background);
		timer = Executors.newSingleThreadScheduledExecutor();
		lightsOn = new Runnable() {
			public void run() {
				lightsOn();
			}
		};
		
		lightsOff = new Runnable() {
			public void run() {
				released();
			}
		};
		
		setHorizontalTextPosition(SwingConstants.CENTER);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(false);
		setFocusable(false);		
	}
	public void setColor(ImageIcon i) {
		setIcon(i);
	}
	public void pressed() {
		setIcon(colorsL[SidePanel.loop()]);
	}
	
	public void lightsOn() {
		setIcon(colors[SidePanel.loop()]);
	}

	public void lights(int i) {
		timer.schedule(lightsOn, i*delay, TimeUnit.MILLISECONDS);
		timer.schedule(lightsOff, i*delay + delay, TimeUnit.MILLISECONDS);
	}
	
	public void released() {
		setIcon(released);
	}
}
