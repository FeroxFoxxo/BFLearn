package blazingforest.dashboard.vocab.french.unit5;

import blazingforest.render.Render;
import blazingforest.type.ImplementsR;
import blazingforest.type.TranslationExercise;

public class FrenchPresents extends TranslationExercise {
	public FrenchPresents(int width, int height, Render render, ImplementsR parent) {
		super(width, height, render, parent, "French - Talk About Presents", "French");
		add("voici un petit cadeau toi", "here is a present for you");
		add("c'est tres gentil", "thats very kind of you");
		add("merci beaucoup", "thanks a lot");
		add("de rien", "you're welcome");
		add("qu'est-ce qu'on t'a offert", "what were you given");
		add("on m'a offert des vetements", "i was given clothes");
	}
}
