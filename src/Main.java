
import plateau.Plateau;

public class Main {
    public static void main(String[] args) {
        // Taille du plateau
        int x = 5;
        int y=1;

        // Création du plateau
        Plateau plateau = new Plateau(x,y);

        // Affichage du plateau
        System.out.println("Plateau généré :");
        plateau.display();
    }
}

/**
 * Pour l'instant la méthode initialiserPlateau() fait son travail comme il faut, elle parcourt le plateau (Tableau 2D) et creer une instance de Tuile dans chaque case.
 * Et la méthode display aussi affiche bien le plateau avec les tailles passées en paramètres.
 * Rendu Pour 10*10:
 * 
Plateau généré :
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
 *Rendu Pour 5*10:
Plateau généré :
M M M M M 
M M M M M 
M M M M M 
M M M M M 
M M M M M 
M M M M M 
M M M M M 
M M M M M 
M M M M M 
M M M M M 
 */
