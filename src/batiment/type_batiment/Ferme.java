package batiment.type_batiment;

import batiment.Batiment;

public class Ferme extends Batiment{

    /**
     * Constructeur de la classe Ferme.
     */
    public Ferme() {
        super("Ferme", 1);
    }
    /**
     * Vérifie si le bâtiment peut être construit.
     * 
     *  @param tuileType le type de la tuile
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
