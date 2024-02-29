package blazingforest.dashboard.vocab.french.unit5;

import blazingforest.render.Render;
import blazingforest.type.ImplementsR;
import blazingforest.type.TranslationExercise;

public class FrenchDays extends TranslationExercise {
	public FrenchDays(int width, int height, Render render, ImplementsR parent) {
		super(width, height, render, parent, "French - Days", "French");
		add("lundi", "monday");
		add("mardi", "tuesday");
		add("mercredi", "wednesday");
		add("jeudi", "thursday");
		add("vendredi", "friday");
		add("samedi", "saturday");
		add("dimanche", "sunday");
	}
}
