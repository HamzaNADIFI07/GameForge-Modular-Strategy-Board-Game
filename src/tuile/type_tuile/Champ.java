package tuile.type_tuile;

import ressource.enumRessource;
import tuile.Tuile;

/**
 * La classe Champ représente une tuile de type champ dans le jeu.
 */
public class Champ extends Tuile {
    
	private final enumRessource ressource;

    /**
     * Constructeur de la classe Champ.
     * Initialise une tuile de type Champ avec des coordonnées spécifiques.
     * La ressource produite par un champ est toujours du blé.
     * 
     * @param x la coordonnée x de la tuile
     * @param y la coordonnée y de la tuile
     */
    public Champ(int x, int y) {
        super("Champ", x, y);
        this.ressource = enumRessource.Ble;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    /**
     * Retourne la ressource produite par cette tuile (blé).
     * 
     * @return la ressource produite par la tuile (enumRessource.Ble)
     */
    public enumRessource getRessource() {
        return ressource;
    }

    /**
     * Produit la resource en incrementant sa quantité
     */
    public enumRessource produireRessource() {
        if (super.getBatiment().getType().equals("Exploitation")||super.getBatiment().getType().equals("Camp")){
            super.incrementerRessource();
            super.incrementerRessource();
        }
        else{
            super.incrementerRessource();
        }
    }

}