package blazingforest.dashboard.vocab.french.unit5;

import blazingforest.render.Render;
import blazingforest.type.ImplementsR;
import blazingforest.type.TranslationExercise;

public class FrenchImportantPhrases extends TranslationExercise {
	public FrenchImportantPhrases(int width, int height, Render render, ImplementsR parent) {
		super(width, height, render, parent, "French - Important Phrases", "French");
		add("bonne annee", "happy new year");
		add("joyeuses paques", "happy easter");
		add("joyeux noel", "happy christmas");
		add("bon anniversaire", "happy birthday");
		add("bonne fete", "best wishes on your name day");
	}
}
