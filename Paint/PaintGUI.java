package Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintGUI extends JFrame {
    public PaintGUI(){
        super("Paint GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(950, 700));
        pack();
        setLocationRelativeTo(null);

        addGUI();
    }
    private void addGUI(){
        JPanel canvasPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        canvasPanel.setLayout(layout);

        Canvas canvas =new Canvas(940,650);
        canvasPanel.add(canvas);
        layout.putConstraint(SpringLayout.NORTH, canvas, 50, SpringLayout.NORTH, canvasPanel);

        JButton chooseButton=new JButton("Choose Color");
        chooseButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Color color = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
                chooseButton.setBackground(color);
                canvas.setColor(color);
            }});
        canvasPanel.add(chooseButton);
        layout.putConstraint(SpringLayout.NORTH, chooseButton, 10, SpringLayout.NORTH, canvasPanel);
        layout.putConstraint(SpringLayout.WEST, chooseButton, 25, SpringLayout.WEST, canvasPanel);
        
        JButton resetButton=new JButton("Reset");
        resetButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                canvas.clearCanvas();
            }});
        canvasPanel.add(resetButton);
        layout.putConstraint(SpringLayout.NORTH, resetButton, 10, SpringLayout.NORTH, canvasPanel);
        layout.putConstraint(SpringLayout.WEST, resetButton, 150, SpringLayout.WEST, canvasPanel);
        this.getContentPane().add(canvasPanel);


    }

}
