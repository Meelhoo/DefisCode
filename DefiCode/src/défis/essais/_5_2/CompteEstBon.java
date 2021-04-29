package d�fis.essais._5_2;

import java.util.function.BinaryOperator;

public class CompteEstBon {
	private final static Op�ration[] op�rations={
		new Op�ration('*', (a, b) -> a != 1 && b != 1     ? a * b : 0 ),
		new Op�ration('/', (a, b) -> b != 1 && a % b == 0 ? a / b : 0 ),
		new Op�ration('+', (a, b) -> a + b),
		new Op�ration('-', (a, b) -> a > b ? a - b : 0)
	};			

	private final Tirage tirage;
	
	public CompteEstBon(Tirage tirage) {
		this.tirage = tirage;
	}
	
	public void afficherSolutions() {
		for(int i = 0; i<tirage.taille(); i++) {
			int terme1 = tirage.retirer(i);
			
			for(int j = 0; j<tirage.taille(); j++) {
				int terme2 = tirage.retirer(j);
				
				essayerOp�rations(terme1, terme2);
				tirage.ajouter(j, terme2);
			}
			tirage.ajouter(i, terme1);
		}
	}
	
	private void essayerOp�rations(int terme1, int terme2) {
		for(Op�ration op : op�rations) {
			int total = op.calculer(terme1, terme2);
			
			if(total == tirage.getObjectif()) {
				// TODO : Afficher votre solution ici
				System.out.println("Solution trouv�e");
			}
			else if(total != 0) {
				tirage.ajouterFin(total);
				afficherSolutions();
				tirage.retirerFin();
			}
		}
	}
	
	private static class Op�ration
	{
		private final char symbole;
		private final BinaryOperator<Integer> op�rateur;
		
		public Op�ration(char symbole, BinaryOperator<Integer> op�rateur) {
			this.symbole = symbole;
			this.op�rateur = op�rateur;
		}
		public int getSymbole() {
			return symbole;
		}
		public int calculer(int op1, int op2) {
			return op�rateur.apply(op1, op2);
		}		
	}
}
