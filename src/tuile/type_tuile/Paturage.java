package tuile.type_tuile;

import tuile.Tuile;

public class Paturage extends Tuile{
	private Ressource ressource;
    /**
     * Constructeur de la classe Paturage.
     */
    public Paturage(int x, int y) {
        super("Pâturage", x, y);
        this.ressource = new Ressource("Mouton", 1);
    }

    public Ressource produireRessource() {
        return ressource;
    }
    
}
