package game.Ares;
import game.Game;
import game.Player;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tuile.Tuile;

/**The `Ares` constructor initializes the game environment 
 and sets each player's warrior stock to 30, essential for
 game operations like combat and building armies.
**/
public class Ares extends Game {

	protected Map<Player, Integer> warriorsStock; // Stock de guerriers pour chaque joueur

	private Action_Ares action;

	public Ares(List<Player> players,int x,int y) {
		super(players,x,y);
		warriorsStock = new HashMap<>();
		for (Player player : players) {
			warriorsStock.put(player, 30);
		}
		this.action = new Action_Ares(this);
		
	}
	
	public Action_Ares getAction() {
		return action;
	}

	/**
     * Initialise le jeu avec les configurations spécifiques à Ares.
     */
	protected  void initializeGame(){
		
	}

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
