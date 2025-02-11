package batiment.type_batiment;

import batiment.Batiment;
import tuile.Tuile;

public class Ferme extends Batiment{

    /**
     * Constructeur de la classe Ferme.
     */
    public Ferme(Tuile tuile) {
        super("Ferme", 1, tuile);
    }
    /**
     * Vérifie si le bâtiment peut être construit.
     */
    @Override
    public boolean peutEtreConstruit() {
        if (this.getTuile() != null && this.getTuile().getType().equals("Mer")) {
            throw new IllegalArgumentException("Une ferme ne peut pas être construite sur une tuile de type Mer.");
        }
        return true;
    }

}
