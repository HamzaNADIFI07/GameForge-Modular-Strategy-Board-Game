package batimentTypeTests;

import batiment.type_batiment.Armee;
import org.junit.jupiter.api.Test;
import tuile.Tuile;
import tuile.type_tuile.Paturage;


import static org.junit.jupiter.api.Assertions.*;

class ArmeeTest {

    @Test
    void testArmeeCreation() {
        Tuile tuile = new Paturage(1, 1);
        Armee armee = new Armee(tuile, 3);
        
        assertEquals("Armee", armee.getType());
        assertEquals(3, armee.getDimension());
        assertEquals(tuile, armee.getTuile());
        assertThrows(IllegalArgumentException.class, () -> new Armee(tuile, 6), "Armée doit avoir entre 1 et 5 guerriers");
    }
    
   


}

