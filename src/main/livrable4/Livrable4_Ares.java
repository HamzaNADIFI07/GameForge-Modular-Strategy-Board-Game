package main.livrable4;

import game.*;
import game.Ares.Ares;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ressource.Ressource;



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
        int i=1;
        while (!game.gameIsOver()) {
            for (int j =0 ; j<game.getPlateau().getX(); j++){
				for (int k =0 ; k<game.getPlateau().getY(); k++){
					game.getPlateau().getTuile(j,k).produireRessource();
				}
			}
            game.getPlateau().display();

            System.out.println();
			System.out.println();

            System.out.println("## Tour " + i + " ##");
			i++;

            for (Player player : players) {
				game.setCurrentPlayer(player);
				System.out.println("### " + player.getName() + " JOUE ###");
				System.out.println("Choisissez une action");
				System.out.println("[0 - none, 1 - ne fait rien, 2 - échange des ressources, 3 - déploie une armée, 4 - updrage vers un camp, 5 - construit un port, 6 - deployer des guerriers, 7 - achete 5 guerriers, 8 - achete une arme secrete, 9 - attaque]");
				int choix = Integer.parseInt(scanner.nextLine());
                if (choix==1) {
                    System.out.println("ne fait rien ");
                }
                else if(choix==2){
                    System.out.println("échange des ressources");
                    player.afficherRessources();

                    System.out.println("choisit une ressource Ã  Ã©changer");
                    player.afficherRessources();
                    int choix2 = Integer.parseInt(scanner.nextLine());

                    System.out.println("ressource Ã  acquÃ©rir");
                    System.out.println("[0 - none, 1 - Ore, 2 - Sheep, 3 - Wheat, 4 - Wood]");
                    int choix3 = Integer.parseInt(scanner.nextLine());
                    if (choix3==1) {
                        game.getAction().echangerRessources(3, player.getRessources().get(choix), Ressource.Ble);
                    }else if (choix3==2) {
                        game.getAction().echangerRessources(3, player.getRessources().get(choix), Ressource.Minerai);
                    }else if (choix3==3) {
                        game.getAction().echangerRessources(3, player.getRessources().get(choix), Ressource.Moutons);
                    }else if (choix3==4) {
                        game.getAction().echangerRessources(3, player.getRessources().get(choix), Ressource.Bois);
                    }
                    
                }
                else if (choix==3) {
                    System.out.println("déploie une armée");
                }
                else if (choix==4) {
                    System.out.println("updrage vers un camp");
                }
                else if (choix==5) {
                    System.out.println("construit un port");
                }
                else if (choix==6) {
                    System.out.println("deployer des guerriers");
                }
                else if (choix==7) {
                    System.out.println("achete 5 guerriers");
                }
                else if (choix==8) {
                    System.out.println("achete une arme secrete");
                }
                else if (choix==9) {
                    System.out.println("attaque");
                }

			}
        }

        System.out.println("Game over! Winner: " + game.getWinner().getName());
 
    }
}
