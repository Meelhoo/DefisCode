package défis.solutions._3_2.états;

import java.util.List;

import défis.solutions._3_2.Participant;

public class Arrivée extends EtatCourse {
	public Arrivée(int id, ContexteCourse contexte) {
		super(id, contexte);
	}
	@Override
	public Iterable<Participant> getClassement() {
		return getContexte().getClassement();
	}
	@Override
	public Participant getGagnant() {
		return getContexte().getClassement().get(0);
	}
	@Override
	public EtatCourse inscrire(Participant participant) {
		throw new IllegalStateException("Inscriptions fermées, la course est terminée");
	}
	@Override
	public EtatCourse démarrer() {
		throw new IllegalStateException("La course est déjà démarrée");
	}
	@Override
	public EtatCourse passerLaLigneDArrivée(Participant participant) {
		if(participant==null) {
			throw new NullPointerException("Le participant doit être renseigné");
		}
		List<Participant> classement = getContexte().getClassement();
		
		if( classement.contains(participant) ) {
			throw new IllegalArgumentException("Le/La participant-e est déjà arrivé-e");
		}
		classement.add(participant);
		return this;
	}
}
