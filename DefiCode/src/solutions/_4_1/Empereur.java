package d�fis.solutions._4_1;

public class Empereur {
	private final String nom;
	private final Empereur pr�d�cesseur;
	
	public Empereur(String nom, Empereur pr�d�cesseur) {
		this.nom = nom;
		this.pr�d�cesseur = pr�d�cesseur;
	}
	public Empereur(String nom) {
		this(nom, null);
	}
	public String getNom() {
		return nom;
	}
	public boolean estLePremier() {
		return pr�d�cesseur == null;
	}
	public Empereur getPr�d�cesseur() {
		return pr�d�cesseur;
	}
	private static Empereur[] extraireListe(Empereur courant, int nombre) {
		Empereur[] r�sultat = courant.estLePremier() 
			? new Empereur[nombre]
			: extraireListe(courant.getPr�d�cesseur(), nombre+1);
		
		r�sultat[r�sultat.length-nombre] = courant;
		return r�sultat;
	}
	public static Empereur[] extraireListe(Empereur r�cent) {
		return extraireListe(r�cent, 1);
	}
}
