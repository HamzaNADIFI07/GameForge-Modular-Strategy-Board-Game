package tuile.type_tuile;

import ressource.enumRessource;
import tuile.Tuile;

public class Foret extends Tuile{
    private final enumRessource ressource;
    /**
     * Constructeur de la classe Foret.
     */
	  public Foret(int x, int y) {
	      super("Forêt", x, y);
          this.ressource = enumRessource.Bois;
}
      public enumRessource produireRessource() {
      return ressource;
}

}
