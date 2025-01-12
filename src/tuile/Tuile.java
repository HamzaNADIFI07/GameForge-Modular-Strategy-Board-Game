package tuile;
import java.util.ArrayList;
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
    public Tuile(String type,int x,int y) {
        this.type = type;
        this.x=x;
        this.y=y;
        this.adjacents = new ArrayList<>();
    }

    /**
     * Retourne le type de la tuile.
     * 
     * @return le type de la tuile
     */
    public String getType() {
        return type;
    }
    public List<Tuile> getAdjacents(){
    	return adjacents;
    }
    public void setAdjacents(List<Tuile> adjacents) {
    	this.adjacents = adjacents;
    }
    //cette méthode ert à forcer les sous-classes à définir comment chaque type de tuile produit une ressource spécifique
    //mais il faut definir une classe abstraite Ressource
    //public abstract Ressource produireRessource();
    
    
}
