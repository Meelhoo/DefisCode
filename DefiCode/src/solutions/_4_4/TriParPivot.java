package d�fis.solutions._4_4;

import java.util.Stack;

public class TriParPivot {
	private class Param�tres {
		private final int premier, dernier;
		
		public Param�tres(int premier, int dernier) {
			this.premier = premier;
			this.dernier = dernier;
		}
		public int getPremier() {
			return premier;
		}
		public int getDernier() {
			return dernier;
		}
	}
	private Stack<Param�tres> pile = new Stack<>();
	
	public <T extends Comparable<? super T>> void trier(T [] tableau) {
		pile.push(new Param�tres(0, tableau.length));
	
		while(!pile.empty()) {
			Param�tres p = pile.pop();
			
			if (p.getPremier() < p.getDernier()) {		        
				int pos = p.getPremier();
				
				for(int fin = p.getDernier()-1; pos < fin; ) {
			    	permuter(
			    		tableau, pos+1,
			    		tableau[pos+1].compareTo(tableau[pos]) < 0 ? pos++ : fin--
			    	);
			    }
				pile.push(new Param�tres(p.getPremier(), pos    ));
				pile.push(new Param�tres(pos + 1, p.getDernier()));
			}
		}
	}
	
	private static <T> void permuter(T[] tableau, int indice1, int indice2) {
		T tmp = tableau[indice1];
		
		tableau[indice1] = tableau[indice2];
		tableau[indice2] = tmp;
	}	
}
