package tuile.type_tuile;
import tuile.type_tuile.Champ;
import ressource.enumRessource;
import tuile.Tuile;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ChampTest {

	@Test
	public void test() {
		// on crée une instance de champs avec des coordonnées(x, y)

		int x = 15;
		int y = 30;
		Champ champ = new Champ(x, y);

		// Verifie si les coordonnées sont bien initialisées
		assertEquals(x, champ.getX());
		assertEquals(y, champ.getY());

		// Verifie si la ressource est correctement initialisée à enumRessource.Ble
		assertEquals(enumRessource.Ble, champ.getRessource());
	}

}
