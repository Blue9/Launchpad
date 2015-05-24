// Copyright GM.

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class Launchpad extends JPanel {
	private static Color color = new Color(48, 48, 48);
	
	private ButtonPanel bp;
	private SidePanel sp;
	
	public Launchpad() {
		super();
		setLayout(new BorderLayout());
		bp = new ButtonPanel();
		sp = new SidePanel();
		add(bp, BorderLayout.WEST);
		add(sp, BorderLayout.EAST);
		addKeyListener(bp);
		addKeyListener(sp);
		setFocusable(true);
	}

	public void init(String song) {
		if (song.equals("")) {        // Default to First of the Year
			Sound.init("foty");
		}
		else {
			Sound.init(song);
		}
		while (!Sound.initialized()) {
		}
	}
	
	public static Color color() {
		return color;
	}
	
	public ButtonPanel bp() {
		return bp;
	}
	
	public SidePanel sp() {
		return sp;
	}
}