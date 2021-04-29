package défis.solutions._3_2;

import défis.solutions._3_2.états.Arrivée;
import défis.solutions._3_2.états.ContexteCourse;
import défis.solutions._3_2.états.EnCours;
import défis.solutions._3_2.états.EtatCourse;
import défis.solutions._3_2.états.Inscription;

public class Course {
	public final static int
		INSCRIPTION = 0,
		EN_COURS = 1,
		ARRIVEE = 2;
	private final ContexteCourse contexte = new ContexteCourse();
	private final Catégorie catégorie;
	private EtatCourse état =
		new Inscription(INSCRIPTION, contexte, 
			new EnCours(EN_COURS   , contexte,
				new Arrivée(ARRIVEE, contexte)
			)
		);
			
	public Course(Catégorie catégorie) {
		if(catégorie==null) {
			throw new NullPointerException("La catégorie doit être renseignée");
		}
		this.catégorie = catégorie;
	}
	public Catégorie getCatégorie() {
		return catégorie; 
	}
	public int getÉtat() {
		return this.état.getId();
	}
	public Iterable<Participant> getInscrits() {
		return état.getClassement();
	}
	public Iterable<Participant> getClassement() {
		return état.getClassement();
	}
	public Participant getGagnant() {
		return état.getGagnant();
	}
	public void inscrire(Participant participant) {
		état = état.inscrire(participant);
	}
	public void démarrer() {
		état = état.démarrer();
	}
	public void passerLaLigneDArrivée(Participant participant) {
		état = état.passerLaLigneDArrivée(participant);
	}	
}
