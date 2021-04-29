package d�fis.solutions._5_1;

public class TriParPivot {
	private int maxProfondeur;
	
	public TriParPivot(int maxT�ches) {
		this.maxProfondeur = 0;		
		for(; maxT�ches>1; maxT�ches/=2) {
			this.maxProfondeur++;
		}
	}
	
	public <T extends Comparable<? super T>> void trier(T [] tableau) {
		trier(tableau, 0, tableau.length, 0);			
	}
	
	private <T extends Comparable<? super T>> void trier(T [] tableau, int premier, int dernier, int profondeur) {
		if (premier >= dernier) {
	        return;
	    }
		int pos = premier;
		
	    for(int fin = dernier-1; pos < fin; ) {
	    	permuter(
	    		tableau, pos+1,
	    		tableau[pos+1].compareTo(tableau[pos]) < 0 ? pos++ : fin--
	    	);
	    }
	    
	    final int profondeurSuivante = profondeur+1;
	    final int positionPivot = pos;
	    boolean cr�erT�che = profondeur < maxProfondeur;
	    Thread t�che = null;
	    
	    if(cr�erT�che) {
	    	t�che = new Thread(() -> trier(tableau, premier, positionPivot, profondeurSuivante));
	    	t�che.start();
	    }
	    else {
	    	trier(tableau, premier, positionPivot, profondeurSuivante);
	    }	    
	    trier(tableau, pos + 1, dernier, profondeurSuivante);
	    if(cr�erT�che) 
	    	try {
	    		t�che.join();
	    	}
	    	catch(InterruptedException e) {
	    		// TODO : loguer - processus interrompu
	    	}
	}
	
	private static <T> void permuter(T[] tableau, int indice1, int indice2) {
		T tmp = tableau[indice1];
		
		tableau[indice1] = tableau[indice2];
		tableau[indice2] = tmp;
	}
}
