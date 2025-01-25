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
     * 
     */
    // Pour l'instant dans cette  méthode, on va implémenter juste la contrainte du fait qu'une ferme ne peut pas être construite sur une tuile de type Mer.
    // Pour les containte des ressources, on l'implémentera directement dans les méthodes d'action construireFerme()
    @Override
    public boolean peutEtreConstruit() {
        if (this.getTuile().getType().equals("Mer")) {
            throw new IllegalArgumentException("Une ferme ne peut pas être construite sur une tuile de type Mer.");
        }
        return true;
    }

}
