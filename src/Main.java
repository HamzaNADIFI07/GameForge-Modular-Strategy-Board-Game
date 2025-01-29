
import plateau.Plateau;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Plateau <largeur> <hauteur>");
            return;
        }

        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
        // Création du plateau
        Plateau plateau = new Plateau(x,y);
        // Géneration des Tuiles dans le plateau
        plateau.genererTuiles();
        // Affichage du plateau
        System.out.println("Plateau généré :");
        plateau.display();
        } catch (NumberFormatException e) {
            System.out.println("Les arguments doivent être des nombres entiers.");
        }
    }
}