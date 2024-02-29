package blazingforest.dashboard.vocab.latin.latin14;

import blazingforest.render.Render;
import blazingforest.type.ImplementsR;
import blazingforest.type.TranslationExercise;

public class LatinUnit1 extends TranslationExercise {
	public LatinUnit1(int width, int height, Render render, ImplementsR parent) {
		super(width, height, render, parent, "Latin - Unit 1", "Latin");
		add("canis", "dog");
		add("coquus", "cook");
		add("est", "is");
		add("filius", "son");
		add("hortus", "garden");
		add("in", "in");
		add("laborat", "works");
		add("mater", "mother");
		add("pater", "father");
		add("sedet", "sits");
		add("servus", "slave");
		add("via", "street");
	}
}
