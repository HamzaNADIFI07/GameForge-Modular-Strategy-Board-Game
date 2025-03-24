package game.Demeter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Game;
import game.Player;
import plateau.Plateau;
import ressource.Ressource;
import tuile.Tuile;

class Action_DemeterTest {
	private Plateau plateau;
	private Player player;
	private Demeter game;
	private Action_Demeter actionDemeter;
	private Tuile tuile;
	
	@BeforeEach
	void setUp() {
		plateau = new Plateau(10, 10);
		player = new Player("leon");
		
		List<Player> players = new ArrayList<>();
		players.add(player);
		game = new Demeter(players, 10, 10);
		actionDemeter = game.getAction();
		tuile = getFirstNonMerTile();
		assertNotNull(tuile, "Aucune tuile construisible trouvée.");
		


	}
	/*
	 * Retourne une tuile qui n'est pas de type Mer (pour construire dessus).
	 * 
	 */
	private Tuile getFirstNonMerTile() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Tuile t = plateau.getTuile(i, j);
				if (!(t instanceof tuile.type_tuile.Mer)) {
					return t;
				}
			}
		}
		return null;
	}
	@Test
	void testConstruireFerme() {
		player.addRessource(Ressource.Bois, 5);
		player.addRessource(Ressource.Minerai, 5);
		int x = tuile.getX();
		int y = tuile.getY();
		actionDemeter.construireFerme(x, y);
		assertTrue(player.getBatimentsPossedes()
				.stream()
				.anyMatch(b -> b.getClass().getSimpleName().equals("Ferme")));
	}
	@Test
	void testConstruireExploitation() {
		player.addRessource(Ressource.Bois, 5);
		player.addRessource(Ressource.Minerai, 3);
		player.addRessource(Ressource.Ble, 3);
		player.addRessource(Ressource.Moutons, 3);
		
		int x = tuile.getX();
		int y = tuile.getY();
		actionDemeter.construireFerme(x, y);
		actionDemeter.construireExploitation(x, y);
		assertTrue(player.getBatimentsPossedes()
				.stream()
				.anyMatch(b -> b.getClass().getSimpleName().equals("Exploitation")));
	}

}
