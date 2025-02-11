package batiment.type_batiment;

import batiment.Batiment;
import ressource.enumRessource;
import tuile.Tuile;

import java.util.HashMap;
import java.util.Map;
public class Ferme extends Batiment{

    /**
     * Constructeur de la classe Ferme.
     */
    public Ferme(Tuile tuile) {
        super("Ferme", 1, tuile);
    }
    
    public Map<enumRessource, Integer> getCout() {
        Map<enumRessource, Integer> cout = new HashMap<>();
        cout.put(enumRessource.Bois, 1);  // Bois : 1
        cout.put(enumRessource.Minerai, 1);  // Minerai : 1
        return cout;
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
