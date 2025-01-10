
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