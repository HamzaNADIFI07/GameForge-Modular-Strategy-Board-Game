package game;
import java.util.ArrayList;
import java.util.List;
import plateau.Plateau;
import tuile.Tuile;
import tuile.type_tuile.Mer;

public abstract class Game {
		protected Player currentPlayer;
	    protected List<Player> players;  // need to create a Player class
	    protected Plateau plateau;           // The game board
	    protected boolean isGameActive;  // Flag to check if the game is currently active
	    
	    /**
	     * Constructor for Game class.
	     * Initializes the game plateau and player list.
	     */
	    public Game(List<Player> players,int x,int y ) {
	        this.players = new ArrayList<>(); // while waiting for the creation of player
	        this.plateau = new Plateau(x, y);  // Assuming default size,
	        this.isGameActive = false;
	    }
	    //pour obliger les classes dérivées (comme Ares et Demeter) à implémenter
	    //leur propre logique de mise en place initiale du jeu, qui varie selon les 
	    //règles spécifiques de chaque version du jeu.
	    protected abstract void initializeGame();
		
		public boolean isGameActive() {
			return isGameActive;
		}
		public void setGameActive(boolean isGameActive) {
			this.isGameActive = isGameActive;
		}
		public Player getCurrentPlayer() {
			return currentPlayer;
		}
		public void setCurrentPlayer(Player currentPlayer) {
			this.currentPlayer = currentPlayer;
		}
		
		public boolean batimentPeutEtreConstruit(String b, Tuile t) {
			if (t != null && !(t.getType().equals("Mer")) && t.getBatiment() == null) {
				
				// Cas pour la ferme
				if (b.equalsIgnoreCase("ferme")) {
					return true;	
				}

				// Cas pour le port
				if (b.equalsIgnoreCase("port")) {
					for (Tuile adjacente : t.getAdjacents(plateau.getTuiles())) {
						if (adjacente instanceof Mer) {
							return true; // Valide car au moins une tuile adjacente est une mer
						}
					}
				}
				// Cas pour la Armee
				if (b.equalsIgnoreCase("Armee")) {
					return true;
				}
			}
			if (t != null && !(t.getType().equals("Mer"))){
				// Cas pour la Exploitation
				if (b.equalsIgnoreCase("Exploitation")) {
					if (t.getBatiment().getType().equals("Ferme")) {
						return true;
					}
				}
				// Cas pour le camp
				if (b.equalsIgnoreCase("camp")) {
					if (t.getBatiment().getType().equals("Armee")) {
						return true;
					}
				}
			}

			return false;
		}
	    

}
