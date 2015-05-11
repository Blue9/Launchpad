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
	private JButton intro;
	private JButton main;
	private JButton drop;
	JButton[] buttons;
	String[] labels;

	public SidePanel() {
		buttons = new JButton[] { intro, main, drop };
		labels = new String[] { ">>", "^^", "<<" };
		setLayout(new GridLayout(3, 1, 0, 150));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(labels[i]);
			buttons[i].setBackground(Color.GRAY);
			buttons[i].setBorderPainted(false);
			buttons[i].setFocusable(false);
			add(buttons[i]);
		}
		setBorder(new EmptyBorder(90, 0, 90, 60));
		setPreferredSize(new Dimension((Control.height()-330)/3 + 60, Control.height() + 150));
		setFocusable(false);
		setBackground(Launchpad.color());
	}
	
	public static int loop() {
		return loop;
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			loop = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			loop = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			loop = 2;
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}
}
