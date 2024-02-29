package blazingforest.dashboard.vocab.latin.latin912;

import blazingforest.render.Render;
import blazingforest.type.ImplementsR;
import blazingforest.type.Select;

public class Latin912 extends Select {
	public Latin912(int width, int height, Render render, ImplementsR parent) {
		super(width, height, render, parent, "Latin - Units 9-12");
		add((ImplementsR)new LatinUnit9(width, height, render, (ImplementsR)this));
		add((ImplementsR)new LatinUnit10(width, height, render, (ImplementsR)this));
	}
}
