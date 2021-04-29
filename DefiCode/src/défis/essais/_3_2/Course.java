package d�fis.essais._3_2;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private final List<Participant> inscrits = new ArrayList<Participant>();
	private List<Participant> classement = null;
	private final Cat�gorie cat�gorie;
			
	public Course(Cat�gorie cat�gorie) {
		this.cat�gorie = cat�gorie;
	}
	public Course() {
		this(null);
	}
	public Cat�gorie getCat�gorie() {
		return cat�gorie; 
	}
	public Iterable<Participant> getInscrits() {
		return inscrits;
	}
	public Iterable<Participant> getClassement() {
		return classement;
	}
	public Participant getGagnant() {
		return classement==null || classement.size()==0 
			? null 
			: classement.get(0);
	}
	public void inscrire(Participant participant) {
		if(classement != null) {
			throw new IllegalStateException("Inscriptions ferm�es, la course est commenc�e");
		}
		else if(inscrits.contains(participant)) {
			throw new IllegalArgumentException("Le/La participant-e est d�j� inscrit-e");
		}
		inscrits.add(participant);
	}
	public void d�marrer() {
		if( classement != null ) {
			throw new IllegalStateException("La course est d�j� d�marr�e");
		}
		classement = new ArrayList<>();
	}
	public void passerLaLigneDArriv�e(Participant participant) {
		if( classement==null ) {
			throw new IllegalStateException("La course n'a pas d�marr�, inscriptions en cours");
		}
		else if( !inscrits.contains(participant) ) {
			throw new IllegalArgumentException("Le/La participant-e n'est pas inscrit-e");
		}
		else if( classement.contains(participant) ) {
			throw new IllegalArgumentException("Le/La participant-e est d�j� arriv�-e");
		}
		classement.add(participant);
	}	
}
