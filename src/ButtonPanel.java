// Copyright GM.

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class ButtonPanel extends JPanel implements KeyListener {
	private LaunchpadButton[] buttons = new LaunchpadButton[32];
	private String keys = "12345678qwertyuiasdfghjkzxcvbnm,";
	Set<Character> pressed = new TreeSet<Character>();

	public ButtonPanel() {
		setLayout(new GridLayout(4, 8, 10, 10));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new LaunchpadButton(keys.substring(i, i + 1).toUpperCase(), LaunchpadButton.released);
			add(buttons[i]);
		}
		setBorder(new EmptyBorder(20, 60, 60, 60));
		setPreferredSize(new Dimension(Control.height()*2 + 190, Control.height() + 110));
		setFocusable(false);
		setBackground(Launchpad.color());
	}
	
	public LaunchpadButton[] getButtons() {
		return buttons;
	}

	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();
		if (pressed.contains(c)) {
			return;
		}
		pressed.add(c);
		if (c == '\b') {
			Sound.stop();
		}
		int index = keys.indexOf(c);
		if (index != -1) {
			Sound.play(c);
			buttons[index].pressed();
			lights(SidePanel.loop(), index);
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
		char c = e.getKeyChar();
		pressed.remove(c);
		if (keys.indexOf(c) != -1) {
			buttons[keys.indexOf(c)].released();
		}
	}
	
	public void lights(int direction, int index) {
		switch (direction) {
			case 0:
				lightsDown(index);
				break;
			case 1:
				lightsUp(index);
				lightsDown(index);
				break;
			case 2:
				lightsUpFull(index);
				lightsLeftFull(index);
				lightsRightFull(index);
				lightsDownFull(index);
				break;
		}
	}
	
	public void lightsDown(int index) {
		int timer = 0;
		for (int i = index + 8; i < buttons.length; i += 8) {
			timer++;
			buttons[i].lights(timer);
		}
		timer = 0;
	}
	
	public void lightsUp(int index) {
		int timer = 0;
		for (int i = index - 8; i >= 0; i -= 8) {
			timer++;
			buttons[i].lights(timer);
		}
		timer = 0;
	}
	
	public void lightsRight(int index) {
		int timer = 0;
		for (int i = index + 1; i >= 0 && i % 8 > 0; i++) {
			timer++;
			buttons[i].lights(timer);
		}
		timer = 0;
	}
	
	public void lightsLeft(int index) {
		int timer = 0;
		for (int i = index - 1; i >= 0 && i % 8 < 7; i--) {
			timer++;
			buttons[i].lights(timer);
		}
		timer = 0;
	}
	
	public void lightsUpFull(int index) {
		int timer = 0;
		for (int i = index - 8; i >= 0; i -= 8) {
			timer++;
			for (int j = 0; j <= index / 8 - i / 8 && (j < 8 - i % 8 || j <= i % 8); j++) {
				if (j < 8 - i % 8) {
					buttons[i + j].lights(timer);
				}
				if (j <= i % 8) {
					buttons[i - j].lights(timer);
				}
			}
		}
		timer = 0;
	}
	
	public void lightsLeftFull(int index) {
		int timer = 0;
		for (int i = index - 1; i >= 0 && i % 8 < 7; i--) {
			timer++;
			for (int j = 0; j <= index - i && (j <= i / 8 || j < 4 - i / 8); j ++) {
				if (j < 4 - i / 8) {
					buttons[i + j*8].lights(timer);
				}
				if (j <= i / 8) {
					buttons[i - j*8].lights(timer);
				}
			}
		}
		timer = 0;
	}
	
	public void lightsRightFull(int index) {
		int timer = 0;
		for (int i = index + 1; i >= 0 && i % 8 > 0; i++) {
			timer++;
			for (int j = 0; j <= i - index && (j <= i / 8 || j < 4 - i / 8); j ++) {
				if (j < 4 - i / 8) {
					buttons[i + j*8].lights(timer);
				}
				if (j <= i / 8) {
					buttons[i - j*8].lights(timer);
				}
			}
		}
		timer = 0;
	}
	
	public void lightsDownFull(int index) {
		int timer = 0;
		for (int i = index + 8; i < buttons.length; i += 8) {
			timer++;
			for (int j = 0; j <= i / 8 - index / 8 && (j < 8 - i % 8 || j <= i % 8); j++) {
				if (j <= i % 8) {
					buttons[i - j].lights(timer);
				}
				if (j < 8 - i % 8) {
					buttons[i + j].lights(timer);
				}
			}
			
		}
		timer = 0;
	}
}
