import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class resetPassword extends Frame implements WindowListener, ActionListener,MouseListener {
    TextField  paasField,nepF;
    Label search, error, pass,userID,newpa;
    Button resetButton, closeButton, clearButton, backButton,tg,tg1;
    String k,ID;
    resetPassword(String id ,String a){

        ID=id;
        k=a;

        setTitle("ResettingPassword Window");
        setBounds(500,170,600, 350);

        setLayout(null);
        setVisible(true);
        setBackground(new Color(0xDAD5D5));
        setResizable(false);
        addWindowListener(this);

        search = new Label("User_ID :");
        search.setFont(new Font("Book Antica", Font.BOLD, 17));
        search.setForeground(new Color(0x650529));
        search.setBounds(45, 100, 230, 25);
        add(search);

        pass = new Label("Current Password :");
        pass.setFont(new Font("Book Antica", Font.BOLD, 17));
        pass.setForeground(new Color(0x650529));
        pass.setBounds(45, 140, 230, 25);
        add(pass);

        newpa = new Label("New Password :");
        newpa.setFont(new Font("Book Antica", Font.BOLD, 17));
        newpa.setForeground(new Color(0x650529));
        newpa.setBounds(45, 180, 230, 25);
        add(newpa);

        userID = new Label(ID);
        userID.setBounds(280, 100, 230, 25);
        userID.setFont(new Font("Book Antica", Font.BOLD, 17));
        userID.setForeground(new Color(0x650529));
        add(userID);

        paasField = new TextField();
        paasField.setBounds(280, 140, 150, 24);
        paasField.setFont(new Font("arial", Font.BOLD, 17));
        paasField.setEchoChar('*');
        add(paasField);

        tg = new Button("V");
        tg.setBounds(430, 140, 20, 23);
        tg.setForeground(new Color(0x193756));
        tg.setFont(new Font("arial", Font.BOLD, 13));
        tg.addMouseListener(this);
        add(tg);

        nepF = new TextField();
        nepF.setBounds(280, 180, 150, 24);
        nepF.setFont(new Font("arial", Font.BOLD, 17));
        nepF.setEchoChar('*');
        add(nepF);

        tg1 = new Button("V");
        tg1.setBounds(430, 180, 20, 23);
        tg1.setForeground(new Color(0x193756));
        tg1.setFont(new Font("arial", Font.BOLD, 13));
        tg1.addMouseListener(this);
        add(tg1);

        error =new Label("");
        error.setBounds(280, 205, 490, 20);
        error.setFont(new Font("Book Antica", Font.BOLD, 12));
        error.setForeground(Color.red);
        add(error);




        clearButton = new Button("Clear");
        clearButton.setBounds(425, 270, 65, 25);
        clearButton.setForeground(new Color(0x193756));
        clearButton.setFont(new Font("arial", Font.BOLD, 14));
        add(clearButton);
        clearButton.addActionListener(this);

        backButton = new Button("Back");
        backButton.setBounds(425, 300, 65, 25);
        backButton.setForeground(new Color(0x1C020B));
        backButton.setFont(new Font("arial", Font.BOLD, 14));
        add(backButton);
        backButton.addActionListener(this);

        resetButton = new Button("Reset");
        resetButton.setBounds(495, 270, 65, 25);
        resetButton.setForeground(new Color(0x527C1E));
        resetButton.setFont(new Font("arial", Font.BOLD, 14));
        add(resetButton);
        resetButton.addActionListener(this);

        closeButton = new Button("Close");
        closeButton.setBounds(495, 300, 65, 25);
        closeButton.setFont(new Font("arial", Font.BOLD, 14));
        closeButton.setForeground(new Color(0x77123F));
        add(closeButton);
        closeButton.addActionListener(this);

    }













    public static void main(String[] args) {
        resetPassword r=new resetPassword("","");
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getActionCommand().equals("Close")) {
            System.exit(0);
        }

        if (e.getActionCommand().equals("Clear")) {
            paasField.setText("");
            nepF.setText("");
            error.setText("");
        }

        if (e.getActionCommand().equals("Back")) {
            if (Objects.equals(k, "Admin")) {
                setVisible(false);
                new Admin_Logged_IN(ID);

            }
            if (Objects.equals(k, "User")) {
                setVisible(false);
                new User_Logged_IN("User", ID);
            }

        }
        if (e.getActionCommand().equals("Reset")) {

            String cp = paasField.getText();
            String np = nepF.getText();

            try {

                String url = "jdbc:mysql://localhost:3306/login";
                String username = "root"; // MySQL credentials
                String password = "";
                Connection connection = DriverManager.getConnection(url, username, password);

                String sql = "SELECT Password FROM logindetail WHERE User_ID = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, ID);

                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {

                    String pas = rs.getString("Password");

                    if(Objects.equals(cp,np)){
                        error.setText("New Password Should Be Defer");
                    }else {

                        if (Objects.equals(cp,pas)) {

                            System.out.println("Password Updating");

                            sql = "update logindetail set Password=? where User_ID=?";
                            preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setString(1, np);
                            preparedStatement.setString(2, ID);

                            int rowsAffected = preparedStatement.executeUpdate();
                            if (rowsAffected > 0) {
                                error.setText("Password Updated");
                                nepF.setText("");
                                paasField.setText("");
                                System.out.println("Password Updated");
                            } else {
                                error.setText("Some Error");
                                System.out.println("Password Not Updated");
                            }


                        }
                        else{
                            error.setText("Incorrect Password");
                        }
                    }

                }
                else {
                    error.setText("Incorrect Password");
                }
            }
            catch (Exception ev) {
                System.out.println(ev);
                error.setText("Connection Established Unsuccessful");

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
            paasField.setFont(new Font("Segue UI", Font.BOLD, 13));
            paasField.setEchoChar('\0');
        }
        if(e.getSource().equals(tg1)){
            nepF.setFont(new Font("Segue UI", Font.BOLD, 13));
            nepF.setEchoChar('\0');
        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource().equals(tg)){
            paasField.setFont(new Font("Segue UI", Font.BOLD, 17));
            paasField.setEchoChar('*');
        }
        if(e.getSource().equals(tg1)){
            nepF.setFont(new Font("Segue UI", Font.BOLD, 17));
            nepF.setEchoChar('*');
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
