package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef chef;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlEmmenager controlEmmenager;

	@BeforeEach
	public void init() {
		village = new Village("le village toulousain", 10, 5);
		chef = new Chef("Abraracourcix", 10, village);
		village.setChef(chef);
		this.controlEmmenager = new ControlEmmenager(village);
		this.controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlVerifierIdentite() {
		assertNotNull(controlVerifierIdentite,"Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlVerifierIdentite.verifierIdentite("Bonemine"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Intrus"));
	}

}
