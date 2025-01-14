package Dice;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DiceGui extends JFrame{
    public DiceGui(){
        super("Rolling Double Dice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700,700));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        addGuiComponents();
    }
    private void addGuiComponents(){
        JPanel jp=new JPanel();
        jp.setLayout(null);

        JLabel bnrimg=ImgSer.loadImage("Resource/Banner.png");
        bnrimg.setBounds(15,25,650,100);
        jp.add(bnrimg);

        //Dices
        JLabel dice1=ImgSer.loadImage("Resource/dice1.png");
        dice1.setBounds(100,200,200,200);
        jp.add(dice1);

        JLabel dice2=ImgSer.loadImage("Resource/dice1.png");
        dice2.setBounds(390,200,200,200);
        jp.add(dice2);

        //Roll Button
        Random r=new Random();
        JButton rButton=new JButton("Roll!");
        rButton.setBounds(250,550,200,50);
        rButton.setFont(new Font("Dialog",Font.BOLD,28));
        rButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rButton.setEnabled(false);
                long start=System.currentTimeMillis();
                Thread rollThread =new Thread(new Runnable() {
                    @Override
                    public void run(){
                        long end=System.currentTimeMillis();
                        try{
                            while((end-start)/1000F<3){
                                int dice1Value=r.nextInt(1,7);
                                int dice2Value=r.nextInt(1,7);

                                ImgSer.Update(dice1,"Resource/dice"+dice1Value+".png");
                                ImgSer.Update(dice2,"Resource/dice"+dice2Value+".png");

                                repaint();
                                revalidate();

                                Thread.sleep(100);
                                end=System.currentTimeMillis();
                            }

                            rButton.setEnabled(true);
                        }
                        catch(InterruptedException e){
                            System.out.println("Threading Error"+e);
                        }
                    }
                });
                rollThread.start();
            }
        });
        jp.add(rButton);

        this.getContentPane().add(jp);
    }
}
