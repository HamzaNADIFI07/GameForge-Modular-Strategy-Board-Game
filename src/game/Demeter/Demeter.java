package game.Demeter;

import game.Game;
import game.Player;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe Demeter.
 *
 * Cette classe étend la classe abstraite Game et définit les caractéristiques spécifiques du jeu Demeter. 
 * Elle gère le stock de ressources des joueurs et fournit un accès aux actions spécifiques au jeu via la classe Action_Demeter.
 *
 */
public class Demeter extends Game {

	protected Map<Player, Integer> resourceStock;

	private Action_Demeter action;
	
	/**
     * Constructeur de la classe Demeter.
     *
     * @param players Liste des joueurs participants.
     * @param x Largeur du plateau.
     * @param y Hauteur du plateau.
     */
	public Demeter(List<Player> players,int x,int y ) {
		super(players, x,y);
		resourceStock = new HashMap<>();
		this.action = new Action_Demeter(this);
	}
	/**
     * Initialise le jeu avec les configurations spécifiques à Demeter.
     */
	protected  void initializeGame(){
		
	}

	/**
     * Retourne l'objet permettant d'effectuer des actions spécifiques à Demeter.
     *
     * @return L'instance de Action_Demeter associée à ce jeu.
     */
	public Action_Demeter getAction() {
		return action;
	};

	public boolean gameIsOver() {
		for (Player player : players) {
			if (plateau.getNombreIlesOccupe(player)==2) {
				player.incrementerPoints(1);
			}
			 else if (plateau.getNombreIlesOccupe(player)>2) {
				player.incrementerPoints(2);
			}
			if (player.getPoints()>=12) {
				System.out.println(player.getName() + " a gagné !");
				return true;
			}
		}
		return false;
	}
	

}






