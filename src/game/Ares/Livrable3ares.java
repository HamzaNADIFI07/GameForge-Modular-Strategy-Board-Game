package game.Ares;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import batiment.type_batiment.Armee;
import game.Player;
import plateau.Plateau;
import tuile.Tuile;
import game.Ares.Ares;

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
        List<Player> players = new ArrayList<>();
        players.add(player);
        
        Ares ares = new Ares(players, width, height) {
        	private final Action_Ares action = new Action_Ares(this, player);
        	public Action_Ares getAction() {
        		return action;
        	}
        	@Override
        	public void initializeGame() {
        		
        	}
        };
        ares.setCurrentPlayer(player);
        Action_Ares action = ares.getAction();
        System.out.println("\n-----------------");
        System.out.println("-----   ARES  -----");
        System.out.println("-----------------\n");
        
     // Étape 1 : construire une armée avec 1 guerrier
        Tuile tuileArmee = ares.trouverTuileConstruisible("Armee");
        System.out.println("----> " + player.getName() + ": " + player.getRessources() + " (" + player.getWarriorsStock() + " warriors) veut construire une armée");
        action.construireArmee(tuileArmee);

    }
}

