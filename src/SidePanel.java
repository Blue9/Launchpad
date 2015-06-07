// Copyright GM.

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SidePanel extends JPanel implements KeyListener {

	private static int loop;
	JButton[] buttons;
	String[] labels;
	Color[] colors;

	public SidePanel() {
		buttons = new JButton[3];
		labels = new String[] { ">>", "^^", "<<" };
		colors = new Color[]{ Color.YELLOW, Color.RED, Color.GREEN };
		setLayout(new GridLayout(3, 1, 0, 150));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(labels[i]);
			buttons[i].setBackground(Color.LIGHT_GRAY);
			buttons[i].setBorderPainted(false);
			buttons[i].setFocusable(false);
			add(buttons[i]);
		}
		buttons[0].setBackground(colors[0]); // default set
		setBorder(new EmptyBorder(50, 0, 90, 60));
		setPreferredSize(new Dimension((Control.height()-330)/3 + 60, Control.height() + 110));
		setFocusable(false);
		setBackground(Launchpad.color());
	}
	
	public static int loop() {
		return loop;
	}
	
	public void keyPressed(KeyEvent e) {
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setBackground(Color.LIGHT_GRAY);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			loop = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			loop = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			loop = 2;
		}
		buttons[loop].setBackground(colors[loop]);
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}
}
