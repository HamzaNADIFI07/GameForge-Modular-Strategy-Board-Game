package batiment.type_batiment;

import batiment.Batiment;
import ressource.enumRessource;
import tuile.Tuile;
import tuile.type_tuile.Mer;
import java.util.HashMap;
import java.util.Map;
public class Port extends Batiment{
    /**
     * Constructeur de la classe Port.
     */
    public Port(Tuile tuile) {
        super("Port", 1, tuile);
    }
    

    /**
     * Retourne le coût de construction du port.
     * @return Un Map contenant les ressources nécessaires.
     */
    @Override
    public Map<enumRessource, Integer> getCout() {
        Map<enumRessource, Integer> cout = new HashMap<>();
        cout.put(enumRessource.Bois, 1);
        cout.put(enumRessource.Moutons, 2);
        return cout;
    }

    /**
     * Vérifie si le bâtiment peut être construit.
     * Un port doit être adjacent à une tuile de type Mer.
     * @return true si la construction est possible, sinon false.
     */
    @Override
    public boolean peutEtreConstruit() {
        if (this.getTuile() == null) return false;

        for (Tuile tuile : this.getTuile().getAdjacents()) {
            if (tuile instanceof Mer) {
                return true; //  Le port peut être construit car une tuile voisine est de type Mer
            }
        }
        return false; // Si aucune tuile adjacente n'est une Mer, le port ne peut pas être construit
    }
}
