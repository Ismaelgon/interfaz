import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ArbolBinarioInterfaz extends JFrame {
    private JTextField valorTextField;
    private JButton agregarButton;
    private JTextArea resultadoTextArea;
    private JButton preordenButton;
    private JButton inordenButton;
    private JButton postordenButton;
    private ArbolBinarioBusqueda arbol;
    private ArbolPanel arbolPanel;

    public ArbolBinarioInterfaz() {
        arbol = new ArbolBinarioBusqueda();
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Árbol Binario de Búsqueda");

        valorTextField = new JTextField(10);
        agregarButton = new JButton("Agregar");
        resultadoTextArea = new JTextArea(5, 20);
        preordenButton = new JButton("Preorden");
        inordenButton = new JButton("Inorden");
        postordenButton = new JButton("Postorden");

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Valor:"));
        controlPanel.add(valorTextField);
        controlPanel.add(agregarButton);
        controlPanel.add(preordenButton);
        controlPanel.add(inordenButton);
        controlPanel.add(postordenButton);
        controlPanel.add(new JScrollPane(resultadoTextArea));

        arbolPanel = new ArbolPanel(null);
        arbolPanel.setPreferredSize(new Dimension(800, 600));

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(arbolPanel, BorderLayout.CENTER);

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int valor = Integer.parseInt(valorTextField.getText());
                arbol.agregar(valor);
                arbolPanel.setRaiz(arbol.raiz);
                arbolPanel.setRecorrido(null, "");  // Resetea el recorrido actual
                arbolPanel.repaint();
                valorTextField.setText("");
            }
        });

        preordenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animarRecorrido(arbol.preorden(), "Preorden");
            }
        });

        inordenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animarRecorrido(arbol.inorden(), "Inorden");
            }
        });

        postordenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animarRecorrido(arbol.postorden(), "Postorden");
            }
        });

        pack();
    }

    private void animarRecorrido(List<Integer> recorrido, String tipoRecorrido) {
        resultadoTextArea.setText(tipoRecorrido + ": " + recorrido.toString());
        arbolPanel.setRecorrido(recorrido, tipoRecorrido);
        Timer timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                arbolPanel.siguientePaso();
                if (arbolPanel.getPasoActual() >= recorrido.size()) {
                    ((Timer) evt.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArbolBinarioInterfaz().setVisible(true);
            }
        });
    }
}
