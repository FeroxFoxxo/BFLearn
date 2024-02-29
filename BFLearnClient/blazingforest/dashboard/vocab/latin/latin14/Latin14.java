package blazingforest.dashboard.vocab.latin.latin14;

import blazingforest.render.Render;
import blazingforest.type.ImplementsR;
import blazingforest.type.Select;

public class Latin14 extends Select {
	public Latin14(int width, int height, Render render, ImplementsR parent) {
		super(width, height, render, parent, "Latin - Units 1-4");
		add((ImplementsR)new LatinUnit1(width, height, render, (ImplementsR)this));
		add((ImplementsR)new LatinUnit2(width, height, render, (ImplementsR)this));
		add((ImplementsR)new LatinUnit3(width, height, render, (ImplementsR)this));
		add((ImplementsR)new LatinUnit4(width, height, render, (ImplementsR)this));
	}
}
