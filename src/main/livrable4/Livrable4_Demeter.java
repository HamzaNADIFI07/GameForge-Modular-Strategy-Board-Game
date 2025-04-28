package main.livrable4;

import game.Demeter.Demeter;
import game.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ressource.Ressource;

public class Livrable4_Demeter {
    
    public static void main(String[] args) {
        System.out.println("Bienvenue dans le jeu Demeter !");
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

        Demeter game = new Demeter(players, width, height);

        System.out.println("    -----------------   ");
        System.out.println("--  Le jeu commence   --");
        System.out.println("    -----------------   ");

        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                game.setCurrentPlayer(player);
				System.out.println("### " + player.getName() + " JOUE ###");
                
                System.out.println("Où voulez-vous construire votre ferme ?");
                System.out.println("X : ");
                int x = Integer.parseInt(scanner.nextLine());
                System.out.println("Y : ");
                int y = Integer.parseInt(scanner.nextLine());
                game.getAction().construireFermegratuitement(x, y);
            }
        }

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
                System.out.println("[0 - none, 1 - ne fait rien, 2 - Ã©change desressources, 3 - construit une ferme, 4 - updrage vers une exploitation, 5 - construit un port, 6 - achete une arme secrete, 7 - joue le voleur]");
                int choix = Integer.parseInt(scanner.nextLine());
                if (choix==1) {
                    System.out.println("ne fait rien ");
                }else if (choix==2) {
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
                        game.getAction().echangerRessources(3, ressourceADonner , Ressource.Ble, true);
                    }else if (choix3==2) {
                        game.getAction().echangerRessources(3, ressourceADonner, Ressource.Moutons, true);
                    }else if (choix3==3) {
                        game.getAction().echangerRessources(3, ressourceADonner, Ressource.Minerai, true);
                    }else if (choix3==4) {
                        game.getAction().echangerRessources(3, ressourceADonner, Ressource.Bois, true);
                    }
                    player.afficherRessources();
                }else if (choix==3) {
                    System.out.println("action choisie : construit une ferme");
                    System.out.println("Où voulez-vous construire votre ferme ?");
                    System.out.println("X : ");
                    int x = Integer.parseInt(scanner.nextLine());
                    System.out.println("Y : ");
                    int y = Integer.parseInt(scanner.nextLine());
                    game.getAction().construireFerme(x, y);
                }else if (choix==4) {
                    System.out.println("action choisie : updrage vers une exploitation");
                    System.out.println("Où voulez-vous construire votre exploitation ?");
                    System.out.println("X : ");
                    int x = Integer.parseInt(scanner.nextLine());
                    System.out.println("Y : ");
                    int y = Integer.parseInt(scanner.nextLine());
                    game.getAction().construireExploitation(x, y);
                }else if (choix==5) {
                    System.out.println("action choisie : construit un port");
                    System.out.println("Où voulez-vous construire votre port ?");
                    System.out.println("X : ");
                    int x = Integer.parseInt(scanner.nextLine());
                    System.out.println("Y : ");
                    int y = Integer.parseInt(scanner.nextLine());
                    game.getAction().construirePort(x, y);
                }else if (choix==6) {
                    System.out.println("action choisie : achete une arme secrete");
                    game.getAction().acheterVoleur();
                }else if (choix==7) {
                    System.out.println("action choisie : joue le voleur");
                    System.out.println("ressource Ã  voler");
                    System.out.println("[0 - none, 1 - Ore, 2 - Sheep, 3 - Wheat, 4 - Wood]");
                    int choix1 = Integer.parseInt(scanner.nextLine());
                    if (choix1 == 1) {
                        game.getAction().jouerVoleur(Ressource.Ble);
                    } else if (choix1 == 2) {
                        game.getAction().jouerVoleur(Ressource.Moutons);
                    } else if (choix1 == 3) {
                        game.getAction().jouerVoleur(Ressource.Minerai);
                    } else if (choix1 == 4) {
                        game.getAction().jouerVoleur(Ressource.Bois);
                    }
                }
            }
        }
    }
}
