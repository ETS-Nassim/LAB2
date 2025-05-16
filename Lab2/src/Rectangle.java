
import java.util.Collections;
import java.util.Iterator;

public class Rectangle implements ElementDessin {
    private String nom;

    public Rectangle(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public Iterator<ElementDessin> creerIterateur() {
        return Collections.emptyIterator();
    }
}
