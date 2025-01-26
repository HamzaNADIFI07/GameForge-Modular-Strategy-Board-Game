package tuile.type_tuile;
import tuile.type_tuile.Montagne;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MontagneTest {

	@Test
	public void testMontagneConstructor() {
		// creation d'une instance de montagne

		int x = 10;
		int y = 20;
		Montagne montagne = new Montagne(x, y);

		// Verifie si le nom est correctement Montagne
		 assertEquals("Montagne", montagne.getType());
	}
		// Verifie si les coordonnées sont initialisées
		assertEquals(x, montagne.getX());
		assertEquals(y, montagne.getY());


		//Verifie si la ressource est bien Minerai
		assertEquals(enumRessource.Minerai, montagne.produireRessource());
}
