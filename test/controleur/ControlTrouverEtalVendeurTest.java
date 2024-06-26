package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	
	ControlTrouverEtalVendeur control;
	ControlEmmenager controlEm;
	ControlVerifierIdentite controlVerif;
	ControlPrendreEtal controlEtal;
	
	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village de test", 10, 2);
		Chef chef = new Chef("Chef", 10, village);
		village.setChef(chef);
		control = new ControlTrouverEtalVendeur(village);
		controlEm = new ControlEmmenager(village);
		controlVerif = new ControlVerifierIdentite(village);
		controlEtal = new ControlPrendreEtal(controlVerif, village);
		controlEm.ajouterGaulois("Ast�rix", 10);
		controlEm.ajouterGaulois("Ob�lix", 10);
		controlEm.ajouterDruide("Panoramix", 3, 10, 20);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(control);
	}

	@Test
	void testTrouverEtalVendeur() {
		controlEtal.prendreEtal("Panoramix","Potion", 10);
		controlEtal.prendreEtal("Ob�lix","Sanglier", 10);
		assertEquals(control.trouverEtalVendeur("Panoramix").getVendeur(),"Panoramix");
		assertEquals(control.trouverEtalVendeur("Ob�lix").getVendeur(),"Ob�lix");
		assertNotNull(control.trouverEtalVendeur("Panoramix"));
		assertNotNull(control.trouverEtalVendeur("Ob�lix"));
	}

}
