package tuile;
import batiment.Batiment;
import plateau.Plateau;
import plateau.Plateau.Position;
import tuile.type_tuile.Mer;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe abstraite Tuile représente une tuile générique sur le plateau de jeu.
 * Chaque tuile a un type, des coordonnées (x, y), une liste de tuiles adjacentes,
 * et un bâtiment.
 */
public abstract class Tuile {
    protected Batiment batiment;
    protected List<Tuile> adjacents;
    protected int x;
    protected int y;

    
        private String tuile;
    
        /**
         * Constructeur de la classe Tuile.
         * Initialise une tuile avec un type, des coordonnées et une liste vide pour les tuiles adjacentes.
         * 
         * @param type le type de la tuile
         * @param x la coordonnée x de la tuile
         * @param y la coordonnée y de la tuile
         */
        public Tuile(int x,int y) {
            this.x=x;
            this.y=y;
            this.adjacents = new ArrayList<>();
        }
        public String getType(){
            return this.tuile;
    }

    public Batiment getBatiment() {
        return this.batiment;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
    /**
     * Retourne la liste des positions adjacentes contenant des tuiles de type Mer.
     * @param plateau Le plateau contenant les tuiles.
     * @return Liste des positions des tuiles Mer adjacentes.
     */
    public List<int[]> getPositionsAdjacentesMer(Plateau plateau) {
        List<int[]> positionsMer = new ArrayList<>();
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} }; // Haut, Bas, Gauche, Droite

        for (int[] dir : directions) {
            int newX = this.x + dir[0];
            int newY = this.y + dir[1];

            if (plateau.isValidPosition(plateau.new Position(newX, newY)) && 
                    plateau.getTuile(newX, newY) instanceof Mer) {
                    positionsMer.add(new int[]{newX, newY});
                }
        }
        return positionsMer;
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
    /*
    public List<int[]> getPositionsAdjacentesMer(int i, int j) {
        throw new UnsupportedOperationException("Unimplemented method 'getPositionsAdjacentesMer'");
    }
        */

    
}
