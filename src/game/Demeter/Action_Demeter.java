package game.Demeter;

import batiment.Batiment;
import batiment.type_batiment.*;
import game.Game;
import game.Player;
import ressource.Ressource;
import tuile.Tuile;

public class Action_Demeter {

    private Game game;

    public Action_Demeter(Game game) {
        this.game = game;
    }

    public void construireFerme(Tuile t) {

        if(this.game.getCurrentPlayer().possedeTuile(t) && 
            this.game.getCurrentPlayer().hasResources(Ressource.Bois, 1) && 
            this.game.getCurrentPlayer().hasResources(Ressource.Minerai, 1) && 
            this.game.batimentPeutEtreConstruit( "Ferme",  t)){

            this.game.getCurrentPlayer().useResources(Ressource.Bois, 1);
            this.game.getCurrentPlayer().useResources(Ressource.Minerai, 1);
            Ferme ferme = new Ferme(t);
            this.game.getCurrentPlayer().getBatimentsPossedes().add(ferme);
            System.out.println(this.game.getCurrentPlayer().getName() + this.game.getCurrentPlayer().getRessources() + " a construit une ferme sur "+ t.display());
        }
    }

    public void construirePort(Tuile t){
        if(this.game.getCurrentPlayer().possedeTuile(t) && 
            this.game.getCurrentPlayer().hasResources(Ressource.Bois, 1) && 
            this.game.getCurrentPlayer().hasResources(Ressource.Moutons, 2) && 
            this.game.batimentPeutEtreConstruit("Port",t)){

            this.game.getCurrentPlayer().useResources(Ressource.Bois, 1);
            this.game.getCurrentPlayer().useResources(Ressource.Moutons, 2);
            Port port = new Port(t);
            this.game.getCurrentPlayer().getBatimentsPossedes().add(port);
            this.game.getCurrentPlayer().setHasPort();
            System.out.println(this.game.getCurrentPlayer().getName() + this.game.getCurrentPlayer().getRessources() + " a construit un port sur "+ t.display());
        }
    }
    public void construireExploitation(Tuile t){
        if(this.game.getCurrentPlayer().possedeTuile(t) && 
            this.game.getCurrentPlayer().hasResources(Ressource.Bois, 2) && 
            this.game.getCurrentPlayer().hasResources(Ressource.Ble, 1) && 
            this.game.getCurrentPlayer().hasResources(Ressource.Moutons, 1) &&
            this.game.batimentPeutEtreConstruit("Exploitation",t)){

            this.game.getCurrentPlayer().useResources(Ressource.Bois, 2);
            this.game.getCurrentPlayer().useResources(Ressource.Ble, 1);
            this.game.getCurrentPlayer().useResources(Ressource.Moutons, 1);
            Exploitation exploitation = new Exploitation(t);
            this.game.getCurrentPlayer().getBatimentsPossedes().add(exploitation);
            Batiment ferme = t.getBatiment();
            this.game.getCurrentPlayer().getBatimentsPossedes().remove(ferme);
            System.out.println(this.game.getCurrentPlayer().getName() + this.game.getCurrentPlayer().getRessources() + " a construit une exploitation sur "+ t.display());
        }
    }

    public void echangerRessources(Ressource r1, Ressource r2, int quantite){
        if(this.game.getCurrentPlayer().hasPort()){
            this.game.getCurrentPlayer().useResources(r1, 2*quantite);
            this.game.getCurrentPlayer().addRessource(r2, quantite);
            System.out.println(this.game.getCurrentPlayer().getName() + this.game.getCurrentPlayer().getRessources() + " a échangé "+ 2*quantite + " " + r1 + " contre " + quantite + " " + r2);
        }
        else{
            this.game.getCurrentPlayer().useResources(r1, 3*quantite);
            this.game.getCurrentPlayer().addRessource(r2, quantite);
            System.out.println(this.game.getCurrentPlayer().getName() + this.game.getCurrentPlayer().getRessources() + " a échangé "+ 3*quantite + " " + r1 + " contre " + quantite + " " + r2);
        }
    }

    public void jouerVoleur(Ressource ressource) {
        Player currentPlayer = game.getCurrentPlayer();

        if (currentPlayer.hasVoleur()) {
            game.getPlayers().forEach(player -> {
                if (!player.equals(currentPlayer)) {
                    int quantiteVolee = player.getRessources().getOrDefault(ressource, 0);
                    if (quantiteVolee > 0) {
                        player.useResources(ressource, quantiteVolee);
                        currentPlayer.addRessource(ressource, quantiteVolee);
                        System.out.println(currentPlayer.getName() + " a volé " + quantiteVolee + " " + ressource + " à " + player.getName());
                    } else {
                        System.out.println(player.getName() + " n'avait aucune ressource (" + ressource + ") à voler.");
                    }
                }
            });

            currentPlayer.setHasVoleur();
        } else {
            System.out.println("Vous n'avez pas de voleur disponible !");
        }
    }



}