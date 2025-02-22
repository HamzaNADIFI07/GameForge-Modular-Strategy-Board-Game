package tuile.type_tuile;
import tuile.type_tuile.Champ;
import ressource.Ressource;
import tuile.Tuile;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ChampTest {

	@Test
	public void testChampConstructor() {
		// on crée une instance de champs avec des coordonnées(x, y)

		int x = 10;
		int y = 20;
		Champ champ = new Champ(x, y);

		// Verifier si le nom est correctement Montagne
		assertEquals("Champ", champ.getType());

		// Verifie si les coordonnées sont bien initialisées
		assertEquals(x, champ.getX());
		assertEquals(y, champ.getY());

		// Verifie si la ressource est correctement initialisée à enumRessource.Ble
		assertEquals(Ressource.Ble, champ.getRessource());
	}

}
