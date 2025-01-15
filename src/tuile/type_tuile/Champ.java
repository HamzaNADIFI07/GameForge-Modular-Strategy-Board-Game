package tuile.type_tuile;

import ressource.Ressource;
import tuile.Tuile;

public class Champ extends Tuile {
	private Ressource ressource;

    /**
     * Constructeur de la classe Champ.
     */
	    public Champ(int x, int y) {
	        super("Champ", x, y);
	        this.ressource = new Ressource("Blé");
	    }

	    public Ressource produireRessource() {
	        return ressource;
	    }
}