package game.Demeter;

import game.Game;
import ressource.Ressource;
import tuile.Tuile;

public class Action_Demeter {

    private Game game;

    public Action_Demeter(Game game) {
        this.game = game;
    }

    public void construireFerme(Tuile t) {

        if(this.game.getCurrentPlayer().hasResources(Ressource.Bois, 1) && this.game.getCurrentPlayer().hasResources(Ressource.Minerai, 1)){
            return;
        }
    }

}