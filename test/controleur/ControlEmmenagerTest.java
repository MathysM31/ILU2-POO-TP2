package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef chef;
	private ControlEmmenager controlEmmenager;

	@BeforeEach
	public void init() {
		village = new Village("le village toulousain", 10, 5);
		chef = new Chef("Abraracourcix", 10, village);
		village.setChef(chef);
		this.controlEmmenager = new ControlEmmenager(village);
	}

	
	@Test
	void testControlEmmenager() {
		assertNotNull(controlEmmenager,"Constructeur ne renvoie pas null");
	}

	@Test
	void testIsHabitant() {
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("Intrus"));
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		assertTrue(controlEmmenager.isHabitant("Abraracourcix"));
	}

	@Test
	void testAjouterDruide() {
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		assertFalse(controlEmmenager.isHabitant("Bonemine"));
	}

	@Test
	void testAjouterGaulois() {
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("Panoramix"));
	}

}
