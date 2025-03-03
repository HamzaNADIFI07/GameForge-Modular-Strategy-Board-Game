package livrable3;
import java.util.ArrayList;
import java.util.List;

import plateau.Plateau;

public abstract class Game {
	
	    //protected List<Player> players;  // need to create a Player class
	    protected Plateau plateau;           // The game board
	    protected boolean isGameActive;  // Flag to check if the game is currently active
	    
	    /**
	     * Constructor for Game class.
	     * Initializes the game plateau and player list.
	     */
	    public Game() {
	        // this.players = new ArrayList<>(); // while waiting for the creation of player
	        this.plateau = new Plateau(10, 10);  // Assuming default size,
	        this.isGameActive = false;
	    }
	    

}
