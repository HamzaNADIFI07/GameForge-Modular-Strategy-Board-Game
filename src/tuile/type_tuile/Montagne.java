package tuile.type_tuile;

import ressource.enumRessource;
import tuile.Tuile;
/**
 * La classe Montagne représente une tuile de type montagne dans le jeu.
 */
public class Montagne extends Tuile {


    /**
     * Constructeur de la classe Montagne.
     * Initialise une tuile de type Montagne avec des coordonnées spécifiques.
     * La ressource produite par une montagne est toujours du minerai.
     * 
     * @param x la coordonnée x de la tuile
     * @param y la coordonnée y de la tuile
     */
    public Montagne(int x, int y) {
        super("Montagne", x, y , enumRessource.Minerai);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    /**
     * Retourne la ressource produite par cette tuile (minerai).
     * 
     * @return la ressource produite par la tuile (enumRessource.Minerai)
     */
    public enumRessource getRessource() {
        return ressource;
    }

    /**
     * Produit la resource en incrementant sa quantité
     */
    public void produireRessource() {
        if (super.getBatiment().getType().equals("Exploitation")||super.getBatiment().getType().equals("Camp")){
            super.incrementerRessource();
            super.incrementerRessource();
        }
        else{
            super.incrementerRessource();
        }
    }
}