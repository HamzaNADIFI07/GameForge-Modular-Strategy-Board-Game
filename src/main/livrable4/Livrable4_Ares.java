package main.livrable4;

import game.*;
import game.Ares.Ares;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Livrable4_Ares {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("You must enter 3 parameters");
            return;
        }
        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        int nbPlayers = Integer.parseInt(args[2]);

        if (width < 10 || height < 10) {
            System.out.println("La largeur et la hauteur du plateau doivent être d'au moins 10 cases.");
            return;
        }

        if (nbPlayers < 2) {
            System.out.println("Il faut au minimum 2 joueurs pour jouer.");
            return;
        }


        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();

        System.out.println("Veuillez entrer le nom des " + nbPlayers + " joueurs :");
        for (int i = 0; i < nbPlayers; i++) {
            System.out.print("Nom du joueur " + (i + 1) + " : ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                name = "Joueur" + (i + 1);
            }
            players.add(new Player(name));
        }

        Ares game = new Ares(players, width, height);

        System.out.println("    -----------------   ");
        System.out.println("--  Le jeu commence   --");
        System.out.println("    -----------------   ");

        while (!game.gameIsOver()) {
            
        }

        System.out.println("Game over! Winner: " + game.getWinner().getName());
 
    }
}
