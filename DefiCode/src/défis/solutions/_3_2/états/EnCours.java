package d�fis.solutions._3_2.�tats;

import d�fis.solutions._3_2.Participant;

public class EnCours extends EtatCourse {

	private EtatCourse suivant;
	
	public EnCours(int id, ContexteCourse contexte, EtatCourse suivant) {
		super(id, contexte);
		this.suivant = suivant;
	}

	@Override
	public Iterable<Participant> getClassement() {
		throw new IllegalStateException("La course n'est pas termin�e");
	}

	@Override
	public Participant getGagnant() {
		throw new IllegalStateException("La course n'est pas termin�e");
	}

	@Override
	public EtatCourse inscrire(Participant participant) {
		throw new IllegalStateException("Inscriptions ferm�es, la course est commenc�e");
	}

	@Override
	public EtatCourse d�marrer() {
		throw new IllegalStateException("La course est d�j� d�marr�e");
	}

	@Override
	public EtatCourse passerLaLigneDArriv�e(Participant participant) {
		return suivant.passerLaLigneDArriv�e(participant);
	}	
}
