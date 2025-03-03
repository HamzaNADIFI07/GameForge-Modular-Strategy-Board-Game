package main;
import java.util.Scanner;
import plateau.Plateau;

/**
 * Classe principale du programme.
 */
public class Main {
    /**
     * Méthode principale du programme.
     * @param args Les arguments passés en ligne de commande.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x, y;
        while (true) {
            try {
                System.out.print("Entrez la largeur du plateau: ");
                x = Integer.parseInt(scanner.nextLine());

                System.out.print("Entrez la hauteur du plateau: ");
                y = Integer.parseInt(scanner.nextLine());

                if (x > 0 && y > 0) {
                    break;
                } else {
                    System.out.println("Les dimensions doivent être des entiers positifs.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer des nombres valides.");
            }
        }

        // Création et affichage du plateau
        Plateau plateau = new Plateau(x, y);
        plateau.genererTuiles();
        System.out.println("Plateau généré :");
        plateau.display();

        scanner.close();
    }
}

