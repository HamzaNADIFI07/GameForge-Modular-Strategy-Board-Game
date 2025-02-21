package Batiment;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import batiment.Batiment;
import ressource.enumRessource;
import tuile.Tuile;
import tuile.type_tuile.Champ;
import java.util.Map;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

public class BatimentTest {
	private Batiment batiment;
	private Tuile tuile;
	/** Initialise un objet Batiment de test et l'associe à une Tuile.
	 * */
	@BeforeEach
	void setUp() {
		tuile = new Champ(0, 0); // Création d'une tuile de type Champ
		batiment = new Batiment("TestBatiment", 3, tuile) {
			@Override
			public boolean peutEtreConstruit() {
				return true;
			}
			@Override
			public Map<enumRessource, Integer> getCout() {
				Map<enumRessource, Integer> cout = new HashMap<>();
				cout.put(enumRessource.Bois, 2); // Coût en bois
				cout.put(enumRessource.Moutons, 1); // Coût en mouton
				return cout;
			}
		};
	}
	@Test
	void testGetDimension() {
		assertEquals(3,batiment.getDimension());
	}
	@Test
	void testSetDimension() {
		batiment.setDimension(5);
		assertEquals(5, batiment.getDimension());
	}
}
