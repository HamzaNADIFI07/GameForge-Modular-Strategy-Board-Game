package batimentTypeTests;

import org.junit.jupiter.api.Test;

import batiment.type_batiment.Ferme;
import tuile.type_tuile.Champ;
import tuile.Tuile;
import static org.junit.jupiter.api.Assertions.*;

public class FermeTest {

    @Test
    public void testForetCreation() {
    	Tuile champTuile = new Champ(2, 2);
    	Ferme ferme = new Ferme(champTuile);
    	assertEquals("Ferme", ferme.getType());
    	assertEquals(champTuile, ferme.getTuile());
    }
}

