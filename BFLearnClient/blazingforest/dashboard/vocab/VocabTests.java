package blazingforest.dashboard.vocab;

import blazingforest.dashboard.vocab.french.French;
import blazingforest.dashboard.vocab.latin.Latin;
import blazingforest.render.Render;
import blazingforest.type.ImplementsR;
import blazingforest.type.Select;

public class VocabTests extends Select {
	public VocabTests(int width, int height, Render render, ImplementsR parent) {
		super(width, height, render, parent, "Vocabulary Tests");
		add((ImplementsR)new Latin(width, height, render, (ImplementsR)this));
		add((ImplementsR)new French(width, height, render, (ImplementsR)this));
	}
}
