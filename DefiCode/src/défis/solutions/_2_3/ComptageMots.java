package d�fis.solutions._2_3;

public class ComptageMots {
	private enum Etat {
		Espace,
		Mot
	}
	private final static String SEPARATEURS = "'-.;:?! \t\n\r";
	
	private static boolean estUnS�parateur(char caract�re) {
		return SEPARATEURS.indexOf(caract�re) >= 0;
	}
	
	public static int compter(String phrase) {
		Etat �tat = Etat.Espace;
		int nombreMots = 0;
		
		for(int i=0; i<phrase.length(); i++) {
			char caract�re = phrase.charAt(i);
			
			switch(�tat) {
			case Espace:
				if( !estUnS�parateur(caract�re) ) {
					�tat = Etat.Mot;
					nombreMots++;
				}
				break;
			case Mot:
				if( estUnS�parateur(caract�re) ) {
					�tat = Etat.Espace;
				}
				break;
			}
		}
		return nombreMots;
	}
}
