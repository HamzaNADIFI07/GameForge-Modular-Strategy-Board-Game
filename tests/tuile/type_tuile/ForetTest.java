package tuile.type_tuile;
import tuile.type_tuile.Foret;
import ressource.enumRessource; 

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ForetTest {

	@Test
	public void testForetConstructor() {
		int x = 10;
		int y = 20;
		Foret foret = new Foret(x, y);


		// Verifier si le nom est correctement Foret
		assertEquals("Foret", foret.getType());

		// Verifie si les coordonnées sont bien initialisées
		assertEquals(x, foret.getX());
		assertEquals(y, foret.getY());


		// Verifie si la ressource est correctement initialisée à enumRessource.Bois
		assertEquals(enumRessource.Bois, foret.produireRessource());

	}

}
