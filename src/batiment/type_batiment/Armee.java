package batiment.type_batiment;

import batiment.Batiment;
import java.util.HashMap;
import java.util.Map;
import ressource.enumRessource;
import tuile.Tuile;

public class Armee extends Batiment {

    Map<enumRessource, Integer> cout = new HashMap<>();
    

    /**
     * Constructeur de la classe Armee.
     * Vérifie que le nombre de guerriers est compris entre 1 et 5.
     * 
     * @param tuile la tuile sur laquelle l'armée est construite
     * @param nombreGuerriers le nombre de guerriers souhaité par le joueur
     */
    public Armee(Tuile tuile, int nombreGuerriers) {
        super("Armee", nombreGuerriers, tuile); // La dimension correspond au nombre de guerriers
        cout.put(enumRessource.Bois, 1);
        cout.put(enumRessource.Moutons, 1);
        cout.put(enumRessource.Ble, 1);
        if (nombreGuerriers < 1 || nombreGuerriers > 5) {
            throw new IllegalArgumentException("Le nombre de guerriers dans une armée doit être compris entre 1 et 5.");
        }

    }

    /**
     * Retourne le coût de construction de l'armée.
     * @return Un Map contenant les ressources nécessaires.
     */
    @Override
    public Map<enumRessource, Integer> getCout() {
        return this.cout;
    }

    /**
     * Vérifie si le bâtiment peut être construit.
     * 
     */
    // Pour l'instant dans cette  méthode, on va implémenter juste la contrainte du fait qu'une Armee ne peut pas être construite sur une tuile de type Mer.
    // Pour les containte des ressources, on l'implémentera directement dans les méthodes d'action construireArmee()
    @Override
    public boolean peutEtreConstruit() {
        if ((this.tuile != null) || !this.getTuile().getType().equals("Mer")) {
            return false;
        }
        return true;
    }

}
