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
    // Pour l'instant la méthode n'est pas encore complételemt implémentée en attendant la modélisation des actions 
    // pour vérifier si le joueur dispose des ressources nécessaires pour construire une ferme.
    public boolean peutEtreConstruit() {
        if (this.getType().equals("Mer")) {
            throw new IllegalArgumentException("Une ferme ne peut pas être construite sur une tuile de type Mer.");
            
        }
        return true;
    }

}
