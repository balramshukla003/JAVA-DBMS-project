import java.awt.*;
import java.awt.event.*;

public class Registration extends Frame implements ActionListener,WindowListener {
    Button b1,b2;
    Registration(){

        setTitle("Registration Window");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setBackground(new Color(0xD1D383));
        setResizable(false);
        addWindowListener(this);


        Label clg = new Label("Meena Shah Institute Of Technology And Management");
        clg.setBounds(55, 70, 700, 27);
        clg.setFont(new Font("Arial", Font.BOLD, 23));
        clg.setForeground(new Color(0x650529));
        add(clg);
        Label l1 = new Label("For User Only :");
        l1.setBounds(180, 160, 150, 25);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 17));
        l1.setForeground(Color.BLACK);
        add(l1);

        b1 = new Button("Register");
        b1.setBounds(410, 160, 120, 25);
        b1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        b1.setForeground(Color.BLACK);
        add(b1);
        b1.addActionListener(this);

        Label l2 = new Label("For Administrator :");
        l2.setBounds(180, 210, 210, 25);
        l2.setFont(new Font("Segoe UI", Font.BOLD, 17));
        l2.setForeground(Color.BLACK);
        add(l2);

        b2 = new Button("Register");
        b2.setBounds(410, 210, 120, 25);
        b2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        b2.setForeground(Color.BLACK);
        add(b2);
        b2.addActionListener(this);

        Button back = new Button("Back");
        back.setBounds(500, 270, 70, 25);
        back.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        back.setForeground(Color.BLACK);
        add(back);
        back.addActionListener(this);

        Label l = new Label("Welcome To My Abstract Windowing Toolkit  Project  ");
        l.setBounds(120, 330, 700, 25);
        l.setFont(new Font("Arial", Font.BOLD, 20));
        l.setForeground(new Color(0x650529));
        add(l);
        Label sign = new Label("&copy; 2023 Balram Shukla");
        sign.setBounds(290, 353, 250, 23);
        sign.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        sign.setForeground(Color.BLACK);
        add(sign);


    }

    public static void main(String[] args) {
        Registration r=new Registration();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Back")){
            setVisible(false);
            new Welcome();
        }
        if(e.getSource()==b1){
            setVisible(false);
            new UserRegi("User","");
        }
        if(e.getSource()==b2){
            setVisible(false);
            new AdminRegi();
        }
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
