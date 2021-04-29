package d�fis.solutions._3_2;

import d�fis.solutions._3_2.�tats.Arriv�e;
import d�fis.solutions._3_2.�tats.ContexteCourse;
import d�fis.solutions._3_2.�tats.EnCours;
import d�fis.solutions._3_2.�tats.EtatCourse;
import d�fis.solutions._3_2.�tats.Inscription;

public class Course {
	public final static int
		INSCRIPTION = 0,
		EN_COURS = 1,
		ARRIVEE = 2;
	private final ContexteCourse contexte = new ContexteCourse();
	private final Cat�gorie cat�gorie;
	private EtatCourse �tat =
		new Inscription(INSCRIPTION, contexte, 
			new EnCours(EN_COURS   , contexte,
				new Arriv�e(ARRIVEE, contexte)
			)
		);
			
	public Course(Cat�gorie cat�gorie) {
		if(cat�gorie==null) {
			throw new NullPointerException("La cat�gorie doit �tre renseign�e");
		}
		this.cat�gorie = cat�gorie;
	}
	public Cat�gorie getCat�gorie() {
		return cat�gorie; 
	}
	public int get�tat() {
		return this.�tat.getId();
	}
	public Iterable<Participant> getInscrits() {
		return �tat.getClassement();
	}
	public Iterable<Participant> getClassement() {
		return �tat.getClassement();
	}
	public Participant getGagnant() {
		return �tat.getGagnant();
	}
	public void inscrire(Participant participant) {
		�tat = �tat.inscrire(participant);
	}
	public void d�marrer() {
		�tat = �tat.d�marrer();
	}
	public void passerLaLigneDArriv�e(Participant participant) {
		�tat = �tat.passerLaLigneDArriv�e(participant);
	}	
}
