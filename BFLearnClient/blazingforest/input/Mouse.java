package blazingforest.input;

import blazingforest.render.Render;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {
	private Render render;
	
	public Mouse(Render render) {
		this.render = render;
	}
	
	public void mousePressed(MouseEvent e) {
		InputEvent inputEvent = new InputEvent();
		inputEvent.mouse = e;
		inputEvent.input = InputEvent.InputState.mouse;
		this.render.register(inputEvent);
	}
}
