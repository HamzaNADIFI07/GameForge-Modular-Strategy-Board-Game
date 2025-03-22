package game.Demeter;

import game.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.PlateauSwing;



public class Livrable3demeter {
	/**
	 * Méthode principale du livrable 3 du jeu Demeter.
	 * @param args Les arguments passés en ligne de commande.
	 */
	public static void main(String[] args) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		Scanner scanner = new Scanner(System.in);

        int largeur, longeur;
        while (true) {
            try {
                System.out.print("Entrez la largeur du plateau: ");
                largeur = Integer.parseInt(scanner.nextLine());

                System.out.print("Entrez la hauteur du plateau: ");
                longeur = Integer.parseInt(scanner.nextLine());

                if (largeur >= 10 && longeur >= 10) {
                    break;
                } else {
                    System.out.println("Les dimensions doivent être supérieures ou égale à 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer des nombres valides.");
            }
		}
		System.out.println(" -----------------");
		System.out.println("----- DEMETER -----");
		System.out.println(" -----------------");

		Player player1 = new Player("Leon");
		List<Player> players = new ArrayList<>();
		players.add(player1);

		Demeter demeter = new Demeter(players, largeur, longeur);

		demeter.setCurrentPlayer(player1);

		System.out.println("----> " + player1.getName() + " [ " + player1.getRessources() + " ] veut construire une ferme.");
		
		System.out.println("Où installer une ferme ?");
		
		System.out.print("Entrez la coordonnée X: ");
		int coordonneeX = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Entrez la la coordonnée Y: ");
		int coordonneeY = Integer.parseInt(scanner.nextLine());
		
		demeter.getAction().construireFerme(coordonneeX,coordonneeY);

		System.out.println("----> " + player1.getName() + " [ " + player1.getRessources() + " ] veut remplacer une ferme par une exploitation.");

		List<String> fermes = player1.getBatimentsParType("Ferme");
		System.out.println("quelle ferme transformer en exploitation ?");
		System.out.println(fermes);

		System.out.print("Quelle ferme transformer en exploitation ? ");
		int indiceFerme = Integer.parseInt(scanner.nextLine());

		//demeter.getAction().construireExploitation(, coordonneeY);

		// Affichage dans une fenêtre Swing
        PlateauSwing.afficherPlateau(demeter.getPlateau());
		scanner.close();
	
	}
}
