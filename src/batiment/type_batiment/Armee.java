package batiment.type_batiment;

import batiment.Batiment;
import tuile.Tuile;

public class Armee extends Batiment {
    
    private int nombreGuerriers;
    

    /**
     * Constructeur de la classe Armee.
     * Vérifie que le nombre de guerriers est compris entre 1 et 5.
     * 
     * @param tuile la tuile sur laquelle l'armée est construite
     * @param nombreGuerriers le nombre de guerriers souhaité par le joueur
     */
    public Armee(Tuile tuile, int nombreGuerriers) {
        super("Armee", nombreGuerriers, tuile); // La dimension correspond au nombre de guerriers

        if (nombreGuerriers < 1 || nombreGuerriers > 5) {
            throw new IllegalArgumentException("Le nombre de guerriers dans une armée doit être compris entre 1 et 5.");
        }

        this.nombreGuerriers = nombreGuerriers;
    }
    /**
     * Retourne le nombre de guerriers de l'armée.
     * @return le nombre de guerriers de l'armée
     */
    public int getNombreGuerriers() {
        return nombreGuerriers;
    }


    /**
     * Vérifie si le bâtiment peut être construit.
     * 
     */
    // Pour l'instant dans cette  méthode, on va implémenter juste la contrainte du fait qu'une Armee ne peut pas être construite sur une tuile de type Mer.
    // Pour les containte des ressources, on l'implémentera directement dans les méthodes d'action construireArmee()
    @Override
    public boolean peutEtreConstruit() {
        if (this.getTuile().getType().equals("Mer")) {
            throw new IllegalArgumentException("Une Armee ne peut pas être construite sur une tuile de type Mer.");
        }
        return true;
    }

}
