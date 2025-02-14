package batiment.type_batiment;

import batiment.Batiment;
import java.util.HashMap;
import java.util.Map;
import ressource.enumRessource;
import tuile.Tuile;
public class Ferme extends Batiment{

    Map<enumRessource, Integer> cout = new HashMap<>();
    /**
     * Constructeur de la classe Ferme.
     */
    public Ferme(Tuile tuile) {
        super("Ferme", 1, tuile);
        cout.put(enumRessource.Bois, 1);  // Bois : 1
        cout.put(enumRessource.Minerai, 1);  // Minerai : 1
    }
    
    /**
     * Retourne le coût de construction de la ferme.
     * @return Un Map contenant les ressources nécessaires.
     */
    public Map<enumRessource, Integer> getCout() {
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
