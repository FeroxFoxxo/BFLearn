package blazingforest.type;

import blazingforest.input.InputEvent;
import blazingforest.render.Render;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public abstract class ImplementsR {
	private int percentage = 0;
	
	public int width;
	
	public int height;
	
	public Render render;
	
	public String name;
	
	public ImplementsR parent;
	
	public Type type;
	
	public enum Type {
		exercise, info, select;
	}
	
	public ImplementsR(int width, int height, Render render, ImplementsR parent, String name) {
		this.width = width;
		this.height = height;
		this.render = render;
		this.parent = parent;
		this.name = name;
		this.percentage = 0;
	}
	
	public abstract void open();
	
	public abstract void render(Graphics2D paramGraphics2D);
	
	public abstract void register(InputEvent paramInputEvent);
	
	public boolean isMouseInDim(MouseEvent e, int x, int y, int w, int h) {
		if (e.getX() > x && e.getX() < x + w) {
			if (e.getY() > y && e.getY() < y + h)
				return true; 
			return false;
		} 
		return false;
	}
	
	public void drawCenteredString(String string, Graphics2D g, int h) {
		FontMetrics fm = g.getFontMetrics();
		int x = (this.width - fm.stringWidth(string)) / 2;
		int y = fm.getAscent() + (h - fm.getAscent() + fm.getDescent()) / 2;
		g.drawString(string, x, y);
	}
	
	public int getPercentage() {
		return this.percentage;
	}
	
	public void setPercentage(int percent) {
		this.percentage = percent;
	}
}
