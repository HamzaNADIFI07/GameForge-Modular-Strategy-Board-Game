package batiment.type_batiment;

import batiment.Batiment;
import java.util.HashMap;
import java.util.Map;
import ressource.Ressource;
import tuile.Tuile;
import tuile.type_tuile.Mer;

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

    /**
     * Vérifie si le bâtiment peut être construit.
     * Un port doit être adjacent à une tuile de type Mer.
     * @return true si la construction est possible, sinon false.
     */
    public boolean peutEtreConstruit(Tuile[][] plateau) {
        if (this.getTuile() == null) return false;

        for (Tuile tuile : this.getTuile().getAdjacents(plateau)) {
            if (tuile instanceof Mer) {
                return true; //  Le port peut être construit car une tuile voisine est de type Mer
            }
        }
        return false; // Si aucune tuile adjacente n'est une Mer, le port ne peut pas être construit
    }
}
