package livrable3.Ares;
import livrable3.Game;
import livrable3.Player;
import plateau.Plateau;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**The `Ares` constructor initializes the game environment 
 and sets each player's warrior stock to 30, essential for
 game operations like combat and building armies.
**/
public abstract class Ares extends Game {
	protected Map<Player, Integer> warriorsStock; // Stock de guerriers pour chaque joueur
	public Ares(List<Player> players, Plateau plateau) {
		super(players, plateau);
		warriorsStock = new HashMap<>();
		for (Player player : players) {
			warriorsStock.put(player, 30);
		}
	}
}
