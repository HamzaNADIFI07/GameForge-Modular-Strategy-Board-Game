package game.Ares;

import java.util.Scanner;

import batiment.type_batiment.Armee;
import game.Player;
import plateau.Plateau;
import tuile.Tuile;

public class Livrable3ares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width, height;
        while (true) {
            try {
                System.out.print("Entrez la largeur du plateau (minimum 10): ");
                width = Integer.parseInt(scanner.nextLine());
                System.out.print("Entrez la hauteur du plateau (minimum 10): ");
                height = Integer.parseInt(scanner.nextLine());

                if (width >= 10 && height >= 10) {
                    break;  
                } else {
                    System.out.println("Les dimensions doivent être supérieures ou égales à 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer des nombres valides.");
            }
        }

        scanner.close();  
        Plateau plateau = new Plateau(width, height);
        Player player = new Player("Leon");

        System.out.println("Plateau généré pour Ares:");
        plateau.display();
     // Sélectionner une tuile valide pour l'armée
        Tuile tuileArmee = null;
        for (Tuile[] row : plateau.getTuiles()) {
        	for (Tuile t : row) {
        		 if (t.getBatiment() == null && !t.getType().equals("Mer")) {
        			 tuileArmee = t;
        			 break;
        		 }
        	}
        	if (tuileArmee != null) break;
        }
        if (tuileArmee != null) {
        	Armee armee = new Armee(tuileArmee, 1);
        	player.construireBatiment(armee, tuileArmee);
        	player.afficherRessources();
        }

    }
}

