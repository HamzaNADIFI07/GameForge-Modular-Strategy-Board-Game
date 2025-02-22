package batiment.type_batiment;

import batiment.Batiment;
import java.util.HashMap;
import java.util.Map;
import ressource.Ressource;
import tuile.Tuile;

/**
 * La classe Ferme représente un type de bâtiment.
 */
public class Ferme extends Batiment{

    Map<Ressource, Integer> cout = new HashMap<>();
    /**
     * Constructeur de la classe Ferme.
     * @p@param tuile La tuile sur laquelle la ferme est construite.
     */
    public Ferme(Tuile tuile) {
        super("Ferme", 1, tuile);
        cout.put(Ressource.Bois, 1);  // Bois : 1
        cout.put(Ressource.Minerai, 1);  // Minerai : 1
    }
    
    /**
     * Retourne le coût de construction de la ferme.
     * @return Un Map contenant les ressources nécessaires.
     */
    public Map<Ressource, Integer> getCout() {
        return this.cout;
    }

    /**
     * Vérifie si le bâtiment peut être construit.
     */
    @Override
    public boolean peutEtreConstruit() {
        if (this.getTuile() != null || !(this.getTuile().getType().equals("Mer"))) {
            return false;
        }
        return true;
    }

}
