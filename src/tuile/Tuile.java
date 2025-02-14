package tuile;
import batiment.Batiment;
import java.util.ArrayList;
import java.util.List;
import ressource.enumRessource;

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
    protected enumRessource ressource;
    protected int quantite_ressource;

    /**
     * Constructeur de la classe Tuile.
     * Initialise une tuile avec un type, des coordonnées et une liste vide pour les tuiles adjacentes.
     * 
     * @param type le type de la tuile
     * @param x la coordonnée x de la tuile
     * @param y la coordonnée y de la tuile
     */
    public Tuile(String type,int x,int y, enumRessource ressource) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.adjacents = new ArrayList<>();
        this.quantite_ressource = 0;
        this.ressource=ressource;
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
     * Retourne la quantité de ressource.
     * 
     * @return quantité de ressource
     */
    public int getQuantiteRessource(){
        return this.quantite_ressource;
    }
    /**
     * Permet d'incrémenter la quantité de ressource
     * 
     */
    public void incrementerRessource(){
        this.quantite_ressource++;
    }
    /**
     * Définit la quantité de ressource.
     * 
     * @param adjacents la nouvelle quantité de ressource
     */
    public void setQuantiteRessource(int quantite){
        this.quantite_ressource=quantite;
    }

    /**
     * Définit la liste des tuiles adjacentes.
     * 
     * @param adjacents la nouvelle liste des tuiles adjacentes
     */
    public void setAdjacents(List<Tuile> adjacents) {
    	this.adjacents = adjacents;
    }

    /**
     * Retourne le batiment construit dans cette tuile.
     * 
     * @return batiment construit dans la tuile
     */
    public Batiment getBatiment(){
        return this.batiment;
    }
    
    //cette méthode ert à forcer les sous-classes à définir comment chaque type de tuile produit une ressource spécifique
    //mais il faut definir une classe abstraite Ressource
    public abstract void produireRessource();


    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }

    /**
     * Supprime le bâtiment associé à cette tuile.
     */
    public void retirerBatiment() {
    	this.batiment = null;
    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * Retourne le type de la tuile.
     * 
     * @return le type de la tuile
     */
    public enumRessource getRessource() {
        return this.ressource;
    }

}
