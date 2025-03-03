package livrable3;
import java.util.ArrayList;
import java.util.List;

import plateau.Plateau;

public abstract class Game {
		protected Player currentPlayer;
	    protected List<Player> players;  // need to create a Player class
	    protected Plateau plateau;           // The game board
	    protected boolean isGameActive;  // Flag to check if the game is currently active
	    
	    /**
	     * Constructor for Game class.
	     * Initializes the game plateau and player list.
	     */
	    public Game() {
	        this.players = new ArrayList<>(); // while waiting for the creation of player
	        this.plateau = new Plateau(10, 10);  // Assuming default size,
	        this.isGameActive = false;
	    }
	    //pour obliger les classes dérivées (comme Ares et Demeter) à implémenter
	    //leur propre logique de mise en place initiale du jeu, qui varie selon les 
	    //règles spécifiques de chaque version du jeu.
	    protected abstract void initializeGame();
	    
	    

}
