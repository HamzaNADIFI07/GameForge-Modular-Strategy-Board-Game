package tuile.type_tuile;

import ressource.enumRessource;
import tuile.Tuile;


public class Champ extends Tuile {
	private enumRessource ressource;

    /**
     * Constructeur de la classe Champ.
     */
	    public Champ(int x, int y) {
	        super("Champ", x, y);
<<<<<<< HEAD
	        this.ressource = enumRessource.Ble;
=======
	        this.ressource = new Ressource("Blé");
>>>>>>> 1e6c1609a51a822d683bd6d8c5d5d9b265b283fa
	    }

}