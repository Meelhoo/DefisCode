package défis.essais._2_3;

public class ComptageMots {
	


	public static int compter(String phrase) {
		
		int nombreMots = 1;
		
		if (phrase.isBlank()){
			return 0;
		} else {
			int debutPhrase = 0;
			while (phrase.charAt(debutPhrase)==' ') {
				debutPhrase++;
			}
		for (int i=debutPhrase; i<phrase.length()-1; i++) {
			char lettre = phrase.charAt(i);
			if (!Character.isLetter(lettre) && (Character.isLetter(phrase.charAt(i+1)))){
				nombreMots++;
			}
			
		}
		
		return nombreMots;
		}
	}

}
