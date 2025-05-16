import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DessinComposite implements ElementDessin {
    private String nom;
    private List<ElementDessin> enfants = new ArrayList<>();

    public DessinComposite(String nom) {
        this.nom = nom;
    }

    public void ajouter(ElementDessin e) {
        enfants.add(e);
    }

    public void enlever(ElementDessin e) {
        enfants.remove(e);
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public Iterator<ElementDessin> creerIterateur() {
        return enfants.iterator();
    }
}
