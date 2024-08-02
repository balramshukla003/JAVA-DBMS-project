import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AdminRegi extends Frame implements ActionListener, WindowListener,MouseListener {

    Label l,l1,l2,l3,error,d;
    Button back,close,submit,clr,tg;
    TextField t1,t2,t3;
    Frame r=new Frame();

    AdminRegi(){

        setTitle("Admin Registration ");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setBackground(new Color(0xE1C99A));
        setResizable(false);
        addWindowListener(this);

        l = new Label(" Admin Registration ");
        l.setBounds(150, 50, 250, 25);
        l.setFont(new Font("Segoe UI", Font.BOLD, 20));
        l.setForeground(new Color(0x650529));
        add(l);


        l1 = new Label("Name :");
        l1.setBounds(75, 100, 120, 25);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 17));
        l1.setForeground(Color.BLACK);
        add(l1);
        t1 = new TextField();
        t1.setBounds(245, 100, 200, 20);
        t1.setFont(new Font("Segoe UI", Font.BOLD, 13));
        add(t1);

        l2 = new Label("User ID :");
        l2.setBounds(75, 140, 150, 25);
        l2.setFont(new Font("Segoe UI", Font.BOLD, 17));
        l2.setForeground(Color.BLACK);
        add(l2);
        t2 = new TextField();
        t2.setBounds(245, 140, 200, 20);
        t2.setFont(new Font("Segoe UI", Font.BOLD, 13));
        add(t2);


        l3 = new Label("Password :");
        l3.setBounds(75, 180, 150, 25);
        l3.setFont(new Font("Segoe UI", Font.BOLD, 17));
        l3.setForeground(Color.BLACK);
        add(l3);
        t3 = new TextField();
        t3.setBounds(245, 180, 175, 20);
        t3.setFont(new Font("Segoe UI", Font.BOLD, 17));
        t3.setEchoChar('*');
        add(t3);

        tg = new Button("V");
        tg.setBounds(420, 180, 20, 20);
        tg.setFont(new Font("Segoe UI", Font.BOLD, 13));
        tg.setForeground(Color.BLACK);
        tg.addMouseListener(this);
        add(tg);


        error =new Label("");
        error.setBounds(245, 200, 280, 25);
        error.setFont(new Font("Segoe UI", Font.ITALIC, 10));
        error.setForeground(Color.red);
        add(error);

        clr = new Button("Clear");
        clr.setBounds(310, 225, 65, 23);
        clr.setFont(new Font("Segoe UI", Font.BOLD, 13));
        clr.setForeground(Color.BLACK);
        add(clr);
        clr.addActionListener(this);

        submit = new Button("Submit");
        submit.setBounds(380, 225, 65, 23);
        submit.setFont(new Font("Segoe UI", Font.BOLD, 13));
        submit.setForeground(Color.BLACK);
        add(submit);
        submit.addActionListener(this);

        back = new Button("Back");
        back.setBounds(310, 255, 65, 23);
        back.setFont(new Font("Segoe UI", Font.BOLD, 13));
        back.setForeground(Color.BLACK);
        add(back);
        back.addActionListener(this);

        close = new Button("Close");
        close.setBounds(380, 255, 65, 23);
        close.setFont(new Font("Segoe UI", Font.BOLD, 13));
        close.setForeground(Color.BLACK);
        add(close);
        close.addActionListener(this);

    }



    public static void main(String[] args) {
        AdminRegi r=new AdminRegi();
    }





    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Back")) {
            setVisible(false);
            new Registration();
        }
        if (e.getActionCommand().equals("Close")) {
            System.exit(0);
        }
        if (e.getActionCommand().equals("Clear")) {
            error.setText("");
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }

        if (e.getActionCommand().equals("Submit")) {

            String name;
            name = t1.getText();

            r.setTitle("Dialogue Box");
            r.setSize(330, 150);
            r.setLayout(null);
            r.setBackground(Color.LIGHT_GRAY);
            r.setLocationRelativeTo(null);
            r.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    r.setVisible(false);
                }
            });
            d = new Label("");
            d.setBounds(60, 68, 350, 35);
            d.setFont(new Font("Segue UI", Font.BOLD, 17));
            d.setForeground(new Color(0x980F0F));
            r.add(d);



            if (t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("")) {
                d.setText("No Field Should Empty");
                r.setVisible(true);
            } else {

                if (Objects.equals(name, "Ajay Tandon") || Objects.equals(name, "ajay tandon") ||
                        Objects.equals(name, "Akhilesh Pathak") || Objects.equals(name, "akhilesh pathak") ||
                        Objects.equals(name, "Balram Shukla") || Objects.equals(name, "balram shukla")) {

                    String id, nam, pass;
                    id = t2.getText();

                    try {

                        String url = "jdbc:mysql://localhost:3306/login";
                        String username = "root"; // MySQL credentials
                        String password = "";
                        Connection connection = DriverManager.getConnection(url, username, password);

                        String sql = "SELECT User_ID FROM logindetail where User_ID=?";
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, id);


                        ResultSet rs = preparedStatement.executeQuery();

                        if (rs.next()) {

                            String column1Value = rs.getString("User_ID");
                            d.setText("Admin_ID Already Exits");
                            r.setVisible(true);
                            connection.close();

                        } else {

                            nam = t1.getText();
                            pass = t3.getText();

                            sql = "INSERT INTO logindetail values(?,?,?)";
                            preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setString(1, nam);
                            preparedStatement.setString(2, id);
                            preparedStatement.setString(3, pass);

                            int rowsAffected = preparedStatement.executeUpdate();

                            if (rowsAffected > 0) {

                                //error.setText("Added Successfully");
                                System.out.println("Data Added Successfully");

                                error.setText("");
                                t1.setText("");
                                t2.setText("");
                                t3.setText("");
                                new dialogueBox("Admin","","");

                            } else {
                                d.setText("Data Not Added");
                                r.setVisible(true);
                            }

                        }

                    } catch (Exception ev) {
                        d.setText("Database is Not Connected");
                        r.setVisible(true);
                    }

                } else {
                    d.setText("Not Eligible For Registration");
                    r.setVisible(true);
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
            t3.setFont(new Font("Segoe UI", Font.BOLD, 13));
            t3.setEchoChar('\0');
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource().equals(tg)) {
            t3.setFont(new Font("Segoe UI", Font.BOLD, 17));
            t3.setEchoChar('*');
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
