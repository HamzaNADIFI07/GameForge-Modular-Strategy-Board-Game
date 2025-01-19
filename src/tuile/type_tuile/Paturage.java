package tuile.type_tuile;

import ressource.enumRessource;
import tuile.Tuile;

/**
 * La classe Paturage représente une tuile de type pâturage dans le jeu.
 */
public class Paturage extends Tuile{

	private final enumRessource ressource;


    /**
     * Constructeur de la classe Paturage.
     * Initialise une tuile de type Pâturage avec des coordonnées spécifiques.
     * La ressource produite par un pâturage est toujours des moutons.
     * 
     * @param x la coordonnée x de la tuile
     * @param y la coordonnée y de la tuile
     */
    public Paturage(int x, int y) {
        super("Pâturage", x, y);
        this.ressource = enumRessource.Moutons;
    }

    /**
     * Retourne la ressource produite par cette tuile (moutons).
     * 
     * @return la ressource produite par la tuile (enumRessource.Moutons)
     */
    public enumRessource produireRessource() {
        return ressource;
    }
    
}
