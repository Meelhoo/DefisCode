package d�fis.solutions._3_2;

public class Cat�gorie {
	public final static Cat�gorie HORS_CATEGORIE = new Cat�gorie("Hors cat�gorie");	
	
	private final String titre;
	
	public Cat�gorie(String titre) {
		if(titre == null) {
			throw new NullPointerException("Titre ne peut �tre nul");
		}
		this.titre = titre;		
	}
	public String getTitre() {
		return titre;
	}
}
