package main;

import game.*;
import game.Ares.Action_Ares;
import listchooser.InteractiveListChooser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Action;



public class Livrable4 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("You must enter 3 parameters");
            return;
        }
        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        int nbPlayers = Integer.parseInt(args[2]);

        List<Player> players = new ArrayList<>();
        
        for (int i = 0; i < nbPlayers; i++) {
            players.add(new Player("Player " + (i + 1)));
        }
        Game game = new Game(players, width, height);

        System.out.println("    -----------------   ");
        System.out.println("--  Le jeu commence   --");
        System.out.println("    -----------------   ");

        while (!game.isOver()) {
            game.playTurn();
        }

        System.out.println("Game over! Winner: " + game.getWinner());
 
    }
}
