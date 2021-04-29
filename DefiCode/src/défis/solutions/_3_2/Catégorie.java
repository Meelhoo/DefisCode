package défis.solutions._3_2;

public class Catégorie {
	public final static Catégorie HORS_CATEGORIE = new Catégorie("Hors catégorie");	
	
	private final String titre;
	
	public Catégorie(String titre) {
		if(titre == null) {
			throw new NullPointerException("Titre ne peut être nul");
		}
		this.titre = titre;		
	}
	public String getTitre() {
		return titre;
	}
}
