package batiment;

import game.Player;
import java.util.Map;
import ressource.Ressource;
import tuile.Tuile;

/**
 * Classe abstraite Batiment, qui définit les caractéristiques communes à tous les bâtiments.
 */
public abstract class Batiment {
    protected String type;// le nom du bâtiment
    protected int dimension;// la dimension du bâtiment
    protected Tuile tuile;// la tuile sur laquelle le bâtiment est construit
    protected Player player;// le joueur qui possède le bâtiment
    


    /**
     * Constructeur de la classe Batiment.
     * 
     * @param type le nom du bâtiment
     * @param dimension la dimensiondu bâtiment
     * @param tuile la tuile du bâtiment
     */
    public Batiment(String type, int dimension, Tuile tuile) {
        this.type = type;
        this.dimension = dimension;
        this.tuile = tuile;
        tuile.setBatiment(this);
    }

    /**
     * Retourne le type du bâtiment.
     * 
     * @return le type du bâtiment
     */
    public String getType() {
        return type;
    }

    /**
     * Retourne la dimension du bâtiment.
     * 
     * @return la dimension du bâtiment
     */
    public int getDimension() {
        return dimension;
    }

    /**
     * Définit une nouvelle dimension pour le bâtiment.
     * 
     * @param dimension la nouvelle dimension du bâtiment
     */
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
    /**
     * Augmente la dimension du bâtiment d'une valeur donnée.
     * 
     * @param dimension la valeur à ajouter à la dimension actuelle
     */
    public void increaseDimension(int dimension) {
        this.dimension += dimension;
    }

    /**
     * Diminue la dimension du bâtiment d'une valeur donnée.
     * 
     * @param dimension la valeur à diminuer à la dimension actuelle
     */
    public void decreaseDimension(int dimension) {
        this.dimension -= dimension;
    }

    /**
     * Retourne la tuile sur laquelle le bâtiment est construit.
     * 
     * @return la tuile sur laquelle le bâtiment est construit
     */
    public Tuile getTuile() {
        return tuile;
    }

    /**
     * Retourne le coût de construction du bâtiment.
     * 
     * @return une Map contenant les ressources nécessaires
     */
    public abstract Map<Ressource, Integer> getCout();

    /**
     * Retourne le joueur qui possède le bâtiment.
     * 
     * @return le joueur qui possède le bâtiment
     */
    public Player getPlayer() {
        return player;
    }
    /**
     * Définit le joueur qui possède le bâtiment.
     * 
     * @param player le joueur qui possède le bâtiment
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
}

