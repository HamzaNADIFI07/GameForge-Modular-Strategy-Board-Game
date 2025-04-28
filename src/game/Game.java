package game;
import java.util.List;
import plateau.Plateau;
import tuile.Tuile;
import tuile.type_tuile.Mer;


/**
 * Classe abstraite représentant une partie générique de jeu.
 *
 * Cette classe fournit les fonctionnalités communes nécessaires à tous les jeux dérivés comme Ares ou Demeter. 
 * Elle gère le plateau, les joueurs, l'état de la partie.
 * 
 * Les sous-classes doivent fournir une implémentation concrète pour initialiser les éléments spécifiques du jeu concerné
 * 
 */
public abstract class Game {

	/** Joueur actuellement actif dans la partie. */
	protected Player currentPlayer;

	/** Liste des joueurs participant à la partie. */
    protected List<Player> players;

	/** Plateau de jeu où se déroule la partie. */
    protected Plateau plateau;  
		
	/** Indique si la partie est actuellement en cours. */// The game board
    protected boolean isGameActive;
	    
    /**
 	* Constructeur de la classe Game.
 	*
 	* @param players Liste des joueurs participants.
 	* @param x Largeur du plateau de jeu.
 	* @param y Hauteur du plateau de jeu.
	*/
    public Game(List<Player> players,int x,int y ) {
        this.players = players; // while waiting for the creation of player
        this.plateau = new Plateau(x, y);  // Assuming default size,
        this.isGameActive = false;
    }

    //pour obliger les classes dérivées (comme Ares et Demeter) à implémenter
    //leur propre logique de mise en place initiale du jeu, qui varie selon les 
    //règles spécifiques de chaque version du jeu.
	/**
     * Initialise le jeu selon les règles spécifiques définies par les sous-classes.
     */
    protected abstract void initializeGame();
	
	/**
     * Vérifie si la partie est en cours.
     *
     * @return true si la partie est active, sinon false.
     */
	public boolean isGameActive() {
		return isGameActive;
	}

	/**
     * Définit l'état actif de la partie.
     *
     * @param isGameActive État actif à définir pour la partie.
     */
	public void setGameActive(boolean isGameActive) {
		this.isGameActive = isGameActive;
	}

	/**
     * Retourne le joueur actuellement actif.
     *
     * @return Joueur courant.
     */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	/**
     * Définit le joueur actif.
     *
     * @param currentPlayer Joueur à définir comme actif.
     */
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
		
	/**
     * Retourne le plateau de jeu actuel.
     *
     * @return Plateau du jeu.
     */
	public Plateau getPlateau() {
		return plateau;
	}

	/**
     * Vérifie si un bâtiment spécifique peut être construit sur une tuile donnée selon les règles du jeu.
     *
     * @param b Type du bâtiment à construire.
     * @param t Tuile sur laquelle on souhaite construire le bâtiment.
     * @return true si la construction est autorisée, sinon false.
     */
	public boolean batimentPeutEtreConstruit(String b, Tuile t) {
		if (t != null && !(t.getType().equals("Mer")) && t.getBatiment() == null) {
				
			// Cas pour la ferme
			if (b.equalsIgnoreCase("ferme") ) {
				return true;	
			}

			// Cas pour le port
			if (b.equalsIgnoreCase("port")) {
				for (Tuile adjacente : t.getAdjacents(plateau.getTuiles())) {
					if (adjacente instanceof Mer) {
						return true;
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
		System.out.println("Vous ne pouvez pas construire un " + b + " sur cette tuile");
		return false;
	}
	/**
     * Retourne la liste des joueurs participant à la partie.
     *
     * @return Liste des joueurs.
     */
	public List<Player> getPlayers() {
		return players;
	}

	/**
     * Définit la liste des joueurs participant à la partie.
     *
     * @param players Liste des joueurs à définir.
     */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void addPlayer(Player player){
		this.players.add(player);
	}

	/**
	 * Vérifie si la partie est terminée.
	 * @return true si la partie est terminée, sinon false.
	 */
	public abstract boolean gameIsOver();

	/**
	 * Retourne le joueur gagnant de la partie.
	 *
	 * @return Joueur gagnant.
	 */
	public abstract Player getWinner();
	 


}
