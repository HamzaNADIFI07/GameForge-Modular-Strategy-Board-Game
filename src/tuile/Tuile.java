package tuile;
import batiment.Batiment;
import java.util.ArrayList;
import java.util.List;
import ressource.Ressource;

/**
 * La classe abstraite Tuile représente une tuile générique sur le plateau de jeu.
 * Chaque tuile a un type, des coordonnées (x, y), une liste de tuiles adjacentes,
 * et un bâtiment.
 */
public abstract class Tuile {

    protected String type; // le type de la tuile
    protected Batiment batiment; // le bâtiment construit sur la tuile
    protected List<Tuile> adjacents; // les tuiles adjacentes
    protected int x; // la coordonnée x de la tuile
    protected int y; // la coordonnée y de la tuile
    protected Ressource ressource; // la ressource produite par la tuile
    protected int quantite_ressource; // la quantité de ressource produite par la tuile

    /**
     * Constructeur de la classe Tuile.
     * Initialise une tuile avec un type, des coordonnées et une liste vide pour les tuiles adjacentes.
     * 
     * @param type le type de la tuile
     * @param x la coordonnée x de la tuile
     * @param y la coordonnée y de la tuile
     * @param ressource la ressource produite par la tuile
     */
    public Tuile(String type,int x,int y, Ressource ressource) {
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
     * @param plateau le plateau de jeu
     * @return une liste de tuiles adjacentes
     */
    public List<Tuile> getAdjacents(Tuile[][] plateau) {
        adjacents.clear();
    
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
        for (int[] d : directions) {
            int newX = x + d[0];
            int newY = y + d[1];
    
            if (newX >= 0 && newX < plateau.length && newY >= 0 && newY < plateau[0].length) {
                adjacents.add(plateau[newX][newY]);
            }
        }
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
     * @param quantite la nouvelle quantité de ressource
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
    /**
     * Produit une ressource spécifique à chaque type de tuile.
     */
    public abstract void produireRessource();

    /**
     * Définit le bâtiment construit dans cette tuile.
     * 
     * @param batiment le bâtiment construit dans la tuile
     */
    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }

    /**
     * Supprime le bâtiment associé à cette tuile.
     */
    public void retirerBatiment() {
    	this.batiment = null;
    }
    /**
     * Retourne la coordonnée x de la tuile.
     * 
     * @return la coordonnée x de la tuile
     */
    public int getX() {
        return this.x;
    }
    /**
     * Retourne la coordonnée y de la tuile.
     * 
     * @return la coordonnée y de la tuile
     */
    public int getY() {
        return this.y;
    }

    /**
     * Retourne le type de la tuile.
     * 
     * @return le type de la tuile
     */
    public Ressource getRessource() {
        return this.ressource;
    }

    public String display() {
        return this.type.charAt(0) + "( %d , %d )".formatted(this.x, this.y);
    }
}
