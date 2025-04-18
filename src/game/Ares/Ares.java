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
			player.addWarriors(30);
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

	/**
	 * Vérifie si la partie est terminée.
	 * @return true si la partie est terminée, sinon false.
	 * La partie est considérée comme terminée si un joueur a atteint son objectif.
	 * Les objectifs sont les suivants :
	 * 0 : Avoir 10 tuiles
	 * 1 : Avoir au moins une île occupée
	 * 2 : Avoir 50 guerriers
	 * Si un joueur atteint son objectif, la partie se termine et il est déclaré vainqueur.
	 */
	public boolean gameIsOver() {
		for (Player player : players) {
			if (player.getObjectif() == 0 && player.getNbTuilePossedee() >= 10) {
				return true;
			} 
			else if (player.getObjectif() == 1 && player.getNumberOfIslandsOccupied(action.getGame().getPlateau()) >= 1) {
				return true;
			}
			else if (player.getObjectif() == 2 && player.getWarriorsStock() >= 50) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retourne le joueur gagnant si la partie est terminée.
	 * @return Le joueur gagnant, ou null si aucun joueur n'a gagné.
	 */
	public Player getWinner() {
		for (Player player : players) {
			if (player.getObjectif() == 0 && player.getNbTuilePossedee() >= 10) {
				return player;
			} 
			else if (player.getObjectif() == 1 && player.getNumberOfIslandsOccupied(action.getGame().getPlateau()) >= 1) {
				return player;
			}
			else if (player.getObjectif() == 2 && player.getWarriorsStock() >= 50) {
				return player;
			}
		}
		return null;
	}
}
