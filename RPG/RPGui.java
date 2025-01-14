package RPG;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RPGui extends JFrame{

    private RPGbackend PasswordGenerator;
    public RPGui(){
        super("Password Generator");
        setSize(540,570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        PasswordGenerator = new RPGbackend();
        addGuiComponents();
    }
    private void addGuiComponents(){
        JLabel title = new JLabel("Password Generator");
        title.setFont(new Font("Dialog", Font.BOLD, 32));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(0, 10, 540, 39);
        add(title);
        JTextArea passwordOp = new JTextArea();
        passwordOp.setEditable(false);
        passwordOp.setFont(new Font("Dialog", Font.BOLD, 32));

        JScrollPane passwordOpP=new JScrollPane(passwordOp);
        passwordOpP.setBounds(25, 97, 479, 70);
        passwordOpP.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOpP);

        JLabel passLength=new JLabel("Password Length:") ;
        passLength.setFont(new Font("Dialog", Font.BOLD, 28));
        passLength.setBounds(25, 215, 272, 39);
        add(passLength);

        JTextArea passInput=new JTextArea();
        passInput.setFont(new Font("Dialog", Font.BOLD, 32));
        passInput.setBounds(310, 215, 192, 39);
        add(passInput);

        JToggleButton upToggle=new JToggleButton("Uppercase");
        upToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        upToggle.setBounds(25,302,225,56);
        add(upToggle);

        JToggleButton lowToggle=new JToggleButton("Lowercase");
        lowToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        lowToggle.setBounds(282,302,225,56);
        add(lowToggle);

        JToggleButton NumToggle=new JToggleButton("Numbers");
        NumToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        NumToggle.setBounds(25,373,225,56);
        add(NumToggle);

        JToggleButton SymToggle=new JToggleButton("Symbols");
        SymToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        SymToggle.setBounds(282,373,225,56);
        add(SymToggle);

        JButton genrButton=new JButton("Generate");
        genrButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        genrButton.setBounds(155, 477, 222, 41);
        genrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(passLength.getText().length()<=0) return;
                boolean TogSelect=lowToggle.isSelected()||upToggle.isSelected()||NumToggle.isSelected()||SymToggle.isSelected();
                if(TogSelect){
                    String genrPass=PasswordGenerator.generatePass(Integer.parseInt(passInput.getText()),upToggle.isSelected(),lowToggle.isSelected(),NumToggle.isSelected(),SymToggle.isSelected());
                    passwordOp.setText(genrPass);
                }
            }
        });
        add(genrButton);
    }
    
}
