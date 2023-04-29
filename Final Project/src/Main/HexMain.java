/**
 * Import View package and Java Swing module
 */
package Main;
import View.HexView;
import javax.swing.*;

/**
 * Main interface to run the program and draw a HexWorld
 */
public class HexMain extends JPanel {

    /**
     * Produce a GUI containing the HexWorld
     * @param args String argument for the main to run
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        HexView hexView = new HexView();

        frame.setContentPane(hexView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}