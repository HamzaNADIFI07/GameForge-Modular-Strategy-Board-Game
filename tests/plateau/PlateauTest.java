package plateau;
import plateau.Plateau;
import tuile.type_tuile.Mer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlateauTest{
	
	private Plateau plateau;

	@BeforeEach
	public void setup() {
		plateau = new Plateau(10, 10); // Plateau 10x10
	}
	@Test
	public void testGenererTuiles() {
		plateau.genererTuiles();
		int nombreTuileMer = plateau.getNbTuilesMer();
		int nbTuiles = plateau.getX() * plateau.getY();
		assertTrue(nombreTuileMer>=2*nbTuiles/3, 
				"Le nombre de tuiles non-Mer doit être égal à 1/3 du nombre total de tuiles.");
	}
	@Test
	public void testPlateauInitialiseAvecMer() {
    	// Vérifie que le plateau est bien initialisé avec uniquement des tuiles de type Mer
    	boolean toutEstMer = true;

    	for (int i = 0; i < plateau.getX(); i++) {
    		for (int j = 0; j < plateau.getY(); j++) {
    			if (!(plateau.getTuile(i, j) instanceof Mer)) {
    				toutEstMer = false;
        		}	
        	}
    	}
	assertTrue(toutEstMer, "Tous les éléments du plateau doivent être des tuiles de type Mer au début.");
	}
}
