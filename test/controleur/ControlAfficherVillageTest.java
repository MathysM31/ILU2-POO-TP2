package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef chef;
	private ControlAfficherVillage controlAfficherVillage;
	private ControlEmmenager controlEmmenager;

	@BeforeEach
	public void init() {
		village = new Village("le village toulousain", 10, 5);
		chef = new Chef("Abraracourcix", 10, village);
		village.setChef(chef);
		this.controlAfficherVillage = new ControlAfficherVillage(village);
		this.controlEmmenager = new ControlEmmenager(village);
	}
	
	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage,"Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlEmmenager.ajouterGaulois("Ast�rix", 10);
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		String[] donneesRe�u = controlAfficherVillage.donnerNomsVillageois();
		String[] donneesAttendu = {"Abraracourcix","Bonemine","Ast�rix","le druide Panoramix"};
		assertArrayEquals(donneesAttendu, donneesRe�u);
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals("le village toulousain",controlAfficherVillage.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(5, controlAfficherVillage.donnerNbEtals());
	}

}
