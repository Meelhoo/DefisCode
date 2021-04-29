package d�fis.tests;

import d�fis.essais._5_3.NombrePremier;
//import d�fis.solutions._5_3.NombrePremier;
import static org.junit.Assert.*;

import java.time.Duration;
import java.time.Instant;

import org.junit.Test;

public class _5_3_ItererParIntermittence {

	@Test
	public void testPetitNombreEn1s() {
		NombrePremier.Recherche recherche = NombrePremier.nouvelleRecherche(7);
		
		NombrePremier.traiter(recherche, 1000); 
		
		assertTrue(recherche.estTrouv�());
		assertEquals(11, recherche.getNombreTrouv�());
	}

	@Test
	public void testGrandNombreEnPlusieursIntervallesDe100ms() {
		NombrePremier.Recherche recherche = NombrePremier.nouvelleRecherche(179424691L);
		long compteur = 0;
		
		do {
			Instant d�but = Instant.now();
			
			NombrePremier.traiter(recherche, 100);
			Duration dur�e = Duration.between( d�but , Instant.now() ) ;
			
			assertTrue(dur�e.toMillis() <= 100L);
			compteur ++;			
		}
		while(!recherche.estTrouv�());
		assertTrue(compteur>1);
		assertEquals(179424697L, recherche.getNombreTrouv�());
	}

	
}
