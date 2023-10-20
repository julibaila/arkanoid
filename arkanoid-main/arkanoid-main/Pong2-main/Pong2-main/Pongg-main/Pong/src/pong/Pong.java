package pong;

import clases.Ventana;
import javax.swing.SwingUtilities;

public class Pong {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ventana ventana = new Ventana();
        });
    }
}
