package Demeter;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import batiment.type_batiment.Exploitation;
import batiment.type_batiment.Ferme;
import game.Game;
import game.Player;
import game.Demeter.Action_Demeter;
import game.Demeter.Demeter;
import plateau.Plateau;
import ressource.Ressource;
import tuile.Tuile;
import org.junit.jupiter.api.Test;
class Action_DemeterTest {
	private Plateau plateau;
	private Player player;
	private Demeter game;
	private Action_Demeter actionDemeter;
	private Tuile tuile;
	
	@BeforeEach
	void setUp() {
		player = new Player("leon");
		
		List<Player> players = new ArrayList<>();
		players.add(player);
		game = new Demeter(players, 10, 10);
		plateau = game.getPlateau();
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
		assertTrue(player.getRessources().get(Ressource.Bois)==10);
		assertTrue(player.getRessources().get(Ressource.Ble)==10);
		assertTrue(player.getRessources().get(Ressource.Minerai)==10);
		assertTrue(player.getRessources().get(Ressource.Moutons)==10);
		
		int x = tuile.getX();
		int y = tuile.getY();
		actionDemeter.construireFerme(x, y);
		assertTrue(player.getBatimentsPossedes().stream().anyMatch(b -> b instanceof Ferme));
		assertTrue(tuile.getBatiment() instanceof Ferme);
	}
	@Test
	void testConstruireExploitation() {
		
		int x = tuile.getX();
		int y = tuile.getY();
		actionDemeter.construireFerme(x, y);
		actionDemeter.construireExploitation(x, y);
		assertTrue(player.getBatimentsPossedes().stream().anyMatch(b -> b instanceof Exploitation));
		assertTrue(tuile.getBatiment() instanceof Exploitation);
	}
	@Test
	void testConstruirePort() {
		player.addRessource(Ressource.Bois, 5);
		player.addRessource(Ressource.Moutons, 5);
		int x = tuile.getX();
		int y = tuile.getY();
		actionDemeter.construirePort(x, y);
		assertTrue(player.getBatimentsPossedes().stream().anyMatch(b -> b instanceof Exploitation));
		assertTrue(tuile.getBatiment() instanceof Exploitation);
	}

}
