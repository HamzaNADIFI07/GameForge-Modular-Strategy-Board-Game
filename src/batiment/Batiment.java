package batiment;

public abstract class Batiment {
    protected String type;
    protected int dimension;
    


    /**
     * Constructeur de la classe Batiment.
     * 
     * @param nom le nom du bâtiment
     * @param dimension la dimensiondu bâtiment
     */
    public Batiment(String type, int dimension) {
        this.type = type;
        this.dimension = dimension;
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
     * Vérifie si le bâtiment peut être construit sur une tuile donnée.(Pour la contrainte des ports, camps, exploitation)
     * 
     * @return true si le bâtiment peut être construit, sinon false
     */
    public abstract boolean peutEtreConstruit();
}

