package défis.solutions._3_4;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import défis.solutions._3_4.validation.Validateur;
import défis.solutions._3_4.validation.ValidationException;
import défis.solutions._3_4.vues.Vue;

public class Console {
	private Scanner clavier = new Scanner(System.in);
	
	public void fermer() {
		clavier.close();
	}
	public <T> T lire(Validateur<T> validateur) throws ValidationException {
		return validateur.convertir(clavier.next());
	}
	public void afficher(Vue vue) {
		try {
			vue.rendre(
				new OutputStreamWriter(System.out),
				new OutputStreamWriter(System.err)
			);
		} catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
		}	
	}
}
