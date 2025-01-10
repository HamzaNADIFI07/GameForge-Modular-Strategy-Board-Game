
import plateau.Plateau;

public class Main {
    public static void main(String[] args) {
        // Taille du plateau
        int x = 20;
        int y=10;

        // Création du plateau
        Plateau plateau = new Plateau(x,y);
        // Géneration des Tuiles dans le plateau
        plateau.genererTuiles();
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
 *
 * 
 * Après implémentation de la méthode genererTuiles(), l'affichage devient comme suit:
 * Il va falloir maintenant implémenter la deuxième contrainte de tout les tuiles non Mer doivent avoir en moins une tuile adjacente qui n’est
 * pas de type mer
 * Premier rendu Pour 10*10:
Plateau généré :
M M C F M M M M C M 
M C M M P M M M M M 
C M M M F P M M M M 
M M M M F M P M M M 
M M M F M M M M M M 
M M P M M M M M M M 
M F M F M M M M C P 
M M M M M M C P M M 
F M M P C M M C M M 
M F M M M C M M M M 
 *
 * Deuxième rendu pour 10*10 qui montre que la géneration des coordonnées et types de tuile non Mer se fait aléatoirement:
 * 
Plateau généré :
P M M M C M M M M C 
M P M P M M F M M F 
C P M M M C C M M M 
M M M M M M M M M C 
P M M M M M M M M M 
M M M M M M M M M C 
M C M M C M M M M M 
M M M M F F M M M P 
M C M M M M M M M M 
P M F M M P P M M M 

 * Après modification du display le rendu devient comme suit:

Plateau généré :
      0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18    19  
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 0 |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  P  |  M  |  P  |  M  |  M  |  M  |  M  |  M  |  M  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 1 |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  C  |  C  |  M  |  M  |  M  |  P  |  M  |  M  |  P  |  M  |  M  |  M  |  C  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 2 |  C  |  M  |  M  |  M  |  M  |  P  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  P  |  F  |  M  |  M  |  M  |  M  |  M  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 3 |  M  |  P  |  M  |  M  |  M  |  M  |  M  |  P  |  M  |  C  |  M  |  M  |  C  |  C  |  P  |  M  |  M  |  M  |  M  |  M  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 4 |  M  |  M  |  M  |  M  |  C  |  M  |  P  |  P  |  P  |  M  |  C  |  M  |  M  |  M  |  M  |  C  |  M  |  M  |  M  |  M  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 5 |  M  |  M  |  M  |  F  |  M  |  C  |  M  |  M  |  M  |  M  |  M  |  M  |  C  |  C  |  M  |  M  |  M  |  M  |  P  |  M  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 6 |  M  |  M  |  P  |  M  |  M  |  M  |  F  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  C  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 7 |  M  |  M  |  M  |  M  |  M  |  P  |  M  |  M  |  F  |  P  |  C  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 8 |  P  |  M  |  M  |  C  |  F  |  M  |  M  |  M  |  M  |  F  |  M  |  M  |  M  |  M  |  M  |  C  |  M  |  P  |  M  |  F  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 9 |  M  |  P  |  M  |  P  |  C  |  M  |  F  |  F  |  M  |  M  |  M  |  C  |  M  |  M  |  M  |  M  |  M  |  C  |  M  |  M  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 */
