
import java.util.Map;
import java.util.Scanner;

public class ApplicationDessin {
    public static void main(String[] args) {
        ElementDessin dessin3Niveaux = creerTopo3Niveaux();
        ElementDessin dessin2Niveaux = creerTopo2Niveaux();


        DessinComposite racineUnique = new DessinComposite("Racine");
        racineUnique.ajouter(new Cercle("CercleUnique"));
        ElementDessin dessin1Forme = racineUnique;

        Map<Integer, ElementDessin> map = Map.of(
                1, dessin3Niveaux,
                2, dessin2Niveaux,
                3, dessin1Forme
        );



        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le dessin à tester :\n"
                + "1- trois niveaux\n2- deux niveaux\n3- un niveau");
        int choixD = sc.nextInt();

        System.out.println("Entrez la stratégie :\n1- Indentation\n2- Chemin complet");
        int choixS = sc.nextInt();

        StrategieAffichage strat = (choixS == 1)
                ? new AffichageIndentation()
                : new AffichageCheminComplet();

        System.out.println("\nAffichage du dessin :");
        strat.afficher(map.get(choixD));
        sc.close();
    }

    private static ElementDessin creerTopo3Niveaux() {
        DessinComposite d1 = new DessinComposite("Dessin1");
        d1.ajouter(new Cercle("Cercle1"));

        DessinComposite d2 = new DessinComposite("Dessin2");
        DessinComposite d3 = new DessinComposite("Dessin3");
        d3.ajouter(new Cercle("Cercle2"));
        d3.ajouter(new Cercle("Cercle3"));

        DessinComposite d4 = new DessinComposite("Dessin4");
        d4.ajouter(new Triangle("Triangle1"));
        d4.ajouter(new Triangle("Triangle2"));

        d2.ajouter(d3);
        d2.ajouter(d4);
        d2.ajouter(new Rectangle("Rectangle1"));

        d1.ajouter(d2);
        return d1;
    }

    private static ElementDessin creerTopo2Niveaux() {
        DessinComposite d = new DessinComposite("DessinA");
        d.ajouter(new Cercle("Cercle1"));
        d.ajouter(new Triangle("Triangle1"));
        d.ajouter(new Rectangle("Rectangle1"));
        return d;
    }
}