
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class AffichageGraphique implements StrategieAffichage {
    @Override
    public void afficher(ElementDessin racine) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Affichage Graphique");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new DessinPanel(racine));
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static class DessinPanel extends JPanel {
        private final ElementDessin root;
        public DessinPanel(ElementDessin root) {
            this.root = root;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            dessinerElem(g, root, 20, 20, getWidth() - 40, getHeight() - 40);
        }

        private void dessinerElem(Graphics g, ElementDessin elem,
                                  int x, int y, int w, int h) {

            if (elem instanceof Cercle) {
                g.drawOval(x, y, w, h);
            } else if (elem instanceof Rectangle) {
                g.drawRect(x, y, w, h);
            } else if (elem instanceof Triangle) {
                int[] xs = { x + w/2, x, x + w };
                int[] ys = { y, y + h, y + h };
                g.drawPolygon(xs, ys, 3);
            } else if (elem instanceof DessinComposite) {
                g.drawRect(x, y, w, h);
                Iterator<ElementDessin> it = elem.creerIterateur();
                int n = 0;
                while (it.hasNext()) {
                    ElementDessin child = it.next();
                    int cols = 2;
                    int cw = w / cols, ch = h / cols;
                    int cx = x + (n % cols) * cw;
                    int cy = y + (n / cols) * ch;
                    dessinerElem(g, child, cx + 5, cy + 5, cw - 10, ch - 10);
                    n++;
                }
            }
        }
    }
}