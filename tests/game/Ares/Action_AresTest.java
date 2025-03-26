package game.Ares;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Game;
import game.Player;
import plateau.Plateau;
import tuile.Tuile;

class Action_AresTest {
	private Action_Ares actionAres;
	private Player player;
	private Plateau plateau;
	private Game game;
	@BeforeEach
	void setUp() {
		plateau = new Plateau(10, 10);
		player = new Player("Leon");
		actionAres = new Action_Ares(game);
	}
	/*
	 * Finds the first non-Mer tile on the board
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
	/*
	 * Tests if an army can be built on a valid tile
	 */
	@Test
	void testConstruireArmee() {
		Tuile t = getFirstNonMerTile();
		assertNotNull(t, "No valid tile found for army.");
		assertTrue(actionAres.construireArmee(t));
	}

}
