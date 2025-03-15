package TicTacToe;

import javax.swing.SwingUtilities;

public class App {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        ticGui gui = new ticGui();
        gui.setVisible(true);
      }
    });
  }
}
