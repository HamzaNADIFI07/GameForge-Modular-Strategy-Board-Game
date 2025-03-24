package game.Demeter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Game;
import game.Player;
import plateau.Plateau;
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

}
