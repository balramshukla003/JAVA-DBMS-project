import java.awt.*;
import java.awt.event.*;
public class Welcome extends Frame implements ActionListener,WindowListener {

    Welcome() {

        setTitle("Welcome Window");
        setSize(750, 450);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setBackground(new Color(0xFFBDF2));
        setResizable(false);
        addWindowListener(this);

        Label l = new Label("Welcome To My Abstract Windowing Toolkit  Project  ");
        l.setBounds(120, 358, 700, 25);
        l.setFont(new Font("Arial", Font.BOLD, 20));
        l.setForeground(new Color(0x650529));
        add(l);
        Label sign = new Label("&copy; 2023 Balram Shukla");
        sign.setBounds(290, 383, 250, 23);
        sign.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        sign.setForeground(Color.BLACK);
        add(sign);

        Label clg = new Label("Meena Shah Institute Of Technology And Management");
        clg.setBounds(85, 85, 700, 27);
        clg.setFont(new Font("Arial", Font.BOLD, 23));
        clg.setForeground(new Color(0x650529));
        add(clg);

        Label l1 = new Label("For New User :");
        l1.setBounds(200, 195, 150, 25);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 17));
        l1.setForeground(Color.BLACK);
        add(l1);

        Button b1 = new Button("Register");
        b1.setBounds(410, 195, 120, 25);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 17));
        b1.setForeground(new Color(0x67571F));
        add(b1);
        b1.addActionListener(this);

        Label l2 = new Label("For Existing User :");
        l2.setBounds(200, 245, 150, 25);
        l2.setFont(new Font("Segoe UI", Font.BOLD, 17));
        l2.setForeground(Color.BLACK);
        add(l2);

        Button b2 = new Button("Login");
        b2.setBounds(410, 245, 120, 25);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b2.setForeground(new Color(0x141493));
        add(b2);
        b2.addActionListener(this);

        Button b3 = new Button("Close");
        b3.setBounds(500, 305, 70, 25);
        b3.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b3.setForeground(new Color(0xC01730));
        add(b3);
        b3.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Register")){

            setVisible(false);
            new Registration();

        }

        if(e.getActionCommand().equals("Login")){
            setVisible(false);
            new Login();
        }

        if(e.getActionCommand().equals("Close")){
            System.exit(0);
        }

    }


    public static void main(String[] args) {
        Welcome w= new Welcome();
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
