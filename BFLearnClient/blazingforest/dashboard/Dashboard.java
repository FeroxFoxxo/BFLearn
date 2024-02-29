package blazingforest.dashboard;

import blazingforest.dashboard.vocab.VocabTests;
import blazingforest.render.Render;
import blazingforest.type.ImplementsR;
import blazingforest.type.Select;

public class Dashboard extends Select {
	public Dashboard(int width, int height, Render render) {
		super(width, height, render, null, "Dashboard");
		add((ImplementsR)new VocabTests(width, height, render, (ImplementsR)this));
	}
}
