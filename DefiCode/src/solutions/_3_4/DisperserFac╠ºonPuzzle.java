package d�fis.solutions._3_4;

import java.util.function.Consumer;

import d�fis.essais._3_2.Cat�gorie;
import d�fis.essais._3_2.Participant;
import d�fis.essais._3_2.Course;
import d�fis.solutions._3_4.validation.ValidateurMenu;
import d�fis.solutions._3_4.validation.ValidateurParticipant;
import d�fis.solutions._3_4.validation.ValidationException;
import d�fis.solutions._3_4.vues.Vue;
import d�fis.solutions._3_4.vues.VueClassement;
import d�fis.solutions._3_4.vues.VueErreur;
import d�fis.solutions._3_4.vues.VueMenu;
import d�fis.solutions._3_4.vues.VueObjet;

public class DisperserFa�onPuzzle {
	
	private final static Console console = new Console();
	private static boolean fini = false;
	
	public static void main(String [] args) {
		Course course = new Course(args.length > 0 ? new Cat�gorie(args[0]) : null);
		Vue vueGagnant    = new VueObjet	 (() -> course.getGagnant());
		Vue vueClassement = new VueClassement(() -> course.getClassement()); 
		Menu menu = new Menu(
			new Menu.�l�ment("Inscrire quelqu'un", () -> traiterParticipant(p -> course.inscrire(p))			 , () -> inscriptionEnCours( course )),
			new Menu.�l�ment("D�marrer la course", () -> course.d�marrer()										 , () -> inscriptionEnCours( course )),			
			new Menu.�l�ment("Noter une arriv�e" , () -> traiterParticipant(p -> course.passerLaLigneDArriv�e(p)), () -> course.getClassement()!=null),
			
			new Menu.�l�ment("Classement"	, () -> console.afficher( vueClassement ), () -> courseTermin�e( course )),
			new Menu.�l�ment("Gagnant-e"	, () -> console.afficher( vueGagnant    ), () -> courseTermin�e( course )),			
			new Menu.�l�ment("Quitter"		, () -> fini=true)
		);
		Vue vueMenu = new VueMenu(menu);
		ValidateurMenu validMenu = new ValidateurMenu(menu);
		
		while( !fini ) {
			try {
				console.afficher( vueMenu );
				menu.get�l�ment(console.lire(validMenu).intValue()).ex�cuter();						
			}
			catch(ValidationException e) {
				console.afficher(new VueErreur(e.getMessage()));
			}				
		}
		console.afficher(new VueObjet(()->"Bye"));
		console.fermer();
	}
	private static void traiterParticipant(Consumer<Participant> traitement) {
		try {
			traitement.accept(console.lire(new ValidateurParticipant()));
		}
		catch(ValidationException e) {
			console.afficher(new VueErreur(e.getMessage()));
		}
	}	
	private static boolean inscriptionEnCours(Course c) {
		return c.getClassement()!=null;
	}
	private static boolean courseTermin�e(Course c) {
		return c.getClassement()!=null && c.getClassement().iterator().hasNext();
	}
}
