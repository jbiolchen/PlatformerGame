import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class gPanel extends JPanel {

	final Dimension dim;
	private Timer t;
	private gMap m = new gMap();
	public static final double DELTA_TIME = 1.0 / 30.0; // # seconds between ticks; 30 ticks/s
	public static final double SCALE = 20; // 20 pixels = 1 meter

	public gPanel(Dimension d) {
		this.dim = d;
		this.setPreferredSize(dim);
		Color c = new Color(122, 173, 255);
		this.setBackground(c);
		makeMap();
		setUpKeyMappings();
		t.start();
	}

	private void makeMap() {
		t = new Timer((int) (DELTA_TIME * 1000), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				m.tick();
				repaint();
			}
		});
	}

	private void setUpKeyMappings() {
		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "fly");
		this.getActionMap().put("fly", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "left");
		this.getActionMap().put("left", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//gMap.s.left();
			}
		});
		this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "right");
		this.getActionMap().put("right", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//gMap.s.right();
			}
		});
		this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "down");
		this.getActionMap().put("down", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//gMap.s.down();
			}
		});
		this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "up");
		this.getActionMap().put("up", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//gMap.s.up();
			}
		});

		this.getInputMap().put(KeyStroke.getKeyStroke("released UP"), "stopVert");
		this.getInputMap().put(KeyStroke.getKeyStroke("released DOWN"), "stopVert");
		this.getActionMap().put("stopVert", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.getInputMap().put(KeyStroke.getKeyStroke("released LEFT"), "stopHoriz");
		this.getInputMap().put(KeyStroke.getKeyStroke("released RIGHT"), "stopHoriz");
		this.getActionMap().put("stopHoriz", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.requestFocusInWindow();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		m.draw(g);
	}
}
