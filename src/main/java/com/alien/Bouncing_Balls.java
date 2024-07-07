package com.alien;

import java.awt.*;
import java.awt.event.*;

public class Bouncing_Balls extends Frame implements MouseListener {
	int x = 40, y = 40, t1 = 1, t2 = 1;
	int x1 = 200, y1 = 40, t12 = 1, t22 = 1;
	int x2 = 100, y2 = 100, t13 = 1, t23 = 1;
	Thread th;

	Bouncing_Balls() {
		setSize(700, 800);
		setVisible(true);

		// Creating a new Thread
		th = new Thread(new Thread() {
			public void run() {
				while (true) {
					x = x + t1;
					y = y + t2;
					x1 = x1 + t12;
					y1 = y1 + t22;
					x2 = x2 - t13;
					y2 = y2 - t23;

					if (x < 0 || x > 680)
						t1 = t1 * (-1);
					if (y < 20 || y > 780)
						t2 = t2 * (-1);
					if (x1 < 0 || x1 > 680)
						t12 = t12 * (-1);
					if (y1 < 20 || y1 > 780)
						t22 = t22 * (-1);
					if (x2 < 0 || x2 > 680)
						t13 = t13 * (-1);
					if (y2 < 20 || y2 > 780)
						t23 = t23 * (-1);

					try {
						// Calling sleep method
						this.sleep(5);
					} catch (Exception E) {
					}
					repaint();
				}
			}
		});
		addMouseListener(this);
	}

	public void mouseClicked(MouseEvent M) {
		// Thread will start when mouse is clicked
		th.start();
	}

	public void mousePressed(MouseEvent M) {
	}

	public void mouseReleased(MouseEvent M) {
	}

	public void mouseEntered(MouseEvent M) {
	}

	public void mouseExited(MouseEvent M) {
	}

	public void paint(Graphics g) {
		g.setColor(Color.pink);
		g.fillOval(x, y, 40, 40);
		g.setColor(Color.pink);
		g.fillOval(x1, y1, 40, 40);
		g.setColor(Color.pink);
		g.fillOval(x2, y2, 40, 40);
	}

	public static void main(String[] args) {
		Bouncing_Balls B = new Bouncing_Balls();
	}
}
