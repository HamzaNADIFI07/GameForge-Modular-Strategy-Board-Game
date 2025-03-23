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

    public void construireFerme(int x, int y){ {
        Tuile t = game.getPlateau().getTuile(x, y);
        Player currentPlayer = game.getCurrentPlayer();

        if( currentPlayer.hasResources(Ressource.Bois, 1) && 
            currentPlayer.hasResources(Ressource.Minerai, 1) && 
            this.game.batimentPeutEtreConstruit( "Ferme",  t)){

            currentPlayer.useResources(Ressource.Bois, 1);
            currentPlayer.useResources(Ressource.Minerai, 1);
            Ferme ferme = new Ferme(t);
            currentPlayer.getBatimentsPossedes().add(ferme);
            currentPlayer.addTuile(t);
            System.out.println(currentPlayer.getName() + currentPlayer.getRessources() + " a construit une ferme sur "+ t.display());
        }else{
            System.out.println("Vous ne pouvez pas construire une ferme sur cette tuile");
        }
    }
}

    public void construirePort(int x, int y){
        Tuile t = game.getPlateau().getTuile(x, y);
        Player currentPlayer = game.getCurrentPlayer();

        if(currentPlayer.hasResources(Ressource.Bois, 1) && 
            currentPlayer.hasResources(Ressource.Moutons, 2) && 
            this.game.batimentPeutEtreConstruit("Port",t)){

            currentPlayer.useResources(Ressource.Bois, 1);
            currentPlayer.useResources(Ressource.Moutons, 2);
            Port port = new Port(t);
            currentPlayer.getBatimentsPossedes().add(port);
            currentPlayer.setPort(1);
            currentPlayer.addTuile(t);
            System.out.println(currentPlayer.getName() + currentPlayer.getRessources() + " a construit un port sur "+ t.display());
        }else{
            System.out.println("Vous ne pouvez pas construire un port sur cette tuile");
        }
    }
    public void construireExploitation(int x, int y){
        Tuile t = game.getPlateau().getTuile(x, y);
        Player currentPlayer = game.getCurrentPlayer();

        if(currentPlayer.hasResources(Ressource.Bois, 2) && 
            currentPlayer.hasResources(Ressource.Ble, 1) && 
            currentPlayer.hasResources(Ressource.Moutons, 1) &&
            this.game.batimentPeutEtreConstruit("Exploitation",t)){

            currentPlayer.useResources(Ressource.Bois, 2);
            currentPlayer.useResources(Ressource.Ble, 1);
            currentPlayer.useResources(Ressource.Moutons, 1);
            Exploitation exploitation = new Exploitation(t);
            currentPlayer.getBatimentsPossedes().add(exploitation);
            Batiment ferme = t.getBatiment();
            currentPlayer.getBatimentsPossedes().remove(ferme);
            System.out.println(currentPlayer.getName() + currentPlayer.getRessources() + " a construit une exploitation sur "+ t.display());
        }else{
            System.out.println("Vous ne pouvez pas construire une exploitation sur cette tuile");
        }
    }

    public void echangerRessources(int quantite , Ressource r1, Ressource r2, boolean port){
        Player currentPlayer = game.getCurrentPlayer();
        if(currentPlayer.getPort()>0 && port){
            currentPlayer.useResources(r1, 2*quantite);
            currentPlayer.addRessource(r2, quantite);
            System.out.println(currentPlayer.getName() + currentPlayer.getRessources() + " a échangé "+ 2*quantite + " " + r1 + " contre " + quantite + " " + r2);
        }
        if(currentPlayer.getPort()==0 || !port){
            currentPlayer.useResources(r1, 3*quantite);
            currentPlayer.addRessource(r2, quantite);
            System.out.println(currentPlayer.getName() + currentPlayer.getRessources() + " a échangé "+ 3*quantite + " " + r1 + " contre " + quantite + " " + r2);
        }
        else{
            System.out.println("Vous ne pouvez pas échanger de ressources");
        }
    }

    public void acheterVoleur(){
        Player currentPlayer = game.getCurrentPlayer(); // Faudra rajouter la condition de il en reste assez dans le jeu
        if(currentPlayer.hasResources(Ressource.Minerai, 1) && 
            currentPlayer.hasResources(Ressource.Bois, 1) && 
            currentPlayer.hasResources(Ressource.Ble, 1)){

            currentPlayer.useResources(Ressource.Minerai, 1);
            currentPlayer.useResources(Ressource.Bois, 1);
            currentPlayer.useResources(Ressource.Ble, 1);
            currentPlayer.setVoleur(1);
            currentPlayer.setHasSecretWeapon(true);
            System.out.println(currentPlayer.getName() + currentPlayer.getRessources() + " dispose maintenant d'une arme secrète.");
        }
        else{
            System.out.println("Vous ne pouvez pas acheter de voleur");
        }
    }

    public void jouerVoleur(Ressource ressource) {
        Player currentPlayer = game.getCurrentPlayer();

        if (currentPlayer.getVoleur()>0) {
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

            currentPlayer.setVoleur(-1);
        } else {
            System.out.println("Vous n'avez pas de voleur disponible !");
        }
    }



}