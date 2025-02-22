package batimentTypeTests;
import tuile.Tuile;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import batiment.type_batiment.Armee;
import batiment.type_batiment.Camp;
import tuile.type_tuile.Foret;

public class CampTest {

	@Test
	public void testCampCreation() {
		Tuile foretTuile = new Foret(3, 3);
		Camp camp = new Camp(foretTuile);
		assertNotNull(camp);
		assertEquals("Camp", camp.getType());
		assertEquals(foretTuile, camp.getTuile());
	}
	@Test
	public void testCampPeutEtreConstruit() {
		Tuile foretTuile = new Foret(3, 3);
		Armee armee = new Armee(foretTuile, 3);
		Camp camp = new Camp(foretTuile);
		assertTrue(foretTuile.getBatiment().getType().equals("Camp"), "La tuile foret doit contenir un camp");
	}
	// @Test
	// public void testCampCannotBeBuiltOnArmy() {
	// 	Tuile foretTuile = new Foret(3, 3);
	// 	Armee armee = new Armee(foretTuile, 3);
	// 	foretTuile.setBatiment(armee);
	// 	Camp camp = new Camp(foretTuile);
	// 	assertFalse(camp.peutEtreConstruit(), "Un camp ne peut pas être construit sur une tuile contenant une armée");	
	// }
}
