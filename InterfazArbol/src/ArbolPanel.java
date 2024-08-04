import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ArbolPanel extends JPanel {
    private Nodo raiz;
    private List<Integer> recorrido;
    private int pasoActual;
    private String tipoRecorrido;
    private static final int RADIO_NODO = 20;
    private static final int ESPACIADO_X = 50;
    private static final int ESPACIADO_Y = 60;

    public ArbolPanel(Nodo raiz) {
        this.raiz = raiz;
        this.recorrido = null;
        this.pasoActual = 0;
        this.tipoRecorrido = "";
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
        repaint();
    }

    public void setRecorrido(List<Integer> recorrido, String tipoRecorrido) {
        this.recorrido = recorrido;
        this.pasoActual = 0;
        this.tipoRecorrido = tipoRecorrido;
        repaint();
    }

    public void siguientePaso() {
        if (recorrido != null && pasoActual < recorrido.size()) {
            pasoActual++;
            repaint();
        }
    }

    public int getPasoActual() {
        return pasoActual;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (raiz != null) {
            drawTree(g, getWidth() / 2, ESPACIADO_Y, raiz, ESPACIADO_X);
        }
    }

    private void drawTree(Graphics g, int x, int y, Nodo raiz, int xOffset) {
        if (raiz != null) {
            // Determinar el color del nodo
            Color colorFondo = Color.WHITE;
            Color colorTexto = Color.BLACK;
            if (recorrido != null && recorrido.indexOf(raiz.valor) < pasoActual) {
                switch (tipoRecorrido) {
                    case "Preorden":
                        colorFondo = new Color(173, 216, 230); // Celeste claro
                        break;
                    case "Inorden":
                        colorFondo = new Color(186, 255, 223); // Verde claro
                        break;
                    case "Postorden":
                        colorFondo = new Color(223, 186, 255); // Azul claro
                        break;
                }
            }

            g.setColor(colorFondo);
            g.fillOval(x - RADIO_NODO, y - RADIO_NODO, 2 * RADIO_NODO, 2 * RADIO_NODO);
            g.setColor(Color.BLACK);
            g.drawOval(x - RADIO_NODO, y - RADIO_NODO, 2 * RADIO_NODO, 2 * RADIO_NODO);
            g.setColor(colorTexto);
            g.drawString(String.valueOf(raiz.valor), x - 10, y + 5);

            if (raiz.izquierdo != null) {
                g.setColor(Color.BLACK);
                g.drawLine(x, y + RADIO_NODO, x - xOffset + RADIO_NODO / 2, y + ESPACIADO_Y - RADIO_NODO);
                drawTree(g, x - xOffset, y + ESPACIADO_Y, raiz.izquierdo, xOffset / 2);
            }

            if (raiz.derecho != null) {
                g.setColor(Color.BLACK);
                g.drawLine(x, y + RADIO_NODO, x + xOffset - RADIO_NODO / 2, y + ESPACIADO_Y - RADIO_NODO);
                drawTree(g, x + xOffset, y + ESPACIADO_Y, raiz.derecho, xOffset / 2);
            }
        }
    }
}
