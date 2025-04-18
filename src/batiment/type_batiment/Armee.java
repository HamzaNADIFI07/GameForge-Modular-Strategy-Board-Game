package batiment.type_batiment;

import batiment.Batiment;
import java.util.HashMap;
import java.util.Map;
import ressource.Ressource;
import tuile.Tuile;

/**
 * La classe Armee représente un type de bâtiment.
 */
public class Armee extends Batiment {
	private int nbGuerriers;

    Map<Ressource, Integer> cout = new HashMap<>();
    

    /**
     * Constructeur de la classe Armee.
     * Vérifie que le nombre de guerriers est compris entre 1 et 5.
     * 
     * @param tuile la tuile sur laquelle l'armée est construite
     * @param nombreGuerriers le nombre de guerriers souhaité par le joueur
     */
    public Armee(Tuile tuile, int nombreGuerriers) {
        super("Armee", nombreGuerriers, tuile); // La dimension correspond au nombre de guerriers
        cout.put(Ressource.Bois, 1);
        cout.put(Ressource.Moutons, 1);
        cout.put(Ressource.Ble, 1);
        this.nbGuerriers = nombreGuerriers;
        if (nombreGuerriers < 1 || nombreGuerriers > 5) {
            throw new IllegalArgumentException("Le nombre de guerriers dans une armée doit être compris entre 1 et 5.");
        }

    }

    /**
     * Retourne le coût de construction de l'armée.
     * @return Un Map contenant les ressources nécessaires.
     */
    @Override
    public Map<Ressource, Integer> getCout() {
        return this.cout;
    }
    public int getNbGuerriers() {
        return this.nbGuerriers;
    }
    public void addGuerriers(int n) {
        if (nbGuerriers + n > 5) {
            throw new IllegalArgumentException("Une armée ne peut pas dépasser 5 guerriers.");
        }
        this.nbGuerriers += n;
    }




}
