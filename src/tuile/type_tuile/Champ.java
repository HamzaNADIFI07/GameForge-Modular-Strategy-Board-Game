package tuile.type_tuile;

import ressource.enumRessource;
import tuile.Tuile;


public class Champ extends Tuile {
	private final enumRessource ressource;

    /**
     * Constructeur de la classe Champ.
     */
    public Champ(int x, int y) {
        super("Champ", x, y);
        this.ressource = enumRessource.Ble; // Utilisation correcte de l'énumération
    }

    public enumRessource getRessource() {
        return ressource;
    }

}