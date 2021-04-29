package d�fis.solutions._3_4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Menu {
	private List<�l�ment> �l�ments;
	
	public Menu(�l�ment...�l�ments) {
		this.�l�ments = Arrays.asList(�l�ments);
	}
	public Iterable<�l�ment> get�l�ments() {
		return �l�ments;
	}
	public �l�ment get�l�ment(int indice) {
		return �l�ments.get(indice);
	}
	public static class �l�ment {
		private String titre;
		private Runnable action;
		private Supplier<Boolean> activer;
		
		public �l�ment(String titre, Runnable action, Supplier<Boolean> activer) {
			this.titre = titre;
			this.action = action;
			this.activer = activer;
		}
		public �l�ment(String titre, Runnable action) {
			this(titre, action, () -> true);
		}
		public String toString() {
			return titre;
		}
		public void ex�cuter() {
			action.run();
		}
		public boolean estActif() {
			return activer.get().booleanValue();
		}
	}	
}
