package plateau;
import plateau.Plateau;
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
    int nombreTuilesNonMer = plateau.getNbTuilesNonMer();
    assertEquals(plateau.getX() * plateau.getY() / 3, nombreTuilesNonMer, 
        "Le nombre de tuiles non-Mer doit être égal à 1/3 du nombre total de tuiles.");
}

}
