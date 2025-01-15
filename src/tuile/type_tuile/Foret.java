package tuile.type_tuile;

import ressource.Ressource;
import tuile.Tuile;

public class Foret extends Tuile{
    private Ressource ressource;
    /**
     * Constructeur de la classe Foret.
     */
	  public Foret(int x, int y) {
	      super("Forêt", x, y);
          this.ressource = new Ressource("Bois");
}
      public Ressource produireRessource() {
      return ressource;
}

}
