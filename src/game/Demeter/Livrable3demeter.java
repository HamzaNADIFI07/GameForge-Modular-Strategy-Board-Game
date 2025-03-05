package game.Demeter;

import java.util.Scanner;

import game.Player;
import plateau.Plateau;

public class Livrable3demeter {

	public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);

	 int width, height;
	 do {
	 try {
	     System.out.print("Entrez la largeur du plateau (min 10): ");
	     width = Integer.parseInt(scanner.nextLine());
	     System.out.print("Entrez la hauteur du plateau (min 10): ");
	     height = Integer.parseInt(scanner.nextLine());

	if (width >= 10 && height >= 10) {
	      break;
	} else {
	 System.out.println("Les dimensions doivent être supérieures ou égales à 10.");
	   }
	  } catch (NumberFormatException e) {
	     System.out.println("Veuillez entrer des nombres valides.");
}
	 } while (true);

	        scanner.close(); 
	        Plateau plateau = new Plateau(width, height);
	        Player player = new Player("Leon");

	        System.out.println("Plateau initial:");
	        plateau.display();

	        
	    }

	}
