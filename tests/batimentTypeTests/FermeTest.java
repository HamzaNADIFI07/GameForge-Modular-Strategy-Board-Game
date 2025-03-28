package batimentTypeTests;

import org.junit.jupiter.api.Test;

import batiment.type_batiment.Ferme;
import game.Demeter.Demeter;
import ressource.Ressource;
import tuile.type_tuile.Champ;
import tuile.Tuile;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class FermeTest {

    @Test
    public void testForetCreation() {
    	Tuile champTuile = new Champ(2, 2);
    	Ferme ferme = new Ferme(champTuile);
    	assertEquals("Ferme", ferme.getType());
    	assertEquals(champTuile, ferme.getTuile());
    }
    @Test
    public void testFermeCout() {
    	Tuile champTuile = new Champ(2, 2);
    	Ferme ferme = new Ferme(champTuile);
    	Map<Ressource, Integer> cout = ferme.getCout();
    	assertEquals(1, cout.get(Ressource.Bois), "Une ferme coûte 1 bois");
    	assertEquals(1, cout.get(Ressource.Minerai), "Une ferme coûte 1 minerai");
    }

}

