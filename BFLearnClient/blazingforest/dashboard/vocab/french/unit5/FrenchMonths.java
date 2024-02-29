package blazingforest.dashboard.vocab.french.unit5;

import blazingforest.render.Render;
import blazingforest.type.ImplementsR;
import blazingforest.type.TranslationExercise;

public class FrenchMonths extends TranslationExercise {
	public FrenchMonths(int width, int height, Render render, ImplementsR parent) {
		super(width, height, render, parent, "French - Months", "French");
		add("janvier", "january");
		add("fevrier", "february");
		add("mars", "march");
		add("avril", "april");
		add("mai", "may");
		add("juin", "june");
		add("julliet", "july");
		add("aout", "august");
		add("septembre", "september");
		add("octobre", "october");
		add("novembre", "november");
		add("decembre", "december");
	}
}
