package Dice;

import javax.swing.SwingUtilities;

public class DiceMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DiceGui().setVisible(true);
            }
        });
    }
}
