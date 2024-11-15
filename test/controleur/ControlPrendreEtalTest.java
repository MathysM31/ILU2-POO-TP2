package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef chef;
	private ControlEmmenager controlEmmenager;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite; 
	
	@BeforeEach
	public void init() {
		village = new Village("le village toulousain", 10, 2);
		chef = new Chef("Abraracourcix", 10, village);
		village.setChef(chef);
		this.controlEmmenager = new ControlEmmenager(village);
		this.controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
	}
	
	@Test
	void testControlPrendreEtal() {
		assertNotNull(controlPrendreEtal,"Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10);
		assertTrue(controlPrendreEtal.resteEtals());
		controlEmmenager.ajouterGaulois("Asterix", 10);
		controlPrendreEtal.prendreEtal("Astérix", "potions", 10);
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertEquals(controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10), 0);
		controlEmmenager.ajouterGaulois("Asterix", 10);
		assertEquals(controlPrendreEtal.prendreEtal("Astérix", "potions", 10), 1);
		controlEmmenager.ajouterGaulois("Obélix", 10);
		assertEquals(controlPrendreEtal.prendreEtal("Obélix", "ménirs", 10), -1);
	}

	@Test
	void testVerifierIdentite() {
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));
		assertFalse(controlPrendreEtal.verifierIdentite("Intrus"));
	}

}
