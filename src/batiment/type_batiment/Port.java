package batiment.type_batiment;

import batiment.Batiment;
import tuile.Tuile;
import tuile.type_tuile.Mer;

public class Port extends Batiment{
    /**
     * Constructeur de la classe Port.
     */
    public Port(Tuile tuile) {
        super("Port", 1, tuile);
    }

    /**
     * Vérifie si le bâtiment peut être construit.
     * 
     */
    // Pour l'instant dans cette  méthode, on va implémenter juste la contrainte du fait qu'un port ne peut être construit que sur une tuile voisine à une tuile de type Mer.
    // Pour les containte des ressources, on l'implémentera directement dans les méthodes d'action construirePort()
    @Override
    public boolean peutEtreConstruit() {
        for (Tuile tuile : this.getTuile().getAdjacents()) {
            if (tuile instanceof Mer) {
                return true;
            }
        }
        return false;
    }
}
