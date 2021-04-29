package d�fis.solutions._5_3;

import java.time.Duration;
import java.time.Instant;

public class NombrePremier {
	public interface Recherche {
		public boolean estTrouv�();
		public long getNombreTrouv�();
	}
	
	public static Recherche nouvelleRecherche(long nombre) {
		return new AlgoRecherche(nombre);
	}
	
	public static void traiter(Recherche recherche, int tempsLimite) {
		Instant fin = Instant.now().plus(Duration.ofMillis(tempsLimite));
		AlgoRecherche r = (AlgoRecherche)recherche;
		
		while(Instant.now().compareTo(fin) < 0 && !r.estTrouv�()) {
			r.it�ration();
		}
	}
	
	private static class AlgoRecherche implements Recherche {
		private static enum Etat {
			Init,
			Recherche,
			Trouv�
		}		
		private long diviseur;
		private long nombre;
		private Etat �tat = Etat.Init;
		
		public AlgoRecherche(long nombre) {
			this.nombre = nombre;
		}
		
		public void it�ration() {
			switch(�tat) {
			case Init:
				nombre++;
				diviseur = 2;
				�tat = Etat.Recherche;
				break;
			case Recherche:
				if(diviseur == nombre) {
					�tat = Etat.Trouv�;
				}
				else if(nombre % diviseur == 0) {
					�tat = Etat.Init;
				}
				else {
					diviseur++;
				}
				break;
			case Trouv�:
				break;
			}
		}
		
		@Override
		public boolean estTrouv�() {
			return �tat == Etat.Trouv�;
		}

		@Override
		public long getNombreTrouv�() {
			if(!estTrouv�()) {
				throw new IllegalStateException("Aucun nombre trouv� pour l'instant");
			}
			return nombre;
		}		
	}	
}
