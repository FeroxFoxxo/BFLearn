package blazingforest.type;

import blazingforest.input.InputEvent;
import blazingforest.render.Render;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public abstract class Info extends ImplementsR {
	public List<String> content = new ArrayList<>();
	
	public List<Integer> catagory = new ArrayList<>();
	
	public int curent;
	
	public int amount;
	
	public Info(int width, int height, Render render, ImplementsR parent, String name) {
		super(width, height, render, parent, name);
		this.type = ImplementsR.Type.select;
	}
	
	public void open() {
		this.curent = 1;
		this.amount = 0;
		int last = 0;
		for (int i = 0; i < this.catagory.size(); i++) {
			if (last != ((Integer)this.catagory.get(i)).intValue()) {
				last = ((Integer)this.catagory.get(i)).intValue();
				this.amount++;
			} 
		} 
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 60, this.width, this.height);
		g.setColor(new Color(255, 240, 190));
		g.fillRect(0, 0, this.width, 60);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Calibri", 1, 30));
		g.drawString("Exit", 30, 40);
		g.setFont(new Font("Calibri", 0, 36));
		drawCenteredString(this.name, g, 60);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Calibri", 0, 24));
		int h = 0;
		for (int i = 0; i < this.catagory.size(); i++) {
			if (((Integer)this.catagory.get(i)).intValue() == this.curent) {
				h++;
				drawCenteredString(this.content.get(i), g, (h + 1) * 100);
			} 
		} 
		g.setColor(new Color(220, 220, 220));
		g.fillRect(0, this.height - 100, this.width, 70);
		g.setColor(new Color(220, 230, 255));
		g.fillRect(0, this.height - 100, 280, 70);
		int percent = this.curent * 100 / this.amount;
		g.setFont(new Font("Calibri", 0, 30));
		g.setColor(Color.BLACK);
		g.drawString(String.valueOf(percent) + "% Overall", 60, this.height - 60);
		if (this.curent != 1) {
			g.setColor(new Color(230, 255, 230));
			g.fillRect(this.width - 400, this.height - 100, 400, 60);
			g.setColor(new Color(220, 220, 220));
			g.fillRect(this.width - 200, this.height - 85, 5, 100);
			g.setColor(Color.BLACK);
			if (this.curent == this.amount) {
				g.drawString("Exit", this.width - 130, this.height - 60);
			} else {
				g.drawString("Next", this.width - 140, this.height - 60);
			} 
			g.drawString("Back", this.width - 330, this.height - 60);
		} else {
			g.setColor(new Color(220, 255, 220));
			g.fillRect(this.width - 200, this.height - 100, 200, 60);
			g.setColor(Color.BLACK);
			g.drawString("Next", this.width - 140, this.height - 60);
		} 
	}
	
	public void register(InputEvent e) {
		if (e.input == InputEvent.InputState.mouse) {
			if (this.parent != null && 
				isMouseInDim(e.mouse, 0, 0, 120, 60))
				this.render.setCurrentClass(this.parent); 
			if (isMouseInDim(e.mouse, this.width - 200, this.height - 100, 200, 60))
				if (this.curent == this.amount) {
					this.render.setCurrentClass(this.parent);
				} else {
					this.curent++;
				}	
			if (isMouseInDim(e.mouse, this.width - 400, this.height - 100, 200, 60) && 
				this.curent != 1)
				this.curent--; 
		} 
	}
	
	public void add(String string, int i) {
		this.content.add(string);
		this.catagory.add(Integer.valueOf(i));
	}
}
