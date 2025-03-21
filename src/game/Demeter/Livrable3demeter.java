package game.Demeter;

import game.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.PlateauSwing;



public class Livrable3demeter {
	/**
	 * Méthode principale du livrable 2.
	 * @param args Les arguments passés en ligne de commande.
	 */
	public static void main(String[] args) {
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
		Player player1 = new Player("Leon");
		List<Player> players = new ArrayList<>();
		players.add(player1);
		Demeter demeter = new Demeter(players, largeur, longeur);
		demeter.getAction().construireFerme(3,3);

		// Affichage dans une fenêtre Swing
        PlateauSwing.afficherPlateau(demeter.getPlateau());
		scanner.close();
		
	}
}
