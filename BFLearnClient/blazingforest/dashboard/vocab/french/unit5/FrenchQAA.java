package blazingforest.dashboard.vocab.french.unit5;

import blazingforest.render.Render;
import blazingforest.type.ImplementsR;
import blazingforest.type.TranslationExercise;

public class FrenchQAA extends TranslationExercise {
	public FrenchQAA(int width, int height, Render render, ImplementsR parent) {
		super(width, height, render, parent, "French - Q&A", "French");
		add("le combien sommes-nous", "whats the date");
		add("nous sommes le deux mai", "it's the 2nd or may");
		add("quelle est la date aujourd'hui", "what's the date today");
		add("c'est le trente aout", "it's the 30th of august");
	}
}
