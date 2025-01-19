package tuile.type_tuile;

import ressource.enumRessource;
import tuile.Tuile;

public class Paturage extends Tuile{
	private final enumRessource ressource;
    /**
     * Constructeur de la classe Paturage.
     */
    public Paturage(int x, int y) {
        super("Pâturage", x, y);
        this.ressource = enumRessource.Moutons;
    }

    public enumRessource produireRessource() {
        return ressource;
    }
    
}
