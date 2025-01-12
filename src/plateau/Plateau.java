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
        this.setNbMers(x*y);
        this.setNbChamps(0);
        this.setNbForets(0);
        this.setNbMontagnes(0);
        this.setNbPaturages(0);
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
     * Génère une tuile non-marine aléatoirement
     */
    private Tuile genererTuileNonMerAleatoire() {
        Random random = new Random();
        int type = random.nextInt(4); // 4 types de tuiles non-marines

        switch (type) {
            case 0: 
                return new Champ();
            case 1: 
                return new Foret();
            case 2: 
                return new Montagne();
            case 3: 
                return new Paturage();
            default: 
                return new Mer(); //à la base ils sont tous de type Mer mais on mais le cas par defaut Mer au cas où par securité
        }
    }

    /**
     * Affiche le plateau de jeu dans la console.
     */
    public void display() {
        // Ligne supérieure
        System.out.print("   ");
        for (int j = 0; j < this.x; j++) {
            // La condition permet de gérer le décalage des indice quand l'indice dépace 9 donc il devient un nombre à deux chiffre, on enlève un décalage pour avoir chque indice bien aligner avec la colonne dédié
            if (j<10) {
                System.out.print("   " + j + "  ");
            }
            else{
                System.out.print("  " + j + "  ");
            }
        }
        System.out.println();
        
        // Bordure supérieure de chaque ligne
        System.out.print("   ");
        for (int j = 0; j < this.x; j++) {
            System.out.print("+-----");
        }
        System.out.println("+");
    
        // Contenu du plateau
        for (int i = 0; i < this.y; i++) {
            System.out.printf("%2d ", i);// Affiche le numéro de ligne avec un décalage
            for (int j = 0; j < this.x; j++) {
                if ("Mer".equals(tuile[j][i].getType()) || "Montagne".equals(tuile[j][i].getType())) {
                    System.out.print("| " + tuile[j][i].getType().charAt(0)+ tuile[j][i].getType().charAt(1) + "  ");//affiche la première et deuxième lettre des types des tuiles Mer et Montagne vu que les deux commencent par M, donc pour éviter la confusions entre les deux on affiche les deux premières carctères de leur types
                }
                else{
                    System.out.print("|  " + tuile[j][i].getType().charAt(0) + "  ");//affiche la première lettre de chaque type de tuile
                }
            }
            System.out.println("|");
    
            // Bordure inférieure de chaque ligne
            System.out.print("   ");
            for (int j = 0; j < this.x; j++) {
                System.out.print("+-----");
            }
            System.out.println("+");
        }
    }

	public int getNbMers() {
		return nbMers;
	}

	public void setNbMers(int nbMers) {
		this.nbMers = nbMers;
	}

	public int getNbChamps() {
		return nbChamps;
	}

	public void setNbChamps(int nbChamps) {
		this.nbChamps = nbChamps;
	}

	public int getNbForets() {
		return nbForets;
	}

	public int getNbMontagnes() {
		return nbMontagnes;
	}



	public int getNbPaturages() {
		return nbPaturages;
	}

    

    }
	

