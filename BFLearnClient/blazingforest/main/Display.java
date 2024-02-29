package blazingforest.main;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display extends Canvas {
	private static final long serialVersionUID = 333527589333544306L;
	
	public Display(int width, int height, Main parent) {
		JFrame frame = new JFrame("BFLearn");
		Dimension size = new Dimension(width, height);
		frame.setSize(size);
		frame.setMaximumSize(size);
		frame.setMinimumSize(size);
		frame.setPreferredSize(size);
		frame.setDefaultCloseOperation(3);
		frame.setResizable(false);
		frame.setLocationRelativeTo((Component)null);
		frame.add(parent);
		frame.setVisible(true);
	}
}
