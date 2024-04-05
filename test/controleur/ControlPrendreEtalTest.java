package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	
	ControlEmmenager controlEm;
	ControlPrendreEtal control;
	ControlVerifierIdentite controlVerif;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village de test", 10, 2);
		Chef chef = new Chef("Chef", 10, village);
		village.setChef(chef);
		control = new ControlPrendreEtal(controlVerif, village);
		controlEm = new ControlEmmenager(village);
		controlVerif = new ControlVerifierIdentite(village);
		controlEm.ajouterDruide("Panoramix", 3, 10, 20);
		controlEm.ajouterGaulois("Astérix", 10);
		controlEm.ajouterGaulois("Obélix", 10);
	}

	@Test
	void testControlPrendreEtal() {
		assertNotNull(control);
	}

	@Test
	void testResteEtals() {
		assertTrue(control.resteEtals());
		control.prendreEtal("Astérix","Fraise", 10);
		control.prendreEtal("Panoramix","Potion", 10);
		assertFalse(control.resteEtals());
		
	}

	@Test
	void testPrendreEtal() {
		assertEquals(control.prendreEtal("Astérix","Fraise", 10), 0);
		assertEquals(control.prendreEtal("Panoramix","Potion", 10), 1);
		assertEquals(control.prendreEtal("Obélix","Sanglier", 10), -1);
	}

}
