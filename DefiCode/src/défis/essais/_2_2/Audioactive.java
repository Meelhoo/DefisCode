package défis.essais._2_2;

public class Audioactive {

	public static long valeurSuivante(long valeur) {
		long result=0;
		int compteur = 1;
		int p =0;
		while (valeur != 0) {
			long chiffredroite = valeur%10;
			long restegauche = (valeur - chiffredroite)/10;
			long prec = restegauche%10;
			if (prec == chiffredroite) {
				compteur++;
				valeur = restegauche;
				}
			else {
				long nombrea2chiffres = compteur * 10 + chiffredroite;
				result+=nombrea2chiffres * (long)Math.pow(100, p);
				p += 2;
				compteur = 1;
			}
		}		
		return result;
	}


}
