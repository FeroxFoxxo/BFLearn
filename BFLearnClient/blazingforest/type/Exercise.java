package blazingforest.type;

import blazingforest.input.InputEvent;
import blazingforest.render.Render;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise extends ImplementsR {
	public List<String> info = new ArrayList<>();
	
	public List<QAA> qaa = new ArrayList<>();
	
	public String input;
	
	public int curent;
	
	public boolean isCorrect = false;
	
	public State state;
	
	public enum State {
		info, question, answer;
	}
	
	public Exercise(int width, int height, Render render, ImplementsR parent, String name) {
		super(width, height, render, parent, name);
		this.curent = 0;
		this.state = State.info;
		this.input = "";
		this.type = ImplementsR.Type.exercise;
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
		if (this.state == State.info) {
			g.setFont(new Font("Calibri", 0, 64));
			drawCenteredString(this.name, g, 300);
			g.setFont(new Font("Calibri", 0, 36));
			for (int i = 0; i < this.info.size(); i++)
				drawCenteredString(this.info.get(i), g, 500 + i * 100); 
			g.setColor(new Color(220, 255, 220));
			g.fillRect(this.width / 12 * 5, this.height / 3 * 2, this.width / 6, 80);
			g.setColor(Color.BLACK);
			g.drawRect(this.width / 12 * 5, this.height / 3 * 2, this.width / 6, 80);
			drawCenteredString("Start", g, 1035);
		} else if (this.state == State.question) {
			g.setFont(new Font("Calibri", 0, 64));
			g.setColor(Color.BLACK);
			drawCenteredString(((QAA)this.qaa.get(this.curent)).getQuestion(), g, 420);
			g.setFont(new Font("Calibri", 0, 42));
			drawCenteredString(this.input, g, 700);
			g.drawRect(80, 320, this.width - 140, 60);
			g.setColor(new Color(220, 255, 220));
			g.fillRect(400, this.height / 5 * 3, this.width - 800, 100);
			g.setColor(Color.BLACK);
			g.drawRect(400, this.height / 5 * 3, this.width - 800, 100);
			drawCenteredString("Next", g, 950);
		} else if (this.state == State.answer) {
			g.setFont(new Font("Calibri", 0, 64));
			g.setColor(Color.BLACK);
			if (this.isCorrect) {
				drawCenteredString("Correct!", g, 550);
			} else if (!this.isCorrect) {
				drawCenteredString("Incorrect", g, 550);
				g.setFont(new Font("Calibri", 0, 32));
				drawCenteredString("The correct answer was : " + ((QAA)this.qaa.get(this.curent)).getAnswer(), g, 680);
			} 
			g.drawRect(450, 400, this.width - 900, 100);
			drawCenteredString("Next", g, 890);
		} 
	}
	
	public void register(InputEvent e) {
		if (e.input == InputEvent.InputState.mouse) {
			if (this.parent != null && 
				isMouseInDim(e.mouse, 0, 0, 120, 60))
				this.render.setCurrentClass(this.parent); 
			if (this.state == State.info) {
				Collections.shuffle(this.qaa);
				if (isMouseInDim(e.mouse, this.width / 12 * 5, this.height / 3 * 2, this.width / 6, 80)) {
					if (this.qaa.size() < 1)
						this.render.currentClass = this.parent; 
					this.state = State.question;
					this.curent = 0;
				} 
			} else if (this.state == State.question) {
				if (isMouseInDim(e.mouse, 400, this.height / 5 * 3, this.width - 800, 100))
					checkIfAnswerIsCorrect(); 
			} else if (this.state == State.answer) {
				if (isMouseInDim(e.mouse, 450, 400, this.width - 900, 100))
					checkIfCanContinue(); 
			} 
		} else if (e.input == InputEvent.InputState.key) {
			switch (e.key.getKeyCode()) {
				case 8:
					if (this.input != null && this.input.length() > 0)
						this.input = this.input.substring(0, this.input.length() - 1); 
					return;
				case 127:
					if (this.input != null && this.input.length() > 0)
						this.input = this.input.substring(0, this.input.length() - 1); 
					return;
				case 10:
					if (this.state == State.question) {
						checkIfAnswerIsCorrect();
					} else if (this.state == State.answer) {
						checkIfCanContinue();
					} 
					return;
			} 
			this.input = String.valueOf(this.input) + e.key.getKeyChar();
		} 
	}
	
	public void add(String question, String answer) {
		this.qaa.add(new QAA(question, answer));
	}
	
	public void add(String question, String answer, boolean v) {
		this.qaa.add(new QAA(question, answer));
	}
	
	public void checkIfAnswerIsCorrect() {
		if (((QAA)this.qaa.get(this.curent)).getAnswer().toLowerCase().equals(this.input.toLowerCase())) {
			this.curent++;
			this.input = "";
			this.isCorrect = true;
			this.state = State.answer;
		} else {
			this.isCorrect = false;
			this.state = State.answer;
		} 
	}
	
	public void checkIfCanContinue() {
		if (this.curent == this.qaa.size()) {
			this.render.setCurrentClass(this.parent);
			setPercentage(100);
		} 
		if (this.curent < this.qaa.size()) {
			this.input = "";
			this.state = State.question;
			setPercentage(100 / this.qaa.size() * this.curent);
		} else {
			this.render.setCurrentClass(this.parent);
			setPercentage(100);
		} 
	}
	
	public void open() {
		this.curent = 0;
		this.state = State.info;
	}
}
