package main.livrable4;

import batiment.type_batiment.Armee;
import game.*;
import game.Ares.Ares;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ressource.Ressource;
import tuile.Tuile;



public class Livrable4_Ares {
    public static void main(String[] args) {
        System.out.println("Bienvenue dans le jeu Ares !");
        System.out.println("Veuillez entrer les dimensions du plateau (largeur, hauteur) et le nombre de joueurs :");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Largeur : ");
        int width = Integer.parseInt(scanner.nextLine());
        System.out.print("Hauteur : ");
        int height = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre de joueurs : ");
        int nbPlayers = Integer.parseInt(scanner.nextLine());

        if (width < 10 || height < 10) {
            System.out.println("La largeur et la hauteur du plateau doivent être d'au moins 10 cases.");
            return;
        }

        if (nbPlayers < 2) {
            System.out.println("Il faut au minimum 2 joueurs pour jouer.");
            return;
        }


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
                    System.out.println("action choisie: échange des ressources");
                    player.afficherRessources();

                    System.out.println("choisit une ressource Ã  Ã©changer");
                    System.out.println("[0 - none, 1 - Ore, 2 - Sheep, 3 - Wheat, 4 - Wood]");
                    int choix2 = Integer.parseInt(scanner.nextLine());

                    System.out.println("ressource Ã  acquÃ©rir");
                    System.out.println("[0 - none, 1 - Ore, 2 - Sheep, 3 - Wheat, 4 - Wood]");
                    int choix3 = Integer.parseInt(scanner.nextLine());

                    Ressource ressourceADonner = null;
                    if (choix2 == 1) {
                        ressourceADonner = Ressource.Ble;
                    } else if (choix2 == 2) {
                        ressourceADonner = Ressource.Moutons;
                    } else if (choix2 == 3) {
                        ressourceADonner = Ressource.Minerai;
                    } else if (choix2 == 4) {
                        ressourceADonner = Ressource.Bois;
                    }

                    if (choix3==1) {
                        game.getAction().echangerRessources(3, ressourceADonner , Ressource.Ble);
                    }else if (choix3==2) {
                        game.getAction().echangerRessources(3, ressourceADonner, Ressource.Moutons);
                    }else if (choix3==3) {
                        game.getAction().echangerRessources(3, ressourceADonner, Ressource.Minerai);
                    }else if (choix3==4) {
                        game.getAction().echangerRessources(3, ressourceADonner, Ressource.Bois);
                    }
                    player.afficherRessources();
                }
                else if (choix==3) {
                    System.out.println("action choisie: déploie une armée");
                    System.out.println("choisit une tuile");
                    game.getPlateau().afficherTuilesDisponibles();
                    int choix1 = Integer.parseInt(scanner.nextLine());
                    Tuile t = player.getTuilesPossedes().get(choix1);
                    System.out.println("choisit le nombre de guerriers");
                    int choix2 = Integer.parseInt(scanner.nextLine());
                    game.getAction().construireArmee(t, choix2);

                }
                else if (choix==4) {
                    System.out.println("action choisie: updrage vers un camp");
                    System.out.println("quelle armÃ©e transformer en camp ?");
                    player.getDisplayBatimentsParType("Armee");
                    int choix1 = Integer.parseInt(scanner.nextLine());
                    Armee a = (Armee) player.getBatimentsPossedes().get(choix1);
                    game.getAction().remplacerArmeeCamp(a.getTuile());
                }
                else if (choix==5) {
                    System.out.println("action choisie: construit un port");
                    System.out.println("choisit une tuile");
                    game.getPlateau().afficherTuilesDisponibles();
                    int choix1 = Integer.parseInt(scanner.nextLine());
                    Tuile t = player.getTuilesPossedes().get(choix1);
                    game.getAction().construirePort(t);
                }
                else if (choix==6) {
                    System.out.println("action choisie: deployer des guerriers");
                    System.out.println("choisit une tuile");
                    List<String> bat = new ArrayList<>();
                    bat.addAll(player.getDisplayBatimentsParType("Armee"));
                    bat.addAll(player.getDisplayBatimentsParType("Camp"));
                    System.out.println(bat);
                    int choix1 = Integer.parseInt(scanner.nextLine());
                    Tuile t = player.getTuilesPossedes().get(choix1);
                    game.getAction().positionnerGuerriers(t, 1);
                }
                else if (choix==7) {
                    System.out.println("action choisie: achete 5 guerriers");
                    game.getAction().ajouterGuerriersAuStock();
                }
                else if (choix==8) {
                    System.out.println("action choisie: achete une arme secrete");
                    game.getAction().acheterArmeSecrete();
                }
                else if (choix==9) {
                    System.out.println("action choisie: attaque");
                    System.out.println("choisit le batiment que tu souhaite utiliser");
                    List<String> bat = new ArrayList<>();
                    bat.addAll(player.getDisplayBatimentsParType("Armee"));
                    bat.addAll(player.getDisplayBatimentsParType("Camp"));
                    System.out.println(bat);
                    int choix1 = Integer.parseInt(scanner.nextLine());
                    Tuile t = player.getTuilesPossedes().get(choix1);
                    System.out.println("choisit le joueur que tu souhaite attaquer");
                    System.out.println(players);
                    int choix2 = Integer.parseInt(scanner.nextLine());
                    Player p = players.get(choix2);
                    System.out.println("choisit le batiment que tu souhaite attaquer");
                    p.getDisplayBatiments();
                    int choix3 = Integer.parseInt(scanner.nextLine());
                    Tuile t2 = p.getBatimentsPossedes().get(choix3).getTuile();
                    game.getAction().attaquer( t, p , t2 );


                }

			}
        }

        System.out.println("Game over! Winner: " + game.getWinner().getName());
 
    }

}
