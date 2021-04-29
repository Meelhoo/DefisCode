package d�fis.solutions._3_2.�tats;

import java.util.List;

import d�fis.solutions._3_2.Participant;

public class Inscription extends EtatCourse {
	EtatCourse suivant;
	
	public Inscription(int id, ContexteCourse contexte, EtatCourse suivant) {
		super(id, contexte);
		this.suivant = suivant;
	}

	@Override
	public Iterable<Participant> getClassement() {
		throw new IllegalStateException("La course n'a pas d�marr�, inscriptions en cours");
	}

	@Override
	public Participant getGagnant() {
		throw new IllegalStateException("La course n'a pas d�marr�, inscriptions en cours");
	}

	@Override
	public EtatCourse passerLaLigneDArriv�e(Participant participant) {
		throw new IllegalStateException("La course n'a pas d�marr�, inscriptions en cours");
	}

	@Override
	public EtatCourse inscrire(Participant participant) {
		if(participant==null) {
			throw new NullPointerException("Le participant doit �tre renseign�");
		}
		List<Participant> inscrits = getContexte().getInscrits();
		
		if(inscrits.contains(participant)) {
			throw new IllegalArgumentException("Le/La participant-e est d�j� inscrit-e");
		}
		inscrits.add(participant);
		return this;
	}

	@Override
	public EtatCourse d�marrer() {
		return suivant;
	}

}
