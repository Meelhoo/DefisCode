package d�fis.solutions._3_2.�tats;

import d�fis.solutions._3_2.Participant;

public abstract class EtatCourse {
	private int id;
	private ContexteCourse contexte;
	
	public EtatCourse(int id, ContexteCourse contexte) {
		this.id = id;
		this.contexte = contexte;
	}	
	public int getId() {
		return id;
	}	
	protected ContexteCourse getContexte() {
		return contexte;
	}	
	public Iterable<Participant> getInscrits() {
		return contexte.getInscrits(); 
	}
	public abstract Iterable<Participant> getClassement();
	public abstract Participant getGagnant();
	
	public abstract EtatCourse inscrire(Participant participant);	
	public abstract EtatCourse d�marrer();	
	public abstract EtatCourse passerLaLigneDArriv�e(Participant participant);
}
