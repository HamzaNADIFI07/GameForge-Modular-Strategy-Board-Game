package batimentTypeTests;
import tuile.Tuile;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
		Camp camp = new Camp(foretTuile);
		assertTrue(camp.peutEtreConstruit(), "Un camp ne peut pas être construit sur une tuile avec une armée");
	}
}
