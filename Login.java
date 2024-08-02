import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends Frame implements ActionListener, WindowListener,MouseListener {

    String Id;
    Button login,clear,back,close,tg;
    Label l,l1,l2,error;
    TextField t1,t2;

    Login(){


        setTitle("Login Window");
        setSize(550, 350);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setBackground(new Color(0xC5B57D));
        setResizable(false);
        addWindowListener(this);





        l = new Label("Login Credential");
        l.setBounds(180, 60, 250, 30);
        l.setFont(new Font("Segoe UI", Font.BOLD, 25));
        l.setForeground(new Color(0x650529));
        add(l);


        l1 = new Label("User ID :");
        l1.setBounds(80, 150, 100, 25);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 17));
        l1.setForeground(Color.BLACK);
        add(l1);
        t1 = new TextField();
        t1.setBounds(250, 150, 200, 20);
        t1.setFont(new Font("Segoe UI", Font.BOLD, 13));
        add(t1);

        l2 = new Label("Password :");
        l2.setBounds(80, 200, 150, 25);
        l2.setFont(new Font("Segoe UI", Font.BOLD, 17));
        l2.setForeground(Color.BLACK);
        add(l2);
        t2 = new TextField();
        t2.setBounds(250, 200, 183, 20);
        t2.setFont(new Font("Segoe UI", Font.BOLD, 17));
        t2.setEchoChar('*');
        add(t2);

        tg=new Button("V");
        tg.setBounds(432,200,20,21);
        tg.setFont(new Font("Segoe UI", Font.BOLD, 13));
        tg.setBackground(new Color(0xC5B57D));
        tg.addMouseListener(this);
        add(tg);


        error = new Label("");
        error.setBounds(250, 225, 200, 20);
        error.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        error.setForeground(Color.red);
        add(error);


        login = new Button("Login");
        login.setBounds(335, 270, 65, 25);
        login.setFont(new Font("Segoe UI", Font.BOLD, 16));
        login.setForeground(new Color(0x1313A1));
        add(login);
        login.addActionListener(this);

        back = new Button("Back");
        back.setBounds(335, 305, 65, 25);
        back.setFont(new Font("Segoe UI", Font.BOLD, 16));
        back.setForeground(new Color(0x751023));
        add(back);
        back.addActionListener(this);

        clear = new Button("Clear");
        clear.setBounds(410, 270, 65, 25);
        clear.setFont(new Font("Segoe UI", Font.BOLD, 16));
        clear.setForeground(new Color(0x298615));
        add(clear);
        clear.addActionListener(this);

        close = new Button("Close");
        close.setBounds(410, 305, 65, 25);
        close.setFont(new Font("Segoe UI", Font.BOLD, 16));
        close.setForeground(new Color(0xE52323));
        add(close);
        close.addActionListener(this);



    }


    public static void main(String[] args) {
        Login l=new Login();
    }








    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Back")){
            setVisible(false);
            new Welcome();
        }
        if(e.getActionCommand().equals("Clear")){
            error.setText("");
            t1.setText("");
            t2.setText("");
        }
        if(e.getActionCommand().equals("Close")){
            System.exit(0);
        }
        if(e.getActionCommand().equals("Login")) {

            if(t1.getText().equals("Balram Shukla") && (t2.getText().equals("controller"))){
                setVisible(false);
                new adminController();
            }

            if (t1.getText().equals("") || t2.getText().equals("")) {
                error.setText("No Field Should Empty");
            } else {

                String pa = t2.getText(),
                        user = t1.getText();
                try {

                    String url = "jdbc:mysql://localhost:3306/login";
                    String username = "root"; // MySQL credentials
                    String password = "";
                    Connection connection = DriverManager.getConnection(url, username, password);

                    String sql = "SELECT Name FROM logindetail WHERE User_ID = ? and Password =?";

                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,user);
                    preparedStatement.setString(2,pa);
                    ResultSet rs = preparedStatement.executeQuery();

                    if (rs.next()) {

                        String nam = rs.getString("Name");

                        if (!nam.equals("---")) {
                            connection.close();
                            setVisible(false);
                            Id= t1.getText();
                            new Admin_Logged_IN(Id);
                            System.out.println("Admin Login Called");
                        } else {
                            connection.close();
                            setVisible(false);
                            Id=t1.getText();
                            new User_Logged_IN("User",Id);
                            System.out.println("User Login Called");
                        }


                    } else {

                        error.setText("Invalid User or Password");

                    }


                } catch (Exception ev) {

                    error.setText("Connection Error To DB");
                    System.out.println("Error " + ev);
                }
            }
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource().equals(tg)){
            t2.setFont(new Font("Segoe UI", Font.BOLD, 13));
            t2.setEchoChar('\0');
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource().equals(tg)) {
            t2.setFont(new Font("Segoe UI", Font.BOLD, 17));
            t2.setEchoChar('*');
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
