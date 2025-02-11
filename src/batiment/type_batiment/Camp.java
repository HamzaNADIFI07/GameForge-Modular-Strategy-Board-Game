package batiment.type_batiment;
import batiment.Batiment;
import java.util.HashMap;
import java.util.Map;
import ressource.enumRessource;
import tuile.Tuile;

public class Camp extends Batiment {

    public Camp(Tuile tuile) {
        super("Camp", 3, tuile);  
    }
    //j'ai utilisé  HashMap car elle permet d’associer chaque type de ressource à sa quantité
    
    @Override
    public Map<enumRessource, Integer> getCout() {
        Map<enumRessource, Integer> cout = new HashMap<>();
        cout.put(enumRessource.Bois, 2);
        cout.put(enumRessource.Minerai, 3);
        return cout;
    }

    @Override
    public boolean peutEtreConstruit() {
        return (this.tuile != null) && !this.getTuile().getBatiment().getType().equals("Armee");
    }
}
