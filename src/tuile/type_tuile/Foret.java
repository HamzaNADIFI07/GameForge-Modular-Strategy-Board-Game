package tuile.type_tuile;

import ressource.Ressource;
import tuile.Tuile;

/**
 * La classe Foret représente une tuile de type forêt dans le jeu.
 */
public class Foret extends Tuile{

    
    /**
     * Constructeur de la classe Foret.
     * Initialise une tuile de type Forêt avec des coordonnées spécifiques.
     * La ressource produite par une forêt est toujours du bois.
     * 
     * @param x la coordonnée x de la tuile
     * @param y la coordonnée y de la tuile
     */
	public Foret(int x, int y) {
	    super("Foret", x, y , Ressource.Bois);
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
    public Ressource getRessource() {
        return ressource;
    }

    /**
     * Produit la resource en incrementant sa quantité
     */
    public void produireRessource() {
        if (super.getBatiment() != null && 
            (super.getBatiment().getType().equals("Exploitation") || super.getBatiment().getType().equals("Camp"))) {
            super.incrementerRessource();
            super.incrementerRessource();
        } else {
            super.incrementerRessource();
        }
    }

}
