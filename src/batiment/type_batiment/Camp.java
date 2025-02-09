package batiment.type_batiment;
import batiment.Batiment;
import ressource.enumRessource;
import tuile.Tuile;
import java.util.HashMap;
import java.util.Map;

public class Camp extends Batiment {

    public Camp(Tuile tuile) {
        super("Camp", 3, tuile);  
    }
    @Override
    public Map<enumRessource, Integer> getCout() {
        Map<enumRessource, Integer> cout = new HashMap<>();
        cout.put(enumRessource.Bois, 2);
        cout.put(enumRessource.Minerai, 3);
        return cout;
    }

    @Override
    public boolean peutEtreConstruit() {
        return (this.tuile != null) && !this.tuile.getType().equals("Mer");
    }
}
