package d�fis.solutions._3_2.�tats;

import java.util.List;

import d�fis.solutions._3_2.Participant;

public class Arriv�e extends EtatCourse {
	public Arriv�e(int id, ContexteCourse contexte) {
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
		throw new IllegalStateException("Inscriptions ferm�es, la course est termin�e");
	}
	@Override
	public EtatCourse d�marrer() {
		throw new IllegalStateException("La course est d�j� d�marr�e");
	}
	@Override
	public EtatCourse passerLaLigneDArriv�e(Participant participant) {
		if(participant==null) {
			throw new NullPointerException("Le participant doit �tre renseign�");
		}
		List<Participant> classement = getContexte().getClassement();
		
		if( classement.contains(participant) ) {
			throw new IllegalArgumentException("Le/La participant-e est d�j� arriv�-e");
		}
		classement.add(participant);
		return this;
	}
}
