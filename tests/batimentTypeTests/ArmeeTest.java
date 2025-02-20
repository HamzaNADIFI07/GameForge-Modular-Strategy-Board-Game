package batimentTypeTests;

import batiment.type_batiment.Armee;
import ressource.enumRessource;

import org.junit.jupiter.api.Test;
import tuile.Tuile;
import tuile.type_tuile.Paturage;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

class ArmeeTest {

    @Test
    public void testArmeeCreation() {
        Tuile tuile = new Paturage(1, 1);
        Armee armee = new Armee(tuile, 3);
        
        assertEquals("Armee", armee.getType());
        assertEquals(3, armee.getDimension());
        assertEquals(tuile, armee.getTuile());
        assertThrows(IllegalArgumentException.class, () -> new Armee(tuile, 6), "Armée doit avoir entre 1 et 5 guerriers");
    }
    
    @Test
    public void testArmeeCout() {
    	Tuile tuile = new Paturage(1,1);
    	Armee armee = new Armee(tuile,3);
    	Map<enumRessource, Integer> cout = armee.getCout();
    	assertEquals(1, cout.get(enumRessource.Bois));
    	assertEquals(1, cout.get(enumRessource.Moutons));
    	assertEquals(1, cout.get(enumRessource.Ble));
    }
   


}

