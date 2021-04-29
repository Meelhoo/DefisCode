package d�fis.essais._5_3;

public class NombrePremier {
	public interface Recherche {
		public boolean estTrouv�();
		public long getNombreTrouv�();
	}
	public static Recherche nouvelleRecherche(long nombre) {
		return new AlgoRecherche(nombre);
	}
	
	public static void traiter(Recherche recherche, int tempsLimite) {
		AlgoRecherche r = (AlgoRecherche)recherche;
		long nombre = r.getNombre();;
		long diviseur;
		
		do {
			nombre++;
			diviseur = 2;			
			while( diviseur < nombre && nombre % diviseur != 0 ) {
				diviseur++;
			}			
		}
		while(diviseur < nombre);		
		r.setNombreTrouv�(nombre);
	}
	
	private static class AlgoRecherche implements Recherche {
		private long nombreTrouv�;
		private boolean trouv� = false;
		private final long nombre;
		
		public AlgoRecherche(long nombre) {
			this.nombre = nombre;
		}		
		@Override
		public boolean estTrouv�() {
			return trouv�;
		}
		@Override
		public long getNombreTrouv�() {
			if(!estTrouv�()) {
				throw new IllegalStateException("Aucun nombre trouv� pour l'instant");
			}
			return nombreTrouv�;
		}
		public void setNombreTrouv�(long nombreTrouv�) {
			this.nombreTrouv� = nombreTrouv�;
			this.trouv� = true;
		}
		public long getNombre() {
			return nombre;
		}
	}
}
