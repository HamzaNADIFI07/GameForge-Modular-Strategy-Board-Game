package tuile.type_tuile;

import tuile.Tuile;

/**
 * La classe Mer représente une tuile de type mer dans le jeu.
 * Les tuiles de type mer ne produisent aucune ressource et ne peuvent pas contenir de bâtiment.
 */
public class Mer extends Tuile{


    /**
     * Constructeur de la classe Mer.
     * Initialise une tuile de type Mer avec des coordonnées spécifiques.
     * 
     * @param x la coordonnée x de la tuile
     * @param y la coordonnée y de la tuile
     */
    public Mer(int x, int y) {
        super("Mer", x, y, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Implémentation de la méthode abstraite produireRessource().
     * La mer ne produit aucune ressource.
     */
    @Override
    public void produireRessource() {
        // La mer ne produit rien, donc cette méthode reste vide
    }
}
