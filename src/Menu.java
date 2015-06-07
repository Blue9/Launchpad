// Copyright GM.

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JPanel {
	private ImageIcon logoImg = new ImageIcon(
			Menu.class.getResource("img/logo.png"));
	private ImageIcon bgIcon = new ImageIcon(
			Menu.class.getResource("img/bg.png"));
	private Image bg = bgIcon.getImage();
	private JLabel logo;
	private JButton browse;
	private JButton start;
	private File dir;
	private JFileChooser browser;
	private Control reference;

	public Menu(Control control) {
		super();
		reference = control; // needed to call method of Control object
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		logo = new JLabel(logoImg);
		logo.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		browser = new JFileChooser();
		browser.setDialogTitle("Select folder");
		browser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		browser.setCurrentDirectory(new File("."));
		browser.setAcceptAllFileFilterUsed(false);

		browse = newButton("Browse");
		start = newButton("Start");
		browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (browser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					dir = browser.getSelectedFile();
					browse.setFont(new Font("Arial", Font.ITALIC, 20));
					browse.setText("Loading...");
					Sound.init(dir);
					while (!Sound.initialized()) {
					}
					browse.setText("Loaded " + dir.getAbsolutePath());
				}
				;
			}
		});
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (dir == null) {		// If no song was selected
					Sound.init(null);	// Initialize Bangarang (default)
					while (!Sound.initialized()) {
					}
				}
				reference.start(dir);
			}
		});

		add(logo);
		add(Box.createVerticalGlue());
		add(browse);
		add(Box.createVerticalGlue());
		add(start);

		setBorder(new EmptyBorder(60, 0, 60, 0));
		setPreferredSize(new Dimension(Control.lWidth(), Control.lHeight()));
		setFocusable(false);
	}

	public JButton newButton(String title) {
		JButton button = new JButton(title);
		button.setFont(new Font("Arial", Font.BOLD, 24));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 51, 102));
		button.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 48), 4));
		button.setAlignmentX(JButton.CENTER_ALIGNMENT);
		button.setPreferredSize(new Dimension(800, 100));
		button.setMaximumSize(new Dimension(800, 100));
		button.setFocusPainted(false);
		button.setFocusable(false);
		return button;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, null);
	}

}