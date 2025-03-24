package game.Ares;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import batiment.Batiment;
import batiment.type_batiment.Armee;
import batiment.type_batiment.Camp;
import batiment.type_batiment.Port;
import game.Player;
import game.Ares.Action_Ares;
import plateau.Plateau;
import ressource.Ressource;
import tuile.Tuile;

public class Livrable3AresTest {

    private Tuile findValidTuile(Plateau plateau) {
        for (int i = 0; i < plateau.getTuiles().length; i++) {
            for (int j = 0; j < plateau.getTuiles()[i].length; j++) {
                Tuile t = plateau.getTuile(i, j);
                if (t.getBatiment() == null && !t.getType().equals("Mer")) {
                    return t;
                }
            }
        }
        return null;
    }

    @Test
    void testScenarioCompletAres() {
        Player player = new Player("Leon");
        List<Player> players = new ArrayList<>();
        players.add(player);

        Plateau plateau = new Plateau(10, 10);
        Action_Ares action = new Action_Ares(null, player);

        Tuile tuileArmee = findValidTuile(plateau);
        assertNotNull(tuileArmee, "Aucune tuile valide trouvée pour l'armée.");
        player.addTuile(tuileArmee);

        // Ressources et guerriers en stock
        player.addWarriors(3);
        for (Ressource r : Ressource.values()) {
            player.addRessource(r, 20);
        }

        // Étape 1 : construire une armée avec 1 guerrier
        assertTrue(action.construireArmee(tuileArmee));
        Armee armee = (Armee) tuileArmee.getBatiment();
        assertEquals(3, armee.getNbGuerriers());

        // Étape 2 : ajouter 2 guerriers à l'armée pour arriver à 5
        armee.addGuerriers(1);
        armee.addGuerriers(1);
        assertEquals(5, armee.getNbGuerriers());

        // Étape 3 : transformer en camp
        assertTrue(action.remplacerArmeeParCamp(tuileArmee));
        assertTrue(tuileArmee.getBatiment() instanceof Camp);

        // Étape 4 : acheter 5 guerriers
        assertTrue(action.ajouterGuerriersAuStock());
        assertTrue(player.hasWarriorsInStock(5));

        // Étape 5 : construire un port
        Tuile tuilePort = findValidTuile(plateau);
        assertNotNull(tuilePort);
        player.addTuile(tuilePort);
        assertTrue(action.construirePort(tuilePort));
        assertTrue(tuilePort.getBatiment() instanceof Port);

        // Étape 6 : échange 3 ressources contre 1
        player.echangerRessources(3, Ressource.Bois, Ressource.Minerai, false);

        // Étape 7 : acheter une arme secrète
        player.addRessource(Ressource.Bois, 1);
        player.addRessource(Ressource.Minerai, 1);
        player.buySecretWeapon();
        // (pas d'assert ici, la méthode affiche uniquement)

        // Étape 8 : vérification finale
        assertTrue(player.getBatimentsPossedes().stream().anyMatch(b -> b instanceof Camp));
        assertTrue(player.getBatimentsPossedes().stream().anyMatch(b -> b instanceof Port));
        assertEquals(2, player.getDisplayTuilesPossedes().size());
    }
}

