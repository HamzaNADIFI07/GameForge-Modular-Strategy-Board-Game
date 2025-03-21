package game.Demeter;

import game.Game;
import game.Player;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demeter extends Game {
	protected Map<Player, Integer> resourceStock;
	private Action_Demeter action;
	
	public Demeter(List<Player> players,int x,int y ) {
		super(players, x,y);
		resourceStock = new HashMap<>();
		this.action = new Action_Demeter(this);
	}
	protected  void initializeGame(){
		
	}
	public Action_Demeter getAction() {
		return action;
	};
	

}






