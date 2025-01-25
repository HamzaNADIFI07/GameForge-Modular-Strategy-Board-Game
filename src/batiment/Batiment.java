package batiment;

public abstract class Batiment {
    protected String type;
    protected int dimension;


    /**
     * Constructeur de la classe Batiment.
     * 
     * @param nom le nom du bâtiment
     * @param taille la taille ou la capacité du bâtiment
     */
    public Batiment(String type, int dimension) {
        this.type = type;
        this.dimension = dimension;
    }

    public abstract int getDimension();

    public abstract int setDimension();  /** sous reserve */
}

