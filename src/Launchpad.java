// Copyright GM.

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Launchpad extends JPanel {
	private static Color color = new Color(48, 48, 48);
	
	private ButtonPanel bp;
	private SidePanel sp;
	private JTextField song;
	
	public Launchpad(String dir) {
		super();
		setLayout(new BorderLayout());
		bp = new ButtonPanel();
		sp = new SidePanel();
		
		song = new JTextField("Loaded " + dir);
		song.setBackground(color);
		song.setBorder(new EmptyBorder(20, 60, 0, 0));
		song.setFont(new Font("Arial", Font.PLAIN, 20));
		song.setForeground(Color.WHITE);
		song.setFocusable(false);
		
		add(bp, BorderLayout.WEST);
		add(sp, BorderLayout.EAST);
		add(song, BorderLayout.NORTH);
		
		addKeyListener(bp);
		addKeyListener(sp);
		setFocusable(true);
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