package tuile.type_tuile;
import tuile.type_tuile.Paturage;
import ressource.enumRessource;
import tuile.Tuile;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PaturageTest {

	@Test
	public void testPaturageConstructor() {
		// creation d'une instance de Paturage
		int x = 10;
		int y = 20;
		Paturage paturage = new Paturage(x, y);

		// Verifie le nom est correctement Paturage
		assertEquals("Paturage", paturage.getType());

		//Verifie si les coordonnées sont bien initialisées
		assertEquals(x, paturage.getX());
		assertEquals(y, paturage.getY());

		// Verifie si la ressource est Moutons
		assertEquals(enumRessource.Moutons, paturage.produireRessource());
		
	}

}
