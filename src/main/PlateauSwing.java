package main;

import java.awt.*;
import javax.swing.*;
import plateau.Plateau;
import tuile.Tuile;

public class PlateauSwing extends JFrame {
    private static final int TILE_SIZE = 60; // Taille d'une tuile
    private Plateau plateau;

    public PlateauSwing(Plateau plateau) {
        this.plateau = plateau;

        setTitle("Plateau de Jeu");
        setSize(plateau.getX() * TILE_SIZE, plateau.getY() * TILE_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(plateau.getY(), plateau.getX()));

        // Remplir l'interface avec les tuiles et afficher le bâtiment s'il existe
        for (int i = 0; i < plateau.getY(); i++) {
            for (int j = 0; j < plateau.getX(); j++) {
                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.setLayout(new BorderLayout());

                // Récupérer la tuile et son bâtiment
                Tuile tuile = plateau.getTuile(j, i);

                // Définition des couleurs selon le type de tuile
                String type = tuile.getType();
                Color tuileColor;
                switch (type) {
                    case "Mer":
                        tuileColor = new Color(51, 153, 255);
                        break;
                    case "Foret":
                        tuileColor = new Color(0, 102, 51);
                        break;
                    case "Champ":
                        tuileColor = new Color(222, 194, 53);
                        break;
                    case "Montagne":
                        tuileColor = new Color(102, 51, 0);
                        break;
                    case "Paturage":
                        tuileColor = new Color(102, 255, 178);
                        break;
                    default:
                        tuileColor = Color.LIGHT_GRAY;
                        break;
                }
                
                panel.setBackground(tuileColor);
                String text = "" ;
                if (tuile.getBatiment()!=null) {
                    text = String.valueOf(tuile.getBatiment().getType().charAt(0));
                }

                // Ajouter un label avec la première lettre du bâtiment 
                JLabel label = new JLabel(text, SwingConstants.CENTER);
                label.setFont(new Font("Arial", Font.BOLD, 16));
                label.setForeground(Color.BLACK);
                panel.add(label, BorderLayout.CENTER);

                add(panel);
            }
        }
    }

    public static void afficherPlateau(Plateau plateau) {
        SwingUtilities.invokeLater(() -> {
            new PlateauSwing(plateau).setVisible(true);
        });
    }
}
