package tuile.type_tuile;

import ressource.enumRessource;
import tuile.Tuile;

public class Montagne extends Tuile {
	private final enumRessource ressource;

    public Montagne(int x, int y) {
        super("Montagne", x, y);
        this.ressource = enumRessource.Minerai;
    }

    public enumRessource produireRessource() {
        return ressource;
    }
}