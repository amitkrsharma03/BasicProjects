package TicTacToe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class ticGui extends JFrame implements ActionListener {
  private int xScore, oScore, moveCounter;
  private boolean isPlayerOne;
  private JLabel turnLabel, scoreLabel, resultLabel;
  private JButton[][] board;
  private JDialog resultDialog;

  public ticGui() {
    super("Tic Tac Toe");
    setSize(CommonConstraints.FRAME_SIZE);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);
    setLayout(null);
    getContentPane().setBackground(CommonConstraints.Background_Color);
    createDialog();
    board = new JButton[3][3];
    isPlayerOne = true;
    addGuiComponents();
  }

  private void addGuiComponents() {
    JLabel barLabel = new JLabel();
    barLabel.setOpaque(true);
    barLabel.setBackground(CommonConstraints.Bar_Color);
    barLabel.setBounds(0, 0, CommonConstraints.FRAME_SIZE.width, 25);

    turnLabel = new JLabel(CommonConstraints.X_Label);
    turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
    turnLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
    turnLabel.setPreferredSize(new Dimension(100, turnLabel.getPreferredSize().height));
    turnLabel.setOpaque(true);
    turnLabel.setBackground(CommonConstraints.X_Color);
    turnLabel.setBackground(CommonConstraints.Board_Color);
    turnLabel.setBounds((CommonConstraints.FRAME_SIZE.width - turnLabel.getPreferredSize().width) / 2, 0,
        turnLabel.getPreferredSize().width, turnLabel.getPreferredSize().height);

    // score
    scoreLabel = new JLabel(CommonConstraints.Score_Label);
    scoreLabel.setFont(new Font("Dialog", Font.PLAIN, 40));
    scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
    scoreLabel.setForeground(CommonConstraints.Board_Color);
    scoreLabel.setBounds(0,
        turnLabel.getY() + turnLabel.getPreferredSize().height + 25,
        CommonConstraints.FRAME_SIZE.width,
        scoreLabel.getPreferredSize().height);

    // Grid
    GridLayout grid = new GridLayout(3, 3);
    JPanel boardPanel = new JPanel(grid);
    boardPanel.setBounds(0,
        scoreLabel.getY() + scoreLabel.getPreferredSize().height + 35,
        CommonConstraints.BOARD_SIZE.width,
        CommonConstraints.BOARD_SIZE.height);

    // Board 3*3
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        JButton button = new JButton();
        button.setFont(new Font("Dialog", Font.PLAIN, 180));
        button.setPreferredSize(CommonConstraints.Button_Size);
        button.setBackground(CommonConstraints.Background_Color);
        button.addActionListener(this);
        button.setBorder(BorderFactory.createLineBorder(CommonConstraints.Board_Color));

        board[i][j] = button;
        boardPanel.add(board[i][j]);
      }
    }
    // reset button
    JButton resetButton = new JButton("Reset");
    resetButton.setFont(new Font("Dialog", Font.PLAIN, 24));
    resetButton.addActionListener(this);
    resetButton.setBackground(CommonConstraints.Board_Color);
    int buttonWidth = 100; // Adjust width as needed
    int buttonHeight = 30; // Adjust height as needed
    resetButton.setBounds(
        (CommonConstraints.FRAME_SIZE.width - buttonWidth) / 2,
        CommonConstraints.FRAME_SIZE.height - 120,
        buttonWidth,
        buttonHeight
      );

    getContentPane().add(turnLabel);
    getContentPane().add(barLabel);
    getContentPane().add(scoreLabel);
    getContentPane().add(boardPanel);
    getContentPane().add(resetButton);
  }

  private void createDialog(){
    resultDialog =new JDialog();
    resultDialog.getContentPane().setBackground(CommonConstraints.Background_Color);
    resultDialog.setResizable(false);
    resultDialog.setTitle("Result");
    resultDialog.setSize(CommonConstraints.Result_Dialog_Size);
    resultDialog.setLocationRelativeTo(this);
    resultDialog.setModal(true);
    resultDialog.setLayout(new GridLayout(2,1));
    resultDialog.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        resetGame();
      }
    });

    resultLabel = new JLabel();
    resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
    resultLabel.setForeground(CommonConstraints.Board_Color);
    resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

    JButton restartButton = new JButton("Play Again");
    restartButton.setBackground(CommonConstraints.Board_Color);
    restartButton.addActionListener(this);

    resultDialog.add(resultLabel);
    resultDialog.add(restartButton);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    if (command.equals("Reset") || command.equals("Play Again")) {
      resetGame();
      if (command.equals("Reset")) {
        xScore = 0;
        oScore = 0;
      }
      if (command.equals("Play Again")) {
        resultDialog.setVisible(false);
      }
    } else {
      JButton button = (JButton) e.getSource();
      if (button.getText().equals("")) {
        moveCounter++;
        if (isPlayerOne) {
          button.setText(CommonConstraints.X_Label);
          button.setForeground(CommonConstraints.X_Color);

          isPlayerOne = false;
          turnLabel.setText(CommonConstraints.O_Label);
          turnLabel.setBackground(CommonConstraints.O_Color);
        } else {
          button.setText(CommonConstraints.O_Label);
          button.setForeground(CommonConstraints.O_Color);

          isPlayerOne = true;
          turnLabel.setText(CommonConstraints.X_Label);
          turnLabel.setBackground(CommonConstraints.X_Color);
        }
        if(isPlayerOne){
        checkOWin();
        }{
        checkXWin();
        }
        checkDraw();
        scoreLabel.setText("X: "+xScore+" | O: "+oScore);
      }
      repaint();
      revalidate();
    }
  }
  private void checkXWin(){
    for(int i=0; i<board.length; i++){
      if(board[i][0].getText().equals("X") && board[i][1].getText().equals("X") && board[i][2].getText().equals("X")){
        resultLabel.setText("X Wins");
        resultDialog.setVisible(true);
        xScore++;
      }
    }
    for(int i=0; i<board.length; i++){
      if(board[0][i].getText().equals("X") && board[1][i].getText().equals("X") && board[2][i].getText().equals("X")){
        resultLabel.setText("X Wins");
        resultDialog.setVisible(true);
        xScore++;
      }
    }
    if(board[0][0].getText().equals("X") && board[1][1].getText().equals("X") && board[2][2].getText().equals("X")){
      resultLabel.setText("X Wins");
      resultDialog.setVisible(true);
      xScore++;
    }
    if(board[0][2].getText().equals("X") && board[1][1].getText().equals("X") && board[2][0].getText().equals("X")){
      resultLabel.setText("X Wins");
      resultDialog.setVisible(true);
      xScore++;
    }
  }
  public void checkOWin(){
    for(int i=0; i<board.length; i++){
      if(board[i][0].getText().equals("O") && board[i][1].getText().equals("O") && board[i][2].getText().equals("O")){
        resultLabel.setText("O Wins");
        resultDialog.setVisible(true);
        oScore++;
      }
    }
    for(int i=0; i<board.length; i++){
      if(board[0][i].getText().equals("O") && board[1][i].getText().equals("O") && board[2][i].getText().equals("O")){
        resultLabel.setText("O Wins");
        resultDialog.setVisible(true);
        oScore++;
      }
    }
    if(board[0][0].getText().equals("O") && board[1][1].getText().equals("O") && board[2][2].getText().equals("O")){
      resultLabel.setText("O Wins");
      resultDialog.setVisible(true);
      oScore++;
    }
    if(board[0][2].getText().equals("O") && board[1][1].getText().equals("O") && board[2][0].getText().equals("O")){
      resultLabel.setText("O Wins");
      resultDialog.setVisible(true);
      oScore++;
    }
  }

  public void checkDraw(){
    if(moveCounter >= 9){
      resultLabel.setText("Draw");
      resultDialog.setVisible(true);
    }
  }

  private void resetGame() {
    isPlayerOne = true;
    turnLabel.setText(CommonConstraints.X_Label);
    turnLabel.setBackground(CommonConstraints.X_Color);

    scoreLabel.setText(CommonConstraints.Score_Label);
    moveCounter = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j].setText("");
      }
    }
  }
}
