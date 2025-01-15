package tuile.type_tuile;

import ressource.Ressource;
import tuile.Tuile;

public class Montagne extends Tuile {
	private Ressource ressource;

    public Montagne(int x, int y) {
        super("Montagne", x, y);
        this.ressource = new Ressource("Minerai");
    }

    public Ressource produireRessource() {
        return ressource;
    }
}