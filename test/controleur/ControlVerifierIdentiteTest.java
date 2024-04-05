package controleur;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	
	ControlVerifierIdentite control;
	ControlEmmenager controlEm;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village de test", 10, 10);
		Chef chef = new Chef("Chef", 10, village);
		village.setChef(chef);
		control = new ControlVerifierIdentite(village);
		controlEm = new ControlEmmenager(village);
	}

	@Test
	void testControlVerifierIdentite() {
		assertNotNull(control);
	}

	@Test
	void testVerifierIdentite() {
		controlEm.ajouterGaulois("Astérix", 10);
		assertTrue(control.verifierIdentite("Astérix"));
		assertFalse(control.verifierIdentite("Obélix"));
		assertTrue(control.verifierIdentite("Chef"));
	}

}
