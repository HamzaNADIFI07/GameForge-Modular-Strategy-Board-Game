package tuile;
import batiment.Batiment;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe abstraite Tuile représente une tuile générique sur le plateau de jeu.
 * Chaque tuile a un type, des coordonnées (x, y), une liste de tuiles adjacentes,
 * et un bâtiment.
 */
public abstract class Tuile {

    protected String type;
    protected Batiment batiment;
    protected List<Tuile> adjacents;
    protected int x;
    protected int y;

    /**
     * Constructeur de la classe Tuile.
     * Initialise une tuile avec un type, des coordonnées et une liste vide pour les tuiles adjacentes.
     * 
     * @param type le type de la tuile
     * @param x la coordonnée x de la tuile
     * @param y la coordonnée y de la tuile
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
    /**
     * Retourne la liste des tuiles adjacentes.
     * 
     * @return une liste de tuiles adjacentes
     */
    public List<Tuile> getAdjacents(){
    	return adjacents;
    }

    /**
     * Définit la liste des tuiles adjacentes.
     * 
     * @param adjacents la nouvelle liste des tuiles adjacentes
     */
    public void setAdjacents(List<Tuile> adjacents) {
    	this.adjacents = adjacents;
    }

    
    //cette méthode ert à forcer les sous-classes à définir comment chaque type de tuile produit une ressource spécifique
    //mais il faut definir une classe abstraite Ressource
    //public abstract Ressource produireRessource();


    /**
     * Supprime le bâtiment associé à cette tuile.
     */
    public void retirerBatiment() {
    	this.batiment = null;
    }

    public List<int[]> getPositionsAdjacentesMer(int i, int j) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPositionsAdjacentesMer'");
    }
}
