package blazingforest.dashboard.vocab.latin;

import blazingforest.dashboard.vocab.latin.latin14.Latin14;
import blazingforest.dashboard.vocab.latin.latin58.Latin58;
import blazingforest.dashboard.vocab.latin.latin912.Latin912;
import blazingforest.render.Render;
import blazingforest.type.ImplementsR;
import blazingforest.type.Select;

public class Latin extends Select {
	public Latin(int width, int height, Render render, ImplementsR parent) {
		super(width, height, render, parent, "Latin");
		add((ImplementsR)new Latin14(width, height, render, (ImplementsR)this));
		add((ImplementsR)new Latin58(width, height, render, (ImplementsR)this));
		add((ImplementsR)new Latin912(width, height, render, (ImplementsR)this));
	}
}
