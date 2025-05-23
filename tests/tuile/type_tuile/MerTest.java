package tuile.type_tuile;
import tuile.type_tuile.Mer;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MerTest {

	@Test
	public void testMerConstructor() {
		// créer une instance de mer
		Mer mer = new Mer(10, 20);


		// Verifier si le nom est correctement Montagne
		assertEquals("Mer", mer.getType());

		// Verifier que les valeurs sont initialisées
		assertEquals(10, mer.getX());
        assertEquals(20, mer.getY());
	}

}
