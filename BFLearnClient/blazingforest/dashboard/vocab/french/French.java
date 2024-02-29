package blazingforest.dashboard.vocab.french;

import blazingforest.dashboard.vocab.french.unit5.FrenchUnit5;
import blazingforest.render.Render;
import blazingforest.type.ImplementsR;
import blazingforest.type.Select;

public class French extends Select {
	public French(int width, int height, Render render, ImplementsR parent) {
		super(width, height, render, parent, "French");
		add((ImplementsR)new FrenchUnit5(width, height, render, (ImplementsR)this));
	}
}
