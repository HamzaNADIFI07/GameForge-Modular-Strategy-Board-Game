package tuile;
import plateau.Plateau;
import tuile.type_tuile.Mer;
import tuile.type_tuile.Champ;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TuileTest {

@Test
public void testGetType() {
	Tuile mer = new Mer(0, 0); 
    Tuile champ = new Champ(3, 2);
    assertEquals("Mer", mer.getType(), "Le type de la tuile doit être 'Mer'.");
    assertEquals("Champ", champ.getType(), "Le type de la tuile doit être 'champ'.");

}
}
