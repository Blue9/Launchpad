// Copyright GM.

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;

public class Control extends JFrame {
	
	private static int height = 600;
	private static int lWidth = (height*2 + 190) + ((height-330)/3 + 60); // ButtonPanel + SidePanel
	private static int lHeight = height + 150;
	
	private Menu menu;
	private Launchpad launchpad;

	public Control() {
		super("BLUE_9 LAUNCHPAD");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		menu = new Menu(this);
		add(menu);
		pack();
		setFocusable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Control();
	}

	public void start(File f) {
		remove(menu);
		if (f != null) {
			launchpad = new Launchpad(f.getAbsolutePath());
		} else {
			launchpad = new Launchpad("Default song (Bangarang)");
		}
		add(launchpad);
		launchpad.requestFocusInWindow();
		pack();
		repaint();
	}
	
	public static int height() {
		return height;
	}
	
	public static int lWidth() {
		return lWidth;
	}
	
	public static int lHeight() {
		return lHeight;
	}

}