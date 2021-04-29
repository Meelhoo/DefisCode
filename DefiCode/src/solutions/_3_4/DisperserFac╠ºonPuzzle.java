package défis.solutions._3_4;

import java.util.function.Consumer;

import défis.essais._3_2.Catégorie;
import défis.essais._3_2.Participant;
import défis.essais._3_2.Course;
import défis.solutions._3_4.validation.ValidateurMenu;
import défis.solutions._3_4.validation.ValidateurParticipant;
import défis.solutions._3_4.validation.ValidationException;
import défis.solutions._3_4.vues.Vue;
import défis.solutions._3_4.vues.VueClassement;
import défis.solutions._3_4.vues.VueErreur;
import défis.solutions._3_4.vues.VueMenu;
import défis.solutions._3_4.vues.VueObjet;

public class DisperserFaçonPuzzle {
	
	private final static Console console = new Console();
	private static boolean fini = false;
	
	public static void main(String [] args) {
		Course course = new Course(args.length > 0 ? new Catégorie(args[0]) : null);
		Vue vueGagnant    = new VueObjet	 (() -> course.getGagnant());
		Vue vueClassement = new VueClassement(() -> course.getClassement()); 
		Menu menu = new Menu(
			new Menu.Élément("Inscrire quelqu'un", () -> traiterParticipant(p -> course.inscrire(p))			 , () -> inscriptionEnCours( course )),
			new Menu.Élément("Démarrer la course", () -> course.démarrer()										 , () -> inscriptionEnCours( course )),			
			new Menu.Élément("Noter une arrivée" , () -> traiterParticipant(p -> course.passerLaLigneDArrivée(p)), () -> course.getClassement()!=null),
			
			new Menu.Élément("Classement"	, () -> console.afficher( vueClassement ), () -> courseTerminée( course )),
			new Menu.Élément("Gagnant-e"	, () -> console.afficher( vueGagnant    ), () -> courseTerminée( course )),			
			new Menu.Élément("Quitter"		, () -> fini=true)
		);
		Vue vueMenu = new VueMenu(menu);
		ValidateurMenu validMenu = new ValidateurMenu(menu);
		
		while( !fini ) {
			try {
				console.afficher( vueMenu );
				menu.getÉlément(console.lire(validMenu).intValue()).exécuter();						
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
	private static boolean courseTerminée(Course c) {
		return c.getClassement()!=null && c.getClassement().iterator().hasNext();
	}
}
