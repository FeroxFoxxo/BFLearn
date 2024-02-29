package blazingforest.main;

import blazingforest.input.Keyboard;
import blazingforest.input.Mouse;
import blazingforest.render.Render;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main extends Canvas {
	private static final long serialVersionUID = 5650672376092945488L;
	
	private int width = 1280;
	
	private int height = 720;
	
	private Render render;
	
	private Mouse mouse;
	
	private Keyboard keyboard;
	
	private BufferedImage frame;
	
	public Main() {
		init();
	}
	
	public void init() {
		this.render = new Render(this.width, this.height);
		this.mouse = new Mouse(this.render);
		addMouseListener((MouseListener)this.mouse);
		this.keyboard = new Keyboard(this.render);
		addKeyListener((KeyListener)this.keyboard);
		Runnable frameGrabber = new Runnable() {
				public void run() {
					Main.this.repaint();
					Main.this.getFrame();
				}
			};
		ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
		timer.scheduleAtFixedRate(frameGrabber, 0L, 20L, TimeUnit.MILLISECONDS);
	}
	
	public void update(Graphics gfx) {
		gfx.drawImage(this.frame, 0, 0, this);
	}
	
	public void getFrame() {
		BufferedImage bufferedImage = new BufferedImage(this.width, this.height, 1);
		Graphics2D g = bufferedImage.createGraphics();
		Map<?, ?> desktopHints = (Map<?, ?>)Toolkit.getDefaultToolkit().getDesktopProperty("awt.font.desktophints");
		if (desktopHints != null)
			g.setRenderingHints(desktopHints); 
		this.render.render(g);
		g.dispose();
		this.frame = bufferedImage;
	}
	
	public static void main(String[] args) {}
}
