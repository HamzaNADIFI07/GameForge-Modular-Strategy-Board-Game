package plateau;

import tuile.Tuile;
import tuile.type_tuile.Mer;

public class Plateau {
	private Tuile[][] tuile ;
	private int x ;
	private int y;
	private int nbMers;
    private int nbChamps;
    private int nbForets;
    private int nbMontagnes;
    private int nbPaturages;


    /**
     * Constructeur de la classe Plateau.
     * Initialise un plateau de dimensions x par y, avec uniquement des tuiles de type Mer.
     * 
     * @param x la largeur du plateau (nombre de colonnes)
     * @param y la hauteur du plateau (nombre de lignes)
     */
    
    public Plateau(int x, int y) {
        this.x = x;
        this.y = y;
        this.tuile = new Tuile[x][y];
        this.nbMers = x*y;
        this.nbChamps = 0;
        this.nbForets = 0;
        this.nbMontagnes = 0;
        this.nbPaturages = 0;
        initialiserPlateau();
    
    }

    /**
     * Initialise le plateau avec des tuiles de type Mer.
     */
    
    private void initialiserPlateau() {
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                tuile[i][j] = new Mer();
            }
        }
    }

    /**
     * Affiche le plateau de jeu dans la console.
     */
    public void display() {
        for (int i = 0; i < this.y; i++) {
            for (int j = 0; j < this.x; j++) {
                System.out.print(tuile[j][i].getType().charAt(0) + " ");
            }
            System.out.println();
        }
    }

    }
	

