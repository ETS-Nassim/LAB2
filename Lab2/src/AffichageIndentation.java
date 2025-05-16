
import java.util.Iterator;

public class AffichageIndentation implements StrategieAffichage {
    @Override
    public void afficher(ElementDessin racine) {
        afficherRec(racine, 0);
    }

    private void afficherRec(ElementDessin elem, int prof) {
        System.out.println("    ".repeat(prof) + elem.getNom());
        Iterator<ElementDessin> it = elem.creerIterateur();
        while (it.hasNext()) {
            afficherRec(it.next(), prof + 1);
        }
    }
}
