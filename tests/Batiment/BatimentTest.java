package batimentTypeTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import batiment.Batiment;
import ressource.Ressource;
import tuile.Tuile;
import tuile.type_tuile.Champ;

import java.util.Map;
import java.util.HashMap;

public class BatimentTest {
    private Batiment batiment;
    private Tuile tuile;

    @BeforeEach
    public void setUp() {
        tuile = new Champ(0, 0);

        batiment = new Batiment("TestBatiment", 3, tuile) {
            @Override
            public Map<Ressource, Integer> getCout() {
                Map<Ressource, Integer> cout = new HashMap<>();
                cout.put(Ressource.Bois, 2);
                cout.put(Ressource.Moutons, 1);
                return cout;
            }
        };
    }

    @Test
    public void testGetDimension() {
        assertEquals(3, batiment.getDimension());
    }

    @Test
    public void testSetDimension() {
        batiment.setDimension(5);
        assertEquals(5, batiment.getDimension());
    }

    @Test
    public void testGetTuile() {
        assertEquals(tuile, batiment.getTuile());
    }

    @Test
    public void testGetCout() {
        Map<Ressource, Integer> expectedCout = new HashMap<>();
        expectedCout.put(Ressource.Bois, 2);
        expectedCout.put(Ressource.Moutons, 1);
        assertEquals(expectedCout, batiment.getCout());
    }
}
