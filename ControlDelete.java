import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
public class ControlDelete extends JFrame implements ActionListener, WindowListener {

    ControlDelete() {

        setTitle("Delete Admin");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.lightGray);
        setVisible(true);

        JLabel welcomeLabel = new JLabel("Welcome to Admin Controller Window..!");
        welcomeLabel.setBounds(35, 45, 500, 25);
        welcomeLabel.setFont(new Font("Book Antique", Font.BOLD, 22));
        welcomeLabel.setForeground(new Color(0x650529));
        add(welcomeLabel);

        JLabel l1 = new JLabel("User_ID :");
        l1.setBounds(60, 100, 370, 25);
        l1.setFont(new Font("Book Antique", Font.BOLD, 17));
        l1.setForeground(new Color(0x010410));
        add(l1);
        JTextField t = new JTextField();
        t.setBounds(245, 100, 200, 25);
        t.setFont(new Font("Book Antique", Font.BOLD, 14));
        t.setForeground(new Color(0x01081F));
        add(t);

        JLabel l2 = new JLabel("User Password :");
        l2.setBounds(60, 140, 370, 25);
        l2.setFont(new Font("Book Antique", Font.BOLD, 17));
        l2.setForeground(new Color(0x010410));
        add(l2);
        JTextField t1 = new JTextField();
        t1.setBounds(245, 140, 200, 25);
        t1.setFont(new Font("Book Antique", Font.BOLD, 14));
        t1.setForeground(new Color(0x01081F));
        add(t1);

        JButton back = new JButton("Back");
        back.setForeground(Color.darkGray);
        back.setBounds(270, 225, 85, 25);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new showUsersControl();
            }
        });
        add(back);

        JButton clear = new JButton("Clear");
        clear.setForeground(Color.darkGray);
        clear.setBounds(270, 195, 85, 25);

        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText("");
            }
        });
        add(clear);

        JButton delete = new JButton("Delete");
        delete.setForeground(Color.RED);
        delete.setBounds(360, 195, 85, 25);

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String idToDelete = t.getText();
                String Password = t1.getText();

                if(t.getText().isEmpty() || t1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"No Field Should Empty");
                }
                else {

                    try {
                        String url = "jdbc:mysql://localhost:3306/login";
                        String username = "root"; // MySQL credentials
                        String dbPassword = "";

                        try (Connection connection = DriverManager.getConnection(url, username, dbPassword)) {

                            String selectSql = "SELECT Password FROM logindetail WHERE User_ID = ?";

                            try (PreparedStatement selectStatement = connection.prepareStatement(selectSql)) {
                                selectStatement.setString(1, idToDelete);
                                //selectStatement.setString(2, Password);

                                try (ResultSet rs = selectStatement.executeQuery()) {

                                    if (rs.next()) {

                                        String paas = rs.getString("Password");

                                        if (Objects.equals(Password, paas)) {

                                            String deleteSql = "DELETE FROM logindetail WHERE User_ID = ?";
                                            PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
                                            deleteStatement.setString(1, idToDelete);
                                            int rowsAffected = deleteStatement.executeUpdate();

                                            System.out.println("user Deleted Successfully");
                                            JOptionPane.showMessageDialog(null, "User Deleted Successfully");

                                            t.setText("");
                                            t1.setText("");
                                        } else {
                                            System.out.println("Invalid Password");
                                            JOptionPane.showMessageDialog(null, "Invalid Password");
                                        }
                                    } else {
                                        System.out.println("Id Not Found");
                                        JOptionPane.showMessageDialog(null, "No User Registered With This ID");
                                    }
                                }
                            }
                        }
                    } catch (SQLException ee) {
                        System.out.println("Exception error :" + ee);
                        JOptionPane.showMessageDialog(null, "Database Error");
                    }
                }
            }
        });
        add(delete);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setForeground(Color.red);
        logoutButton.setBounds(360, 225, 85, 25);

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login awt = new Login();
                awt.setVisible(true);
            }
        });
        add(logoutButton);


        ImageIcon icon = new ImageIcon("C:\\Users\\BalramShukla\\IdeaProjects\\Project\\src\\picture.jpg");
        setIconImage(icon.getImage());

    }


    public static void main(String[] args) {
        ControlDelete ct = new ControlDelete();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

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
