package tuile;
import plateau.Plateau;
import tuile.type_tuile.Mer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TuileTest {

    private Tuile tuile;

    @BeforeEach
    public void setup() {
        Tuile tuile = new Mer(0, 0); 
        assertEquals("Mer", tuile.getType());
    }
    
}
