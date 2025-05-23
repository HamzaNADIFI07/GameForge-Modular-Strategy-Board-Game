package tuile.type_tuile;

import ressource.Ressource;
import tuile.Tuile;

/**
 * La classe Paturage représente une tuile de type pâturage dans le jeu.
 */
public class Paturage extends Tuile{



    /**
     * Constructeur de la classe Paturage.
     * Initialise une tuile de type Pâturage avec des coordonnées spécifiques.
     * La ressource produite par un pâturage est toujours des moutons.
     * 
     * @param x la coordonnée x de la tuile
     * @param y la coordonnée y de la tuile
     */
    public Paturage(int x, int y) {
        super("Paturage", x, y,Ressource.Moutons);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    /**
     * Retourne la ressource produite par cette tuile (moutons).
     * 
     * @return la ressource produite par la tuile (enumRessource.Moutons)
     */
    public Ressource getRessource() {
        return this.ressource;
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
