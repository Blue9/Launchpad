// Copyright GM.
// bg.jpg acquired from http://sandeep-m.deviantart.com/art/recycled-texture-background-380260449

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Menu extends JPanel {
	ImageIcon logoImg = new ImageIcon(Menu.class.getResource("img/logo.png"));
	ImageIcon bgIcon = new ImageIcon(Menu.class.getResource("img/bg.jpg"));
	Image bg = bgIcon.getImage();
	JLabel logo;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	JButton firstOfTheYear;
	JButton bangarang;
	
	Control reference;
	
	public Menu(Control control) {
		super();
		reference = control; // needed to call method of Control object
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		logo = new JLabel(logoImg);
		logo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		// Call newButton() here.
		// Usage: newButton(title of song, name of folder containing sound files)
		newButton("First of the Year", "foty");
		newButton("Bangarang", "bangarang");
		
		add(logo);
		for (JButton button : buttons) {
			add(Box.createVerticalGlue());
			add(button);
		}
		
		setBorder(new EmptyBorder(60, 0, 60, 0));
		setPreferredSize(new Dimension(Control.lWidth(), Control.lHeight()));
		setFocusable(false);
	}
	
	public void newButton(String title, String folder) {
		JButton button = new JButton(title);
		button.setAlignmentX(JButton.CENTER_ALIGNMENT);
		button.setPreferredSize(new Dimension(800, 100));
		button.setMaximumSize(new Dimension(800, 100));
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				reference.start(folder);
			}
		});
		button.setFocusable(false);
		buttons.add(button);
	}
	
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(bg, 0, 0, null);
	}
	
}
