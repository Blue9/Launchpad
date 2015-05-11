// Copyright GM.

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JButton firstOfTheYear;
	JButton bangarang;
	
	Control reference;
	
	public Menu(Control control) {
		super();
		reference = control;
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		logo = new JLabel(logoImg);
		firstOfTheYear = new JButton("First of the Year");
		bangarang = new JButton("Bangarang");
		
		logo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		firstOfTheYear.setAlignmentX(JButton.CENTER_ALIGNMENT);
		bangarang.setAlignmentX(JButton.CENTER_ALIGNMENT);

		firstOfTheYear.setPreferredSize(new Dimension(800, 100));
		firstOfTheYear.setMaximumSize(new Dimension(800, 100));
		//firstOfTheYear.setBackground(Color.BLACK);
		//firstOfTheYear.setFont(Font.getFont("0"));
		
		bangarang.setPreferredSize(new Dimension(800, 100));
		bangarang.setMaximumSize(new Dimension(800, 100));

		
		firstOfTheYear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				reference.start("foty");
			}
		});
		
		bangarang.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				reference.start("bangarang");
			}
		});
		
		add(logo);
		add(Box.createVerticalGlue());
		add(firstOfTheYear);
		add(Box.createVerticalGlue());
		add(bangarang);
		
		firstOfTheYear.setFocusable(false);
		bangarang.setFocusable(false);
		
		setBorder(new EmptyBorder(60, 0, 60, 0));

		setPreferredSize(new Dimension(Control.lWidth(), Control.lHeight()));
		setFocusable(false);
	}
	
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(bg, 0, 0, null);
	}
	
}
