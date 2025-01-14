package IdGenerator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class IdGui extends JFrame{

    //private IdBackend idGenerator;
    public IdGui(){
        super("Identity Generator");
        setSize(540,570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //PasswordGenerator = new RPGbackend();
        addGuiComponents();
    }
    private void addGuiComponents(){
        JLabel title = new JLabel("Identity Generator");
        title.setFont(new Font("Dialog", Font.BOLD, 32));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(0, 10, 540, 39);
        add(title);
        JTextArea idOp = new JTextArea();
        idOp.setEditable(false);
        idOp.setFont(new Font("Dialog", Font.BOLD, 32));

        JScrollPane idOpP=new JScrollPane(idOp);
        idOpP.setBounds(25, 97, 479, 70);
        idOpP.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(idOpP);

        //First Name
        JLabel Fname=new JLabel("First Name:") ;
        Fname.setFont(new Font("Dialog", Font.BOLD, 28));
        Fname.setBounds(25, 215, 272, 39);
        add(Fname);

        JTextArea FnameInput=new JTextArea();
        FnameInput.setFont(new Font("Dialog", Font.BOLD, 32));
        FnameInput.setBounds(310, 215, 192, 39);
        add(FnameInput);

        //Last Name
        JLabel Lname=new JLabel("Last Name:") ;
        Lname.setFont(new Font("Dialog", Font.BOLD, 28));
        Lname.setBounds(25, 265, 272, 39);
        add(Lname);

        JTextArea LnameInput=new JTextArea();
        LnameInput.setFont(new Font("Dialog", Font.BOLD, 32));
        LnameInput.setBounds(310, 265, 192, 39);
        add(LnameInput);

        //PinCode
        JLabel PinCode=new JLabel("PinCode:") ;
        PinCode.setFont(new Font("Dialog", Font.BOLD, 28));
        PinCode.setBounds(25, 315, 272, 39);
        add(PinCode);

        JTextArea PinCodeInput=new JTextArea();
        PinCodeInput.setFont(new Font("Dialog", Font.BOLD, 32));
        PinCodeInput.setBounds(310, 315, 192, 39);
        add(PinCodeInput);

        //Nth Reverse
        JLabel Nth=new JLabel("N digit Reverse:") ;
        Nth.setFont(new Font("Dialog", Font.BOLD, 28));
        Nth.setBounds(25, 365, 272, 39);
        add(Nth);

        JTextArea NthInput=new JTextArea();
        NthInput.setFont(new Font("Dialog", Font.BOLD, 32));
        NthInput.setBounds(310, 365, 192, 39);
        add(NthInput);

        //Generate Button
        JButton genrButton=new JButton("Generate");
        genrButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        genrButton.setBounds(155, 477, 222, 41);
        genrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String fName=FnameInput.getText();
                String lName=LnameInput.getText();
                String pinCode=PinCodeInput.getText();
                int n=Integer.parseInt(NthInput.getText());
                String result=IdBackend.generateUserID(fName, lName, pinCode, n);
                idOp.setText(result);
            }
        }); 
        add(genrButton);                       
    }
}
