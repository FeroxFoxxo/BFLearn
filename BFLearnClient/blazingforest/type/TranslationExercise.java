package blazingforest.type;

import blazingforest.render.Render;

public abstract class TranslationExercise extends Exercise {
	private String lang = "";
	
	public TranslationExercise(int width, int height, Render render, ImplementsR parent, String name, String language) {
		super(width, height, render, parent, name);
		this.lang = language;
	}
	
	public void add(String question, String answer) {
		add("What is '" + question + "' in English?", answer, true);
		add("What is '" + answer + "' in " + this.lang + "?", question, true);
	}
}
