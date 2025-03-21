package batiment.type_batiment;

import batiment.Batiment;
import java.util.HashMap;
import java.util.Map;
import ressource.Ressource;
import tuile.Tuile;

/**
 * La classe Port représente un type de bâtiment.
 */
public class Port extends Batiment{
    Map<Ressource, Integer> cout = new HashMap<>();
    /**
     * Constructeur de la classe Port.
     * @param tuile La tuile sur laquelle le port est construit.
     */
    public Port(Tuile tuile) {
        super("Port", 1, tuile);
        cout.put(Ressource.Bois, 1);
        cout.put(Ressource.Moutons, 2);

    }
    

    /**
     * Retourne le coût de construction du port.
     * @return Un Map contenant les ressources nécessaires.
     */
    @Override
    public Map<Ressource, Integer> getCout() {
        return this.cout;
    }


}
