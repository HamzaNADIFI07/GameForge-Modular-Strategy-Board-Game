package tuile.type_tuile;

import tuile.Tuile;

public class Montagne extends Tuile {
	private Ressource ressource;

    public Montagne(int x, int y) {
        super("Montagne", x, y);
        this.ressource = new Ressource("Minerai", 1);
    }

    public Ressource produireRessource() {
        return ressource;
    }
}