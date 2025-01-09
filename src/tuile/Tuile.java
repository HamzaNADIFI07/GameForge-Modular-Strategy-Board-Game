package tuile;

public abstract class Tuile {

    protected String type;

    /**
     * Constructeur de la classe Tuile.
     * 
     * @param type le type de la tuile
     */
    public Tuile(String type) {
        this.type = type;
    }

    /**
     * Retourne le type de la tuile.
     * 
     * @return le type de la tuile
     */
    public String getType() {
        return type;
    }
}
