package tuile.type_tuile;

import ressource.enumRessource;
import tuile.Tuile;

/**
 * La classe Foret représente une tuile de type forêt dans le jeu.
 */
public class Foret extends Tuile{

    private final enumRessource ressource;
    
    /**
     * Constructeur de la classe Foret.
     * Initialise une tuile de type Forêt avec des coordonnées spécifiques.
     * La ressource produite par une forêt est toujours du bois.
     * 
     * @param x la coordonnée x de la tuile
     * @param y la coordonnée y de la tuile
     */
	public Foret(int x, int y) {
	    super("Forêt", x, y);
        this.ressource = enumRessource.Bois;
}


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    /**
     * Retourne la ressource produite par cette tuile (bois).
     * 
     * @return la ressource produite par la tuile (enumRessource.Bois)
     */
    public enumRessource getRessource() {
        return ressource;
}

}
