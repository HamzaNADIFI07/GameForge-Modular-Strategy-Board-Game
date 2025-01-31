import plateau.Plateau;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int largeur, hauteur;
        System.out.println("Bienvenue ! Veuillez entrer les dimensions du plateau.");

        while (true) {
            try {
                System.out.print("Largeur: ");
                largeur = Integer.parseInt(scanner.nextLine());

                System.out.print("Hauteur: ");
                hauteur = Integer.parseInt(scanner.nextLine());

                if (largeur > 0 && hauteur > 0) {
                    break; // Sortie de la boucle si les valeurs sont valides
                } else {
                    System.out.println("Erreur: Les dimensions doivent être des entiers positifs.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur: Veuillez entrer des nombres valides.");
            }
        }

        // Création et affichage du plateau
        Plateau plateau = new Plateau(largeur, hauteur);
        plateau.genererTuiles(); // Assure-toi que cette méthode existe
        System.out.println("Plateau généré :");
        plateau.display(); // Assure-toi que la méthode display() affiche bien le plateau

        scanner.close();
    }
}

