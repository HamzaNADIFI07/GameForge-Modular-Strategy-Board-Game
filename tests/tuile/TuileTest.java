package tuile;
import plateau.Plateau;
import tuile.type_tuile.Mer;
import tuile.type_tuile.Champ;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
class TuileTest {

@Test
public void testGetType() {
	Tuile mer = new Mer(0, 0); 
    Tuile champ = new Champ(3, 2);
    assertEquals("Mer", mer.getType(), "Le type de la tuile doit être 'Mer'.");
    assertEquals("Champ", champ.getType(), "Le type de la tuile doit être 'champ'.");

}
@Test
public void testGetAdjacents() {
    Plateau plateau = new Plateau(5, 5);
    plateau.genererTuiles();

    Tuile mer1 = plateau.getTuile(0, 0);
    Tuile mer2 = plateau.getTuile(0, 1);
    assertTrue(mer2.getAdjacents(plateau.getTuiles()).contains(mer1));
}
@Test
public void testSetAdjacents() {
    Plateau plateau = new Plateau(5, 5);
    plateau.genererTuiles();

    Tuile mer = plateau.getTuile(0, 0);

    Tuile champ1 = plateau.getTuile(1, 0);
    Tuile champ2 = plateau.getTuile(0, 1);

    // Ajout des tuiles adjacentes à une liste
    List<Tuile> adjacents = new ArrayList<>();
    adjacents.add(champ1);
    adjacents.add(champ2);

    // Définir les tuiles adjacentes
    mer.setAdjacents(adjacents);

    // Vérification que les adjacents ont bien été définis
    List<Tuile> resultatAdjacents = mer.getAdjacents(plateau.getTuiles());
    assertEquals(adjacents, resultatAdjacents);
    assertTrue(resultatAdjacents.contains(champ1), "La liste des adjacents doit contenir champ1.");
    assertTrue(resultatAdjacents.contains(champ2), "La liste des adjacents doit contenir champ2.");
}

}
