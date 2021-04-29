package d�fis.essais._4_1;

public class Empereur {
	private final String nom;
	private final Empereur pr�d�cesseur;
	
	public Empereur(String nom, Empereur pr�d�cesseur) {
		if(pr�d�cesseur == null) {
			throw new NullPointerException("Pr�d�cesseur non valide");
		}
		this.nom = nom;
		this.pr�d�cesseur = pr�d�cesseur;
	}
	public Empereur(String nom) {
		this.nom = nom;
		this.pr�d�cesseur = null;
	}
	public String getNom() {
		return this.nom;
	}
	public boolean estLePremier() {
		return this.pr�d�cesseur == null;
	}
	public Empereur getPr�d�cesseur() {
		if(pr�d�cesseur==null) {
			throw new IllegalStateException("Pas de pr�d�cesseur pour le premier empereur !");
		}
		return this.pr�d�cesseur;
	}
	public static Empereur[] extraireListe(Empereur r�cent) {
		return null;
	}
}
