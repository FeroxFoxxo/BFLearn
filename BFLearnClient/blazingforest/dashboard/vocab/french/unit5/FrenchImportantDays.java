package blazingforest.dashboard.vocab.french.unit5;

import blazingforest.render.Render;
import blazingforest.type.ImplementsR;
import blazingforest.type.TranslationExercise;

public class FrenchImportantDays extends TranslationExercise {
	public FrenchImportantDays(int width, int height, Render render, ImplementsR parent) {
		super(width, height, render, parent, "French - Important Days", "French");
		add("le jour de l'an", "new years day");
		add("la Fete Nationale", "french national day");
		add("paques", "easter");
		add("noel", "christmas");
		add("mardi gras", "shrove tuesday");
		add("las saint valentin", "valentines day");
		add("l'anniversaire de", "'s birthday");
		add("ma fete", "my name day");
		add("la fete des meres", "mothers day");
		add("la fete des peres", "fathers day");
	}
}
