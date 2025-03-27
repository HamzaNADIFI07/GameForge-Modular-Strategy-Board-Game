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

    

    private int nbGuerriers;

    /**
     * Constructeur de la classe Camp.
     * 
     * @param tuile la tuile sur laquelle le camp est construit
     */
    
    public Camp(Tuile tuile, int nombreGuerriers) {
        super("Camp", nombreGuerriers ,tuile);
        cout.put(Ressource.Bois, 2);
        cout.put(Ressource.Minerai, 3); 
        this.nbGuerriers = nombreGuerriers; 
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
    public int getNbGuerriers() {
        return nbGuerriers;
    }

    public void setNbGuerriers(int nbGuerriers) {
        this.nbGuerriers = nbGuerriers;
    }
}
