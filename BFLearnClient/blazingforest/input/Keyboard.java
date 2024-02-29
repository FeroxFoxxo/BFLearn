package blazingforest.input;

import blazingforest.render.Render;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {
	private Render render;
	
	public Keyboard(Render render) {
		this.render = render;
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case 0:
			case 12:
			case 16:
			case 17:
			case 18:
			case 20:
			case 27:
			case 33:
			case 34:
			case 35:
			case 36:
			case 37:
			case 38:
			case 39:
			case 40:
			case 112:
			case 113:
			case 114:
			case 115:
			case 116:
			case 117:
			case 118:
			case 119:
			case 120:
			case 121:
			case 123:
			case 122:
			case 144:
			case 155:
			case 524:
				return;
		} 
		InputEvent inputEvent = new InputEvent();
		inputEvent.key = e;
		inputEvent.input = InputEvent.InputState.key;
		inputEvent.caps = Toolkit.getDefaultToolkit().getLockingKeyState(20);
		this.render.register(inputEvent);
	}
}
