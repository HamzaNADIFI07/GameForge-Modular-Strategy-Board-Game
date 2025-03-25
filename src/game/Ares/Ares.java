package game.Ares;
import plateau.Plateau;
import tuile.Tuile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.Game;
import game.Player;

/**The `Ares` constructor initializes the game environment 
 and sets each player's warrior stock to 30, essential for
 game operations like combat and building armies.
**/
public abstract class Ares extends Game {
	protected Map<Player, Integer> warriorsStock; // Stock de guerriers pour chaque joueur
	public Ares(List<Player> players,int x,int y) {
		super(players,x,y);
		warriorsStock = new HashMap<>();
		for (Player player : players) {
			warriorsStock.put(player, 30);
		}
		
	}
	public abstract Action_Ares getAction();
	public Tuile trouverTuileConstruisible(String typeBatiment) {
		for (Tuile[] ligne : plateau.getTuiles()) {
			for (Tuile t : ligne) {
				if (t.getBatiment() == null && !t.getType().equals("Mer")) {
					return t;
				}
			}
		}
		return null;
	}
}
