package listchooser;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class InteractiveListChooser {
	private Scanner scanner;
	private Random random;
	public InteractiveListChooser() {
		this.scanner = new Scanner(System.in);
		this.random = new Random();
	}
	/**
	 * Permet à l'utilisateur de choisir un élément dans une liste.
	 *- Si l'utilisateur entre un numéro valide, il choisit l'élément correspondant.
	 * - Si l'utilisateur n'entre rien ou une valeur invalide, un choix aléatoire est effectué.
	 * @param message Message affiché pour demander un choix
	 * @param options Liste des choix possibles
	 * @param <T> Type générique des objets dans la liste
	 * @return L'élément choisi
	 */
	 public <T> T choose(String message, List<T> options) {
		 if (options.isEmpty()) {
			 throw new IllegalArgumentException("La liste des choix est vide.");
		 }
		 System.out.println(message);
		 for (int i = 0; i < options.size(); i++) {
			 System.out.println(i + " - " + options.get(i));
		 }
		 System.out.print("Entrez le numéro du choix ou laissez vide pour un choix aléatoire : ");
		 String input = scanner.nextLine();
		 if (input.isEmpty()) {
			 return options.get(random.nextInt(options.size()));
	 }
		 try {
			 int choix = Integer.parseInt(input);
			 if (choix >= 0 && choix < options.size()) {
				 return options.get(choix);
			 }else {
				 System.out.println("Choix invalide, sélection aléatoire effectuée.");
				 return options.get(random.nextInt(options.size()));
		 }}catch (NumberFormatException e) {
				 System.out.println("Entrée invalide, sélection aléatoire effectuée.");
				 return options.get(random.nextInt(options.size()));
			 }
		 }
	 }	 
	 

