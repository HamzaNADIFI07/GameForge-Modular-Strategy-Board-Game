package batiment.type_batiment;
import batiment.Batiment;
import java.util.HashMap;
import java.util.Map;
import ressource.Ressource;
import tuile.Tuile;

/**
 * La classe Camp représente un type de bâtiment.
 */
public class Camp extends Batiment {

    Map<Ressource, Integer> cout = new HashMap<>();

    /**
     * Constructeur de la classe Camp.
     * 
     * @param tuile la tuile sur laquelle le camp est construit
     */
    
    public Camp(Tuile tuile) {
        super("Camp", 3, tuile);
        cout.put(Ressource.Bois, 2);
        cout.put(Ressource.Minerai, 3);  
    }
    //j'ai utilisé  HashMap car elle permet d’associer chaque type de ressource à sa quantité
    
    /**
     * Retourne le coût de construction du camp.
     * @return Un Map contenant les ressources nécessaires.
     */
    @Override
    public Map<Ressource, Integer> getCout() {
        return this.cout;
    }

    @Override
    public boolean peutEtreConstruit() {
        return (this.tuile != null) && !this.getTuile().getBatiment().getType().equals("Armee");
    }
}
