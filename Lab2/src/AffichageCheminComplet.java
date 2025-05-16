
import java.util.Iterator;

public class AffichageCheminComplet implements StrategieAffichage {
    @Override
    public void afficher(ElementDessin racine) {
        afficherRec(racine, racine.getNom());
    }

    private void afficherRec(ElementDessin elem, String chemin) {
        System.out.println(chemin);
        Iterator<ElementDessin> it = elem.creerIterateur();
        while (it.hasNext()) {
            ElementDessin e = it.next();
            afficherRec(e, chemin + "." + e.getNom());
        }
    }
}
