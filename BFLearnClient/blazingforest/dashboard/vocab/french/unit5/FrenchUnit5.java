package blazingforest.dashboard.vocab.french.unit5;

import blazingforest.render.Render;
import blazingforest.type.ImplementsR;
import blazingforest.type.Select;

public class FrenchUnit5 extends Select {
	public FrenchUnit5(int width, int height, Render render, ImplementsR parent) {
		super(width, height, render, parent, "French - Unit 5");
		add((ImplementsR)new FrenchMonths(width, height, render, (ImplementsR)this));
		add((ImplementsR)new FrenchDays(width, height, render, (ImplementsR)this));
		add((ImplementsR)new FrenchImportantDays(width, height, render, (ImplementsR)this));
		add((ImplementsR)new FrenchImportantPhrases(width, height, render, (ImplementsR)this));
		add((ImplementsR)new FrenchPresents(width, height, render, (ImplementsR)this));
	}
}
