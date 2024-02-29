package blazingforest.render;

import blazingforest.dashboard.Dashboard;
import blazingforest.input.InputEvent;
import blazingforest.type.ImplementsR;
import java.awt.Graphics2D;

public class Render {
	public ImplementsR currentClass;
	
	public Render(int width, int height) {
		this.currentClass = (ImplementsR)new Dashboard(width, height, this);
	}
	
	public void render(Graphics2D g) {
		this.currentClass.render(g);
	}
	
	public void register(InputEvent e) {
		this.currentClass.register(e);
	}
	
	public void setCurrentClass(ImplementsR currentClass) {
		currentClass.open();
		this.currentClass = currentClass;
	}
}
