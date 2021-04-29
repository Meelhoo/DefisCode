package d�fis;

import d�fis.essais._4_4.TriParPivot;
//import d�fis.solutions._4_4.TriParPivot;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.Random;

public class _4_4_D�samorcerLaBombe {

	@Test
	public void testTableauVide() {
		Integer [] tableau = {  };
		TriParPivot tri = new TriParPivot();
		
		tri.trier(tableau);
		assertArrayEquals(new Integer[] {}, tableau);
	}

	@Test
	public void testTableauALenvers() {
		Integer [] tableau = new Integer[50000];
		Integer [] attendu = remplir�LEnversDupliquerEtTrier(tableau);
		TriParPivot tri = new TriParPivot();
		
		tri.trier(tableau);
		assertArrayEquals(attendu, tableau);
	}
	
	@Test
	public void testGrandTableauAl�atoire() {
		Integer [] tableau = new Integer[100000];
		Integer [] attendu = remplirDupliquerEtTrier(tableau);
		TriParPivot tri = new TriParPivot();
		
		tri.trier(tableau);
		assertArrayEquals(attendu, tableau);
	}
	
	private Integer[] dupliquerEtTrier(Integer[] tableau) {
		Integer[] tri� = tableau.clone();
		
		Arrays.sort( tri� );
		return tri�;
	}

	private Integer[] remplir�LEnversDupliquerEtTrier(Integer[] tableau) {
		for(int i=0; i<tableau.length; i++) {
			tableau[i] = tableau.length - i;
		}
		return dupliquerEtTrier(tableau);
	}		
	
	private Integer[] remplirDupliquerEtTrier(Integer[] tableau) {
		int max = tableau.length;
		Random hasard = new Random(0); 
		
		for(int i=0; i<tableau.length; i++) {
			tableau[i] = hasard.nextInt(max);
		}
		return dupliquerEtTrier(tableau);
	}

}
