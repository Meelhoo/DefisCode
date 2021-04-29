package d�fis.tests;

import d�fis.essais._4_1.Empereur;
//import d�fis.solutions._4_1.Empereur;
import static org.junit.Assert.*;
import org.junit.Test;

public class _4_1_CompterAllouerRemplir {

	@Test
	public void testInitialisationPremier() {
		Empereur augustus = new Empereur("Auguste"); 
		
		assertEquals("Auguste", augustus.getNom());
		assertTrue(augustus.estLePremier());
	}
	
	@Test
	public void testInitialisationSecond() {
		Empereur augustus = new Empereur("Auguste"); 
		Empereur tiberius = new Empereur("Tib�re"  , augustus);
		
		assertFalse(tiberius.estLePremier());
		assertEquals(augustus, tiberius.getPr�d�cesseur());
	}
	
	@Test
	public void testExtraireListe() {
		Empereur augustus = new Empereur("Auguste");
		Empereur tiberius = new Empereur("Tib�re"  , augustus);
		Empereur caius 	  = new Empereur("Caligula", tiberius);
		Empereur claudius = new Empereur("Claude"  , caius);
		Empereur nero 	  = new Empereur("N�ron"   , claudius); 
		
		assertArrayEquals(new Empereur[] {
			augustus, tiberius, caius, claudius, nero
		}, Empereur.extraireListe(nero));
	}

}
