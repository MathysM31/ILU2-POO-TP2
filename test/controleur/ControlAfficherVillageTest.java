package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	
	ControlAfficherVillage control;
	ControlEmmenager controlEm;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village de test", 2, 2);
		Chef chef = new Chef("Chef", 10, village);
		village.setChef(chef);
		control = new ControlAfficherVillage(village);
		controlEm = new ControlEmmenager(village);
	}

	@Test
	void testControlAfficherVillage() {
		assertNotNull(control);
	}

	@Test
	void testDonnerNomsVillageois() {
		controlEm.ajouterDruide("Panoramix", 3, 10, 20);
		controlEm.ajouterGaulois("Astérix", 10);
		String[] donneesRecu = control.donnerNomsVillageois();
		String[] donneesAttendu = {"Chef", "le druide Panoramix", "Astérix"};
		assertArrayEquals(donneesAttendu, donneesRecu, "OK");
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals("Village de test", control.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(2,control.donnerNbEtals());
	}

}
