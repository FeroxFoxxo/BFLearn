package blazingforest.dashboard.vocab.latin.latin58;

import blazingforest.render.Render;
import blazingforest.type.ImplementsR;
import blazingforest.type.Select;

public class Latin58 extends Select {
	public Latin58(int width, int height, Render render, ImplementsR parent) {
		super(width, height, render, parent, "Latin - Units 5-8");
		add((ImplementsR)new LatinUnit5(width, height, render, (ImplementsR)this));
		add((ImplementsR)new LatinUnit6(width, height, render, (ImplementsR)this));
		add((ImplementsR)new LatinUnit7(width, height, render, (ImplementsR)this));
		add((ImplementsR)new LatinUnit8(width, height, render, (ImplementsR)this));
	}
}
