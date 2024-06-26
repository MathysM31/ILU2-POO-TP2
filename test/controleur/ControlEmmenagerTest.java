package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	
	ControlEmmenager control;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village de test", 10, 10);
		Chef chef = new Chef("Chef", 10, village);
		village.setChef(chef);
		control = new ControlEmmenager(village);
	}

	@Test
	void testControlEmmenager() {
		assertNotNull(control);
	}

	@Test
	void testIsHabitant() {
		control.ajouterGaulois("Ast�rix", 10);
		assertTrue(control.isHabitant("Ast�rix"));
		assertFalse(control.isHabitant("Ob�lix"));
	}

	@Test
	void testAjouterDruide() {
		control.ajouterDruide("Panoramix", 3, 10, 20);
		assertTrue(control.isHabitant("Panoramix"));
		assertFalse(control.isHabitant("Ob�lix"));
	}

	@Test
	void testAjouterGaulois() {
		control.ajouterGaulois("Ast�rix", 7);
		for (int i = 0; i < 10; i++) {
			control.ajouterGaulois("Gaulois_"+ i, 5);
			
		}
		control.ajouterGaulois("Ob�lix", 7);
		assertTrue(control.isHabitant("Ast�rix"));
		assertFalse(control.isHabitant("Ob�lix"));
		
	}

}
