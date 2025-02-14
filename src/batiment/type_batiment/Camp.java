package batiment.type_batiment;
import batiment.Batiment;
import java.util.HashMap;
import java.util.Map;
import ressource.enumRessource;
import tuile.Tuile;

public class Camp extends Batiment {

    Map<enumRessource, Integer> cout = new HashMap<>();

    public Camp(Tuile tuile) {
        super("Camp", 3, tuile);
        cout.put(enumRessource.Bois, 2);
        cout.put(enumRessource.Minerai, 3);  
    }
    //j'ai utilisé  HashMap car elle permet d’associer chaque type de ressource à sa quantité
    
    /**
     * Retourne le coût de construction du camp.
     * @return Un Map contenant les ressources nécessaires.
     */
    @Override
    public Map<enumRessource, Integer> getCout() {
        return this.cout;
    }

    @Override
    public boolean peutEtreConstruit() {
        return (this.tuile != null) && !this.getTuile().getBatiment().getType().equals("Armee");
    }
}
