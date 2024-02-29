package blazingforest.type;

import blazingforest.input.InputEvent;
import blazingforest.render.Render;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public abstract class Select extends ImplementsR {
	public List<String> names = new ArrayList<>();
	
	public List<ImplementsR> classRedir = new ArrayList<>();
	
	public Select(int width, int height, Render render, ImplementsR parent, String name) {
		super(width, height, render, parent, name);
		this.type = ImplementsR.Type.select;
	}
	
	public void open() {}
	
	public void render(Graphics2D g) {
		g.setColor(new Color(255, 240, 190));
		g.fillRect(0, 60, this.width, this.height);
		g.setColor(Color.WHITE);
		g.fillRect(100, 120, this.width - 200, this.height - 240);
		g.setColor(new Color(200, 220, 255));
		g.fillRect(100, 120, this.width - 200, 60);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Calibri", 1, 36));
		g.drawString(this.name, 120, 162);
		g.setFont(new Font("Calibri", 0, 30));
		for (int i = 0; i < this.names.size(); i++) {
			g.drawString(String.valueOf(i + 1) + ". " + (String)this.names.get(i), 140, 230 + i * 50);
			g.drawString(">", this.width - 150, 230 + i * 50);
			if (((ImplementsR)this.classRedir.get(i)).type != ImplementsR.Type.select)
				g.drawString(String.valueOf(((ImplementsR)this.classRedir.get(i)).getPercentage()) + "%", this.width - 250, 230 + i * 50); 
		} 
		g.setColor(new Color(210, 210, 210));
		g.fillRect(0, 0, this.width, 60);
		g.setFont(new Font("Calibri", 1, 36));
		g.setColor(Color.BLACK);
		g.drawString("BFLearn", 20, 40);
		g.setFont(new Font("Calibri", 1, 30));
		if (this.parent != null)
			g.drawString("Back", 300, 40); 
	}
	
	public void register(InputEvent e) {
		if (e.input == InputEvent.InputState.mouse) {
			for (int i = 0; i < this.names.size(); i++) {
				if (isMouseInDim(e.mouse, 120, 195 + i * 50, this.width - 235, 50))
					this.render.setCurrentClass(this.classRedir.get(i)); 
			} 
			if (this.parent != null) {
				if (isMouseInDim(e.mouse, 280, 0, 100, 60))
					this.render.setCurrentClass(this.parent); 
				if (isMouseInDim(e.mouse, 0, 0, 160, 60)) {
					ImplementsR dashboard = this.parent;
					while (dashboard.parent != null)
						dashboard = dashboard.parent; 
					this.render.currentClass = dashboard;
				} 
			} 
		} 
	}
	
	public void add(ImplementsR implementsR) {
		this.names.add(implementsR.name);
		this.classRedir.add(implementsR);
	}
}
