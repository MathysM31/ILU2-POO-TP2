package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef chef;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlEmmenager controlEmmenager;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;

	@BeforeEach
	public void init() {
		village = new Village("le village toulousain", 10, 5);
		chef = new Chef("Abraracourcix", 10, village);
		village.setChef(chef);
		this.controlEmmenager = new ControlEmmenager(village);
		this.controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		this.controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(controlTrouverEtalVendeur,"Constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10);
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine"));
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Intrus"));
	}

}
