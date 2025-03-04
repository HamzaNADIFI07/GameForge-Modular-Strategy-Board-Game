package game.Demeter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.Game;
import game.Player;
import plateau.Plateau;

public abstract class Demeter extends Game {
	protected Map<Player, Integer> resourceStock;
	
	public Demeter(List<Player> players, Plateau plateau) {
		super(players, plateau);
		resourceStock = new HashMap<>();
	}

}
