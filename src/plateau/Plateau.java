package plateau;

import java.util.Random;
import tuile.Tuile;
import tuile.type_tuile.Champ;
import tuile.type_tuile.Foret;
import tuile.type_tuile.Mer;
import tuile.type_tuile.Montagne;
import tuile.type_tuile.Paturage;

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
     * Génère aléatoirement les tuiles du plateau en respectant une contrainte 
     * de proportion : 1/3 des tuiles sont non-Mer, et 2/3 sont des tuiles de type Mer.
     */

    public void genererTuiles() {

        Random random = new Random();

        int nombreNonMer = (int) ((this.x * this.y) * (1.0 / 3.0));
        int tuilesNonMerPlacees = 0;

        // Boucle avec condition qui vérifie la contrainte de 1/3 Tuile Non Mer et 2/3 Tuile Mer
        while (tuilesNonMerPlacees < nombreNonMer) {
            int randomX = random.nextInt(this.x);
            int randomY = random.nextInt(this.y);

            // Vérifie que la case est encore Mer pour ne pas recréer une tuile non Mer sur une tuile qui est déjà non Mer
            if (tuile[randomX][randomY] instanceof Mer) {
                // Place une tuile non-marine aléatoire
                tuile[randomX][randomY] = genererTuileNonMerAleatoire();// ça cause une erreur pour l'instant le temps qu'on implémente la méthode genererTuileNonMerAleatoire() qui génere les tuiles avec un type aléatoire
                tuilesNonMerPlacees++;
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
	

