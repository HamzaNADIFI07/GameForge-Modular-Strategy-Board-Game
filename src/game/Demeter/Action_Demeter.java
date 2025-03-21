package game.Demeter;

import batiment.type_batiment.*;
import game.Game;
import ressource.Ressource;
import tuile.Tuile;

public class Action_Demeter {

    private Game game;

    public Action_Demeter(Game game) {
        this.game = game;
    }

    public void construireFerme(Tuile t) {

        if(this.game.getCurrentPlayer().possedeTuile(t) && this.game.getCurrentPlayer().hasResources(Ressource.Bois, 1) && this.game.getCurrentPlayer().hasResources(Ressource.Minerai, 1) && this.game.batimentPeutEtreConstruit( "Ferme",  t)){
            Ferme ferme = new Ferme(t);
            this.game.getCurrentPlayer().getBatimentsPossedes().add(ferme);
            this.game.getCurrentPlayer().useResources(Ressource.Bois, 1);
            this.game.getCurrentPlayer().useResources(Ressource.Minerai, 1);
            System.out.println(this.game.getCurrentPlayer().getName() + this.game.getCurrentPlayer().getRessources() + " a construit une ferme sur "+ t.display());
        }
    }

    public void construirePort(Tuile t){
        if(this.game.getCurrentPlayer().possedeTuile(t) && this.game.getCurrentPlayer().hasResources(Ressource.Bois, 1) && this.game.getCurrentPlayer().hasResources(Ressource.Moutons, 2) && this.game.batimentPeutEtreConstruit("Port",t)){
            Port port = new Port(t);
            this.game.getCurrentPlayer().getBatimentsPossedes().add(port);
            this.game.getCurrentPlayer().useResources(Ressource.Bois, 1);
            this.game.getCurrentPlayer().useResources(Ressource.Moutons, 2);
            System.out.println(this.game.getCurrentPlayer().getName() + this.game.getCurrentPlayer().getRessources() + " a construit un port sur "+ t.display());
        }
    }

}