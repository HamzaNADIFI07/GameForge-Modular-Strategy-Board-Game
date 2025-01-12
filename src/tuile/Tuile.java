package tuile;
import java.util.List;

public abstract class Tuile {

    protected String type;
    //protected Batiment batiment;
    protected List<Tuile> adjacents;
    protected int x;
    protected int y;

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
