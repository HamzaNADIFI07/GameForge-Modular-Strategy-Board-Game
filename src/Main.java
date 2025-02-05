import plateau.Plateau;

public class Main {
    public static void main(String[] args) {
        // Vérification des arguments
        if (args.length < 2) {
            System.out.println("Usage: java Main <largeur> <hauteur>");
            return;
        }

        try {
            // Récupération des dimensions du plateau depuis les arguments
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);

            // Vérification des contraintes de taille minimale
            if (x < 10 || y < 10) {
                System.out.println("La largeur (x) et la hauteur (y) doivent être au moins égales à 10.");
                return;
            }

            // Création du plateau
            Plateau plateau = new Plateau(x, y);
            // Génération des tuiles dans le plateau
            plateau.genererTuiles();
            // Affichage du plateau
            System.out.println("Plateau généré :");
            plateau.display();
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer des nombres entiers valides pour la largeur et la hauteur.");
        }
    }
}
